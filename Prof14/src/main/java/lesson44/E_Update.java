package lesson44;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class E_Update {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";

        try (
                Connection conn = DriverManager.getConnection(url);
                // запрос
                Statement stmt = conn.createStatement();
        ) {
            // добавьте 2 процента комиссии каждому из продавцов и распечатайте количество измененных строк
            int rowsAffected = stmt.executeUpdate("UPDATE salespeople SET comm = comm + 2");
            System.out.println(rowsAffected);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
