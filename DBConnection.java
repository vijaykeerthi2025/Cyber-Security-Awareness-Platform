/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VIJAYAKUMAR K G
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    

    private static final String URL =
            "jdbc:mysql://localhost:3306/cyberdb";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "password";

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName(
                "com.mysql.cj.jdbc.Driver"
            );

            con =
                DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );

            System.out.println(
                "Database Connected Successfully"
            );

        } catch (ClassNotFoundException e) {

            System.out.println(
                "JDBC Driver Not Found"
            );

        } catch (SQLException e) {

            System.out.println(
                "Connection Failed"
            );

            e.printStackTrace();
        }

        return con;
    }
}
    

