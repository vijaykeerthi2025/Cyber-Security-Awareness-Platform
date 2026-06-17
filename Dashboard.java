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
public class Dashboard extends JFrame {
    

    private JLabel lblWelcome;
    private JLabel lblTitle;

    private StyledButton btnModule1;
    private StyledButton btnModule2;
    private StyledButton btnModule3;
    private StyledButton btnModule4;
    private StyledButton btnModule5;

    private StyledButton btnLogout;

    public Dashboard() {

        setTitle("Cyber Security Awareness Platform");

        setSize(1000, 650);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel background =
                new ImagePanel(
                        "images/dashboard_bg.jpg");

        background.setLayout(new BorderLayout());

        //--------------------------------
        // TOP PANEL
        //--------------------------------

        JPanel topPanel = new JPanel();

        topPanel.setOpaque(false);

        topPanel.setLayout(
                new GridLayout(2,1));

        lblTitle =
                new JLabel(
                        "CYBER SECURITY AWARENESS PLATFORM",
                        SwingConstants.CENTER);

        lblTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28));

        lblTitle.setForeground(Color.WHITE);

        lblWelcome =
                new JLabel(
                        "Welcome, " + Session.username,
                        SwingConstants.CENTER);

        lblWelcome.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20));

        lblWelcome.setForeground(Color.WHITE);

        topPanel.add(lblTitle);
        topPanel.add(lblWelcome);

        //--------------------------------
        // CENTER PANEL
        //--------------------------------

        JPanel centerPanel = new JPanel();

        centerPanel.setOpaque(false);

        centerPanel.setLayout(
                new GridLayout(
                        5,
                        1,
                        15,
                        15));

        btnModule1 =
                new StyledButton(
                        "🔒 Password Security");

        btnModule2 =
                new StyledButton(
                        "🎣 Phishing Awareness");

        btnModule3 =
                new StyledButton(
                        "🦠 Malware Awareness");

        btnModule4 =
                new StyledButton(
                        "🕵 Social Engineering");

        btnModule5 =
                new StyledButton(
                        "🌐 Safe Browsing");

        btnModule1.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.BOLD,
                        18));

        btnModule2.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.BOLD,
                        18));

        btnModule3.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.BOLD,
                        18));

        btnModule4.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.BOLD,
                        18));

        btnModule5.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.BOLD,
                        18));

        centerPanel.add(btnModule1);
        centerPanel.add(btnModule2);
        centerPanel.add(btnModule3);
        centerPanel.add(btnModule4);
        centerPanel.add(btnModule5);

        JPanel wrapper =
                new JPanel(
                        new GridBagLayout());

        wrapper.setOpaque(false);

        JPanel card =
                new JPanel();

        card.setBackground(
                new Color(
                        255,
                        255,
                        255,
                        200));

        card.setPreferredSize(
                new Dimension(
                        500,
                        350));

        card.setLayout(
                new BorderLayout());

        JLabel moduleTitle =
                new JLabel(
                        "Training Modules",
                        SwingConstants.CENTER);

        moduleTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22));

        card.add(
                moduleTitle,
                BorderLayout.NORTH);

        card.add(
                centerPanel,
                BorderLayout.CENTER);

        wrapper.add(card);

        //--------------------------------
        // BOTTOM PANEL
        //--------------------------------

        JPanel bottomPanel =
                new JPanel();

        bottomPanel.setOpaque(false);

        btnLogout =
                new StyledButton(
                        "Logout");

        bottomPanel.add(btnLogout);

        //--------------------------------
        // ADD PANELS
        //--------------------------------

        background.add(
                topPanel,
                BorderLayout.NORTH);

        background.add(
                wrapper,
                BorderLayout.CENTER);

        background.add(
                bottomPanel,
                BorderLayout.SOUTH);

        setContentPane(background);

        //--------------------------------
        // BUTTON ACTIONS
        //--------------------------------

        btnModule1.addActionListener(
                e -> openModule(1));

        btnModule2.addActionListener(
                e -> openModule(2));

        btnModule3.addActionListener(
                e -> openModule(3));

        btnModule4.addActionListener(
                e -> openModule(4));

        btnModule5.addActionListener(
                e -> openModule(5));

        btnLogout.addActionListener(
                e -> {

                    new LoginPage()
                            .setVisible(true);

                    dispose();
                });
    }

    private void openModule(
            int moduleId) {

        new ModuleViewer(
                moduleId)
                .setVisible(true);
    }
}