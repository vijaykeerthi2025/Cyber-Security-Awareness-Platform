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
public class ResultsViewer extends JFrame{
    



    JTextArea area;

    public ResultsViewer() {

        setTitle("Quiz Results");

        setSize(600,400);

        setLocationRelativeTo(null);

        area = new JTextArea();

        add(new JScrollPane(area));

        loadResults();
    }

    private void loadResults() {

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM results");

            while(rs.next()) {

                area.append(
                        "Result ID : "
                                + rs.getInt("id")
                                + "\nUser ID : "
                                + rs.getInt("user_id")
                                + "\nModule ID : "
                                + rs.getInt("module_id")
                                + "\nScore : "
                                + rs.getInt("score")
                                + "\n\n");
            }

        } catch(Exception ex) {

            area.setText(
                    ex.getMessage());
        }
    }
}

