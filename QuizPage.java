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
public class QuizPage extends JFrame{
    
 

    int moduleId;

    int currentQuestionId = 0;

    int score = 0;
    int totalQuestions = 0;

    JLabel lblQuestion;

    JRadioButton r1,r2,r3,r4;

    ButtonGroup group;

    JButton btnNext;

    String correctAnswer;

    public QuizPage(int moduleId) {

        this.moduleId = moduleId;

        setTitle("Cyber Security Quiz");

        setSize(700,400);

        setLocationRelativeTo(null);

        lblQuestion =
                new JLabel();

        r1 = new JRadioButton();
        r2 = new JRadioButton();
        r3 = new JRadioButton();
        r4 = new JRadioButton();

        group =
                new ButtonGroup();

        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);

        btnNext =
                new JButton("Next");

        JPanel panel =
                new JPanel();

        panel.setLayout(
                new GridLayout(6,1));

        panel.add(lblQuestion);
        panel.add(r1);
        panel.add(r2);
        panel.add(r3);
        panel.add(r4);
        panel.add(btnNext);

        add(panel);

        loadQuestion();

        btnNext.addActionListener(
                e -> {

                    checkAnswer();

                    loadQuestion();
                });
    }

    private void loadQuestion() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM questions "
                            + "WHERE module_id=? "
                            + "AND id>? "
                            + "ORDER BY id ASC "
                            + "LIMIT 1";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1,moduleId);

            ps.setInt(2,currentQuestionId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                currentQuestionId =
                        rs.getInt("id");

                lblQuestion.setText(
                        rs.getString("question"));

                r1.setText(
                        rs.getString("option1"));

                r2.setText(
                        rs.getString("option2"));

                r3.setText(
                        rs.getString("option3"));

                r4.setText(
                        rs.getString("option4"));

                correctAnswer =
                        rs.getString(
                                "correct_answer");

                totalQuestions++;

                group.clearSelection();

            } else {

                dispose();

                new ResultPage(
                        score,
                        totalQuestions - 1,
                        moduleId
                ).setVisible(true);
            }

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage());
        }
    }

    private void checkAnswer() {

        String selected = "";

        if(r1.isSelected())
            selected = r1.getText();

        if(r2.isSelected())
            selected = r2.getText();

        if(r3.isSelected())
            selected = r3.getText();

        if(r4.isSelected())
            selected = r4.getText();

        if(selected.equals(correctAnswer)) {

            score++;
        }
    }
}