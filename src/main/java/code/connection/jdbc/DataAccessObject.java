package code.connection.jdbc;

import java.sql.*;

/**
 * Customize the code
 * Using select inset delete update
 */

public class DataAccessObject {

    public static void main(String[] args) {
        Motorcycle m = new Motorcycle();
        m.getModel(101);
        m.addModel(103, "CBR1000RR");
        m.addModel(104, "GSX1000R");
        m.deleteModel(103);
        m.updateModel(104, "H2R");
    }
}

class Motorcycle {
    private final static String url = "jdbc:mysql://localhost:3306/demo_jdbc";
    private final static String username = "root";
    private final static String pass = "";

    private int serialNumber;
    private String model;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteModel(int serialNumber) {
        String query = "delete from motorcycle where serialNumber=" + serialNumber;
        try (Connection con = DriverManager.getConnection(url, username, pass);
             Statement s = con.createStatement()) {

            s.executeUpdate(query);
            System.out.println("Delete: " + serialNumber);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getModel(int serialNo) {
        String query = "select * from motorcycle where serialNumber=" + serialNo;
        try (Connection con = DriverManager.getConnection(url, username, pass);
             Statement s = con.createStatement()) {

            ResultSet rs = s.executeQuery(query);
            rs.next();
            String model = rs.getString("model");
            System.out.println("Get data: " + model);
            return model;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addModel(int serialNumber, String model) {
        String query = "insert into motorcycle value (?,?)";
        try (Connection con = DriverManager.getConnection(url, username, pass);
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, serialNumber);
            ps.setString(2, model);
            ps.executeUpdate();
            System.out.println("Add detail: " + serialNumber + ", " + model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateModel(int serialNumber, String model) {
        String query = "update motorcycle set model=? where serialNumber=?";
        try (Connection con = DriverManager.getConnection(url, username, pass);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, model);
            ps.setInt(2, serialNumber);
            ps.executeUpdate();
            System.out.println("Update: " + serialNumber + " with " + model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


