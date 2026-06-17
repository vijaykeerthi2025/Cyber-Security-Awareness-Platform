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
public class AdminDashboard extends JFrame{
    



    JButton btnModules;
    JButton btnQuestions;
    JButton btnResults;

    public AdminDashboard() {

        setTitle("Admin Dashboard");
        setSize(500,400);
        setLocationRelativeTo(null);

        btnModules = new JButton("Manage Modules");
        btnQuestions = new JButton("Manage Questions");
        btnResults = new JButton("View Results");

        setLayout(new GridLayout(3,1,10,10));

        add(btnModules);
        add(btnQuestions);
        add(btnResults);

        btnModules.addActionListener(
                e -> new ModuleManager().setVisible(true));

        btnQuestions.addActionListener(
                e -> new QuestionManager().setVisible(true));

        btnResults.addActionListener(
                e -> new ResultsViewer().setVisible(true));
    }
}

