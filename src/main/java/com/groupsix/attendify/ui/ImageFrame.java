/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groupsix.attendify.ui;

import javax.swing.*;
import java.awt.*;

public class ImageFrame extends JFrame {
    private Image image;

    public ImageFrame(Image image) {
        super();
        this.image = image;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(image.getWidth(null), image.getHeight(null)));
        setLocationRelativeTo(null);

        JLabel label = new JLabel(new ImageIcon(image));
        getContentPane().add(label);
    }

    public void showImage() {
        setVisible(true);
    }
}