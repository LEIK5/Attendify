package com.groupsix.attendify.qrgenerator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GenerateQrcode {


    public static void generateQRCode(StudentInformation studentInfo, int width, int height, String pdfFilePath) 
            throws WriterException, IOException {
        
        String qrContent = "Full Name: " + studentInfo.getFullName() + "\nStudent Number: " + studentInfo.getStudentNumber();

        // Generate QR Code image
        QRCodeWriter qc = new QRCodeWriter();
        BitMatrix bm = qc.encode(studentInfo.getStudentNumber(), BarcodeFormat.QR_CODE, width, height);

        // Convert BitMatrix to byte array
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bm, "PNG", bos);
        byte[] qrImageData = bos.toByteArray();

        try ( // Generate PDF with QR Code and student details
                PDDocument document = new PDDocument()) {
            
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                
                // Draw QR Code centered on the PDF
                float qrX = (PDRectangle.A4.getWidth() - width / 4) / 2;
                float qrY = PDRectangle.A4.getHeight() - 100 - height / 4; // Adjusted position from bottom
                PDImageXObject qrImage = PDImageXObject.createFromByteArray(document, qrImageData, "QR Code");
                contentStream.drawImage(qrImage, qrX, qrY, width / 4, height / 4);
                
                // Write student details
                float textX = 100; // X position for text
                float textY = 200; // Y position for text - adjust this value to move higher
                
                // Write student details at the top
                contentStream.beginText();
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 14);
                contentStream.newLineAtOffset(textX, textY);
                contentStream.showText("Student Information:");
                contentStream.newLine();
                
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
                
                // Write full name
                contentStream.newLineAtOffset(0, -15); // adjust y-coordinate
                contentStream.showText("Full Name: ");
                contentStream.newLineAtOffset(100, 0); // indent for the value
                contentStream.showText(studentInfo.getFullName());
                contentStream.newLineAtOffset(-100, 0); // reset indent
                
                // Write student number
                contentStream.newLineAtOffset(0, -15); // adjust y-coordinate
                contentStream.showText("Student Number: ");
                contentStream.newLineAtOffset(100, 0); // indent for the value
                contentStream.showText(studentInfo.getStudentNumber());
                contentStream.newLineAtOffset(-100, 0); // reset indent
                
                contentStream.endText();
            }
            document.save(pdfFilePath);
        }
    }

//    public static void main(String[] args) throws WriterException, IOException {
//        StudentInformation studentInfo = new StudentInformation("Juan D. Cruz", "2022-00220-SR-0");
//        String surname = studentInfo.getFullName().split(" ")[studentInfo.getFullName().split(" ").length - 1];
//        String pdfFilePath = "D:\\QR Code\\" + surname + "_Attendance.pdf";
//        generateQRCode(studentInfo, 1250, 1250, pdfFilePath);
//    }
}

