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
public class LoginPage extends JFrame {
    
 

    

    private JTextField txtEmail;
    private JPasswordField txtPassword;

    private StyledButton btnLogin;
    private StyledButton btnRegister;

    public LoginPage() {

        setTitle("Cyber Security Awareness Platform");

        setSize(900, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        ImagePanel background =
                new ImagePanel("images/login_bg.jpg");

        background.setLayout(new GridBagLayout());

        JPanel loginCard = new JPanel();

        loginCard.setPreferredSize(
                new Dimension(400, 380));

        loginCard.setBackground(
                new Color(255,255,255,220));

        loginCard.setLayout(null);

        JLabel logoLabel = new JLabel();

        ImageIcon logo =
                new ImageIcon("images/logo.jpg");

        Image img =
                logo.getImage()
                        .getScaledInstance(
                                80,
                                80,
                                Image.SCALE_SMOOTH);

        logoLabel.setIcon(
                new ImageIcon(img));

        logoLabel.setBounds(
                160,
                10,
                80,
                80);

        JLabel title =
                new JLabel(
                        "Cyber Security Platform",
                        SwingConstants.CENTER);

        title.setFont(
                Theme.TITLE_FONT);

        title.setForeground(
                Theme.DARK_BLUE);

        title.setBounds(
                20,
                90,
                360,
                40);

        JLabel lblEmail =
                new JLabel("Email");

        lblEmail.setFont(
                Theme.CONTENT_FONT);

        lblEmail.setBounds(
                40,
                150,
                100,
                30);

        txtEmail =
                new JTextField();

        txtEmail.setBounds(
                40,
                180,
                300,
                35);

        JLabel lblPassword =
                new JLabel("Password");

        lblPassword.setFont(
                Theme.CONTENT_FONT);

        lblPassword.setBounds(
                40,
                225,
                100,
                30);

        txtPassword =
                new JPasswordField();

        txtPassword.setBounds(
                40,
                255,
                300,
                35);

        btnLogin =
                new StyledButton("Login");

        btnLogin.setBounds(
                40,
                310,
                140,
                40);

        btnRegister =
                new StyledButton("Register");

        btnRegister.setBounds(
                200,
                310,
                140,
                40);

        loginCard.add(logoLabel);

        loginCard.add(title);

        loginCard.add(lblEmail);

        loginCard.add(txtEmail);

        loginCard.add(lblPassword);

        loginCard.add(txtPassword);

        loginCard.add(btnLogin);

        loginCard.add(btnRegister);

        background.add(loginCard);

        setContentPane(background);

        btnLogin.addActionListener(
                e -> loginUser());

        btnRegister.addActionListener(
                e -> {

                    new RegisterPage()
                            .setVisible(true);

                    dispose();
                });
    }

    private void loginUser() {

        String email =
                txtEmail.getText();

        String password =
                String.valueOf(
                        txtPassword.getPassword());

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM users "
                    + "WHERE email=? "
                    + "AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1,email);

            ps.setString(2,password);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                Session.userId =
                        rs.getInt("id");

                Session.username =
                        rs.getString("fullname");

                JOptionPane.showMessageDialog(
                        this,
                        "Welcome "
                                + Session.username);

                new Dashboard()
                        .setVisible(true);

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Email or Password");
            }

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage());
        }
    }
}