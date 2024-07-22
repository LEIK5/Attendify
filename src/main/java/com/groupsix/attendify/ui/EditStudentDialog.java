package com.groupsix.attendify.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditStudentDialog extends JDialog {
    private final JTextField lastNameField;
    private final JTextField firstNameField;
    private final JTextField middleNameField;
    private final JTextField imagePathField;
    private final JTextField sectionField;
    private boolean updateStatus;

    public EditStudentDialog(JFrame parent, String studentNumber, String lastName, String firstName, String middleName, String imagePath, String section) {
        super(parent, "Edit Student", true);

        // Initialize fields with provided data
        lastNameField = new JTextField(lastName);
        firstNameField = new JTextField(firstName);
        middleNameField = new JTextField(middleName);
        imagePathField = new JTextField(imagePath);
        sectionField = new JTextField(section);

        // Create OK and Cancel buttons
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStatus = true;
                dispose(); // Close the dialog
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStatus = false;
                dispose(); // Close the dialog
            }
        });

        // Create panel and set layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        
        // Add components to the panel
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Middle Name:"));
        panel.add(middleNameField);
        panel.add(new JLabel("Image Path:"));
        panel.add(imagePathField);
        panel.add(new JLabel("Section:"));
        panel.add(sectionField);
        panel.add(okButton);
        panel.add(cancelButton);

        // Set content pane of the dialog
        setContentPane(panel);

        // Set dialog size and location
        setSize(300, 240);
        setLocationRelativeTo(parent);

        // Make the dialog modal
        setModal(true);
    }

    // Getter methods for retrieving edited data
    public String getLastName() {
        return lastNameField.getText();
    }

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getMiddleName() {
        return middleNameField.getText();
    }

    public String getImagePath() {
        return imagePathField.getText();
    }

    public String getSection() {
        return sectionField.getText();
    }

    public boolean getUpdateStatus() {
        return updateStatus;
    }
}
