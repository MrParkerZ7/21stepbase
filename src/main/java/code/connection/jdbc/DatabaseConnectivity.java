package code.connection.jdbc;

import java.sql.*;

/**
 * All of this depend on you requirement.
 * What exactly did you want query it.
 * We had
 * DDL - Data Definition Language
 * DML - Data Manipulation Language
 * DQL - Data Query Language
 * TCL - Transition Controller Language
 */

public class DatabaseConnectivity {
    private final static String url = "jdbc:mysql://localhost:3306/demo_jdbc";
    private final static String username = "root";
    private final static String pass = "";
    private final static String querySingle = "select name from student where id=102"; // SQL Query commander by filter
    private final static String queryAll = "select * from student";
    private final static String queryPrepare = "insert into student values (?,?)";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(url, username, pass);
             Statement s = con.createStatement()) {

            { // Fetch one
                // Using ResultSet. because of the data that we get it from database. it's also had a head table and one column coming with data.
                ResultSet rs = s.executeQuery(querySingle); //Get table that we querySingle from database
                rs.next(); // Use to ship the first row which that is head table.
                String name = rs.getString("name");  // Get the column you want
                System.out.println(name);
            }

            { // Fetch all
                ResultSet rs = s.executeQuery(queryAll);
                while (rs.next()) {
                    String userData = rs.getInt(1) + " : " + rs.getString(2);
                    System.out.println(userData);
                }
            }
        }

        try (Connection con = DriverManager.getConnection(url, username, pass);
             PreparedStatement ps = con.prepareStatement(queryPrepare)) {
            ps.setInt(1, 104);
            ps.setString(2, "Loso");
            int count = ps.executeUpdate(); // DML

            System.out.println(count + " row/s affected");
        }
    }
}
