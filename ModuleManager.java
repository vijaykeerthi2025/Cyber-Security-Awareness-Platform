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
import java.sql.*;
public class ModuleManager extends JFrame {
    



    JTextField txtTitle;
    JTextArea txtContent;
    JButton btnSave;

    public ModuleManager() {

        setTitle("Module Manager");

        setSize(600,500);

        setLocationRelativeTo(null);

        txtTitle = new JTextField();

        txtContent = new JTextArea();

        btnSave = new JButton("Save Module");

        setLayout(new BorderLayout());

        add(txtTitle,BorderLayout.NORTH);

        add(new JScrollPane(txtContent),
                BorderLayout.CENTER);

        add(btnSave,BorderLayout.SOUTH);

        btnSave.addActionListener(
                e -> saveModule());
    }

    private void saveModule() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO modules(title,content) VALUES(?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1,
                    txtTitle.getText());

            ps.setString(2,
                    txtContent.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Module Saved");

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage());
        }
    }
}
    

