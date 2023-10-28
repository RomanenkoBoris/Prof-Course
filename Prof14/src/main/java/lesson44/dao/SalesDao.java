package lesson44.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesDao {
    private static String url = "jdbc:sqlite:shop.db";

    public Sales getSalesById(int id) {
        try (
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement pstmt = connection.prepareStatement(
                        "select snum, sname, city, comm from salespeople where snum=?"
                );
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int snum = rs.getInt("snum");
                    String sname = rs.getString("sname");
                    String city = rs.getString("city");
                    int comm = rs.getInt("comm");
                    return new Sales(snum, sname, city, comm);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<Sales> getAll() {
        List <Sales> list = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(url);
                Statement pstmt = connection.createStatement();
                ResultSet rs = pstmt.executeQuery("select * from salespeople");
        ) {
            while (rs.next()) {
                    list.add(new Sales(rs.getInt("snum"),
                                       rs.getString("sname"),
                                       rs.getString("city"),
                                       rs.getInt("comm")));
                }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    public int create(Sales sales) {
        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(
                        "insert into salespeople (snum, sname, city, comm) values ( ?, ?, ?, ?)")
        ) {
            pstmt.setInt(1, sales.getSnum());
            pstmt.setString(2, sales.getSname());
            pstmt.setString(3, sales.getCity());
            pstmt.setInt(4, sales.getComm());
            return pstmt.executeUpdate();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public int delete(Sales sales) {
        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(
                        "DELETE FROM salespeople WHERE snum = ?")
        ) {
            pstmt.setInt(1, sales.getSnum());
            return pstmt.executeUpdate();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public int update(Sales sales) {
        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(
                        "UPDATE salespeople SET sname = ?, city = ?, comm = ? WHERE snum = ?")
        ) {
            pstmt.setString(1, sales.getSname());
            pstmt.setString(2, sales.getCity());
            pstmt.setInt(3, sales.getComm());
            pstmt.setInt(4, sales.getSnum());
            return pstmt.executeUpdate();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        return 0;
    }
}
