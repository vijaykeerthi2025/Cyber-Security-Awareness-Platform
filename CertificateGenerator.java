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
public class CertificateGenerator extends JFrame {
    



    public CertificateGenerator(
            String studentName,
            int score,
            int total) {

        setTitle("Certificate");

        setSize(700,400);

        setLocationRelativeTo(null);

        JTextArea area =
                new JTextArea();

        area.setEditable(false);

        area.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        18));

        area.setText(

                "=====================================\n\n"

                + "      CERTIFICATE OF COMPLETION\n\n"

                + "This Certifies That\n\n"

                + studentName

                + "\n\nHas Successfully Completed\n\n"

                + "Cyber Security Awareness Training\n\n"

                + "Score : "

                + score

                + " / "

                + total

                + "\n\n====================================="
        );

        add(new JScrollPane(area));
    }
}