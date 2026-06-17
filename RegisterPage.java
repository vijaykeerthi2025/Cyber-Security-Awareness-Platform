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
import java.awt.event.*;
import java.sql.*;
public class RegisterPage extends JFrame {
   

   

    private JTextField txtName;
    private JTextField txtEmail;
    private JPasswordField txtPassword;

    private StyledButton btnRegister;
    private StyledButton btnLogin;

    public RegisterPage() {

        setTitle("User Registration");

        setSize(900,600);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        ImagePanel background =
                new ImagePanel(
                        "images/register_bg.jpg");

        background.setLayout(
                new GridBagLayout());

        JPanel registerCard =
                new JPanel();

        registerCard.setPreferredSize(
                new Dimension(450,450));

        registerCard.setBackground(
                new Color(255,255,255,220));

        registerCard.setLayout(null);

        JLabel logoLabel =
                new JLabel();

        ImageIcon logo =
                new ImageIcon(
                        "images/logo.jpg");

        Image img =
                logo.getImage()
                        .getScaledInstance(
                                80,
                                80,
                                Image.SCALE_SMOOTH);

        logoLabel.setIcon(
                new ImageIcon(img));

        logoLabel.setBounds(
                185,
                10,
                80,
                80);

        JLabel title =
                new JLabel(
                        "Create Account",
                        SwingConstants.CENTER);

        title.setFont(
                Theme.TITLE_FONT);

        title.setForeground(
                Theme.DARK_BLUE);

        title.setBounds(
                20,
                90,
                400,
                40);

        JLabel lblName =
                new JLabel("Full Name");

        lblName.setFont(
                Theme.CONTENT_FONT);

        lblName.setBounds(
                50,
                150,
                120,
                30);

        txtName =
                new JTextField();

        txtName.setBounds(
                50,
                180,
                330,
                35);

        JLabel lblEmail =
                new JLabel("Email");

        lblEmail.setFont(
                Theme.CONTENT_FONT);

        lblEmail.setBounds(
                50,
                225,
                120,
                30);

        txtEmail =
                new JTextField();

        txtEmail.setBounds(
                50,
                255,
                330,
                35);

        JLabel lblPassword =
                new JLabel("Password");

        lblPassword.setFont(
                Theme.CONTENT_FONT);

        lblPassword.setBounds(
                50,
                300,
                120,
                30);

        txtPassword =
                new JPasswordField();

        txtPassword.setBounds(
                50,
                330,
                330,
                35);

        btnRegister =
                new StyledButton(
                        "Register");

        btnRegister.setBounds(
                50,
                390,
                140,
                40);

        btnLogin =
                new StyledButton(
                        "Back To Login");

        btnLogin.setBounds(
                220,
                390,
                160,
                40);

        registerCard.add(
                logoLabel);

        registerCard.add(
                title);

        registerCard.add(
                lblName);

        registerCard.add(
                txtName);

        registerCard.add(
                lblEmail);

        registerCard.add(
                txtEmail);

        registerCard.add(
                lblPassword);

        registerCard.add(
                txtPassword);

        registerCard.add(
                btnRegister);

        registerCard.add(
                btnLogin);

        background.add(
                registerCard);

        setContentPane(
                background);

        btnRegister.addActionListener(
                e -> registerUser());

        btnLogin.addActionListener(
                e -> {

                    new LoginPage()
                            .setVisible(true);

                    dispose();
                });
    }

    private void registerUser() {

        String name =
                txtName.getText();

        String email =
                txtEmail.getText();

        String password =
                String.valueOf(
                        txtPassword.getPassword());

        if(name.isEmpty()
                || email.isEmpty()
                || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields");

            return;
        }

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO users(fullname,email,password)"
                    + " VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(
                    1,
                    name);

            ps.setString(
                    2,
                    email);

            ps.setString(
                    3,
                    password);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Registration Successful");

            new LoginPage()
                    .setVisible(true);

            dispose();

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage());
        }
    }
}