package lesson44.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Homework {
    public static void main(String[] args) {
       customersOrders("Grass", 3000);
    }
    public static void customersOrders (String name, int sum){
        String url = "jdbc:sqlite:shop.db";
        try(
                Connection connect = DriverManager.getConnection(url);
                PreparedStatement statement = connect.prepareStatement(
                        "select t1.onum oder_number, t1.amt amount, t2.cnam customer_name " +
                            " from orders t1 inner join customers t2 on t1.cnum = t2.cnum " +
                            " and t2.cname = ? and t1.amt > ?")
        )
        {
            statement.setString(1,name);
            statement.setInt(2, sum);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int orderNumber = resultSet.getInt("order_number");
                int amount = resultSet.getInt("amount");
                String customerName = resultSet.getString("customer_name");

                System.out.printf("|%10s|%10d|%5d|\n", customerName, amount, orderNumber);
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
