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
public class ResultPage extends JFrame {
    



    private int score;

    private int totalQuestions;

    private int moduleId;

    public ResultPage(
            int score,
            int totalQuestions,
            int moduleId) {

        this.score = score;

        this.totalQuestions = totalQuestions;

        this.moduleId = moduleId;

        setTitle("Quiz Result");

        setSize(550,300);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);

        JLabel lblResult =
                new JLabel(
                        "Your Score : "
                                + score
                                + " / "
                                + totalQuestions,
                        SwingConstants.CENTER);

        lblResult.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22));

        JButton btnCertificate =
                new JButton(
                        "Generate Certificate");

        JButton btnClose =
                new JButton("Close");

        JPanel panel =
                new JPanel(
                        new BorderLayout());

        panel.add(
                lblResult,
                BorderLayout.CENTER);

        JPanel bottom =
                new JPanel();

        bottom.add(btnCertificate);

        bottom.add(btnClose);

        panel.add(
                bottom,
                BorderLayout.SOUTH);

        add(panel);

        saveResult();

        btnCertificate.addActionListener(
                e -> {

                    new CertificateGenerator(
                            Session.username,
                            score,
                            totalQuestions
                    ).setVisible(true);
                });

        btnClose.addActionListener(
                e -> dispose());
    }

    private void saveResult() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO results "
                    + "(user_id,module_id,score,total_questions) "
                    + "VALUES (?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(
                    1,
                    Session.userId);

            ps.setInt(
                    2,
                    moduleId);

            ps.setInt(
                    3,
                    score);

            ps.setInt(
                    4,
                    totalQuestions);

            ps.executeUpdate();

            System.out.println(
                    "Result Saved Successfully");

        } catch(Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Error Saving Result : "
                            + ex.getMessage());
        }
    }
}