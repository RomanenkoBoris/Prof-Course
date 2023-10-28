package lesson44;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class H_AutoIncrement {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";

        try (
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
        ) {
            int rowsAffected = stmt.executeUpdate(
                    "insert into users (first, last) values ('Max', 'Kotkov'); ");
            if (rowsAffected > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys();) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        System.out.println("key is: " + id); // key is: 1
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
