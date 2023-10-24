package lesson44;

import java.sql.*;

public class D_Query {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";

        try (
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                // ResultSet - "курсор"
                ResultSet rs = stmt.executeQuery("select * from customers order by cname");
                // PreparedStatement компилируется и за счет этого выполняется быстрее
                // может содержать параметры, значения которых нужно будет подставить в запрос
                PreparedStatement pstmt = conn.prepareStatement(
                        "select * from salespeople where comm > ?"
                );
                PreparedStatement ostmt = conn.prepareStatement(
                        "select * from orders where amt between ? and ?"
                );
        ) {
            while (rs.next())
            {
                int customerId = rs.getInt("cnum");
                String city = rs.getString("city");
                String name = rs.getString("cname");
                int rating = rs.getInt("rating");
                int snum = rs.getInt("snum");

                System.out.printf("|%5d|%10s|%10s|%5d|%5d|\n",
                        customerId, name, city, rating, snum
                );

            }
            System.out.println("==========");
            pstmt.setInt(1, 11); // отбираем всех продавцов с комиссией больше 11
            try (
                    ResultSet rsSales = pstmt.executeQuery();
            )
            {
                while (rsSales.next())
                {
                    // выведите продавцов с нужной комиссией
                    int snum = rsSales.getInt("snum");
                    String city = rsSales.getString("city");
                    int comm = rsSales.getInt("comm");
                    String sname = rsSales.getString("sname");

                    System.out.printf("|%5d|%10s|%5d|%10s|\n",
                            snum, city, comm, sname
                    );
                }
            }
            // отберите паразметризованным запросом все заказы с amt от 100_000 до 200_000
            // выведите на экран для каждого заказа onum, amt
            // "select * from orders where amt between ? and ?"
            System.out.println("--------");
            ostmt.setInt(1, 100_000);
            ostmt.setInt(2 , 200_000);
            try (ResultSet rsOrders = ostmt.executeQuery();)
            {
                while (rsOrders.next()){
                    int onum = rsOrders.getInt("onum");
                    int amt = rsOrders.getInt("amt");
                    System.out.printf("|%5d|%10d|\n", onum, amt);
                }
            }


        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}