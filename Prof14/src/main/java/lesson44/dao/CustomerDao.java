package lesson44.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static String url = "jdbc:sqlite:shop.db";

    public Customer getCustomerById(int id) {
        try (
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM customers WHERE cnum = ?"
                );
        ) {
            preparedStatement.setInt(1, id);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    return new Customer(
                            resultSet.getInt("cnum"),
                            resultSet.getString("city"),
                            resultSet.getString("cname"),
                            resultSet.getInt("rating"),
                            resultSet.getInt("snum"));
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
        ) {
            while (resultSet.next()) {
                customerList.add(new Customer(
                        resultSet.getInt("cnum"),
                        resultSet.getString("city"),
                        resultSet.getString("cname"),
                        resultSet.getInt("rating"),
                        resultSet.getInt("snum")));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return customerList;
    }

    public int create(Customer customer) {
        try (
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO customers (cnum, city, cname, rating, snum) values (?, ?, ?, ?, ?)");
        ) {
            preparedStatement.setInt(1, customer.getCnum());
            preparedStatement.setString(2, customer.getCity());
            preparedStatement.setString(3, customer.getCname());
            preparedStatement.setInt(4, customer.getRating());
            preparedStatement.setInt(5, customer.getSnum());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int delete (Customer customer){
        try (
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM customers WHERE cnum = ?");
                )
        {
            preparedStatement.setInt(1, customer.getCnum());
            return preparedStatement.executeUpdate();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public int update (Customer customer){
        try (
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE customers SET city = ?, cname = ?, rating = ?, snum = ? WHERE cnum = ?"
                );
                )
        {
            preparedStatement.setString(1, customer.getCity());
            preparedStatement.setString(2, customer.getCname());
            preparedStatement.setInt(3, customer.getRating());
            preparedStatement.setInt(4, customer.getSnum());
            preparedStatement.setInt(5, customer.getCnum());
            return preparedStatement.executeUpdate();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        return 0;
    }
}
