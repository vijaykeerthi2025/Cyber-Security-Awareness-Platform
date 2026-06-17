/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VIJAYAKUMAR K G
 */
import javax.swing.*;
import java.awt.*;
public class ImagePanel extends JPanel{
    



    private Image backgroundImage;

    public ImagePanel(String imagePath) {

        backgroundImage =
                new ImageIcon(imagePath)
                        .getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(
                backgroundImage,
                0,
                0,
                getWidth(),
                getHeight(),
                this);
    }
}

