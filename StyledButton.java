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
public class StyledButton extends JButton {
    

    public StyledButton(String text) {

        super(text);

        setBackground(
                Theme.CYAN);

        setForeground(
                Color.WHITE);

        setFont(
                Theme.BUTTON_FONT);

        setFocusPainted(false);
    }
}

