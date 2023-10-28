package lesson44;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*
Transaction - транзакция - группа из нескольких sql запросов
результаты выполнения которой либо должны быть отражены в базе данных полностью
либо, в случае ошибки, должны быть отброшены результаты промежуточных запросов

commit - транзакция выполнилась успешно и ее нужно зафиксировать в базы данных
rollback - что-то пошло не так, все промежуточные изменения нужно отбросить

 */


public class G_Transaction {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";

        try (
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
        ) {
            // autocommit=true - каждый запрос выполняется в рамках отдельной транзакции
            // и выполнять commit не требуется

            // autocommit=false - все запросы выполняются в рамках одной транзакции
            // которую нужно подтвердить вызвав commit
            conn.setAutoCommit(false);
            // добавить кастомера 4001, 'Ferguson', 'Berlin', 100, 1001
            stmt.execute("insert into customers (cnum, cname, city, rating, snum) values ( 4001, 'Ferguson', 'Berlin', 100, 1001)");
            // добавить заказ 7001, 150000, '2023-10-25', 4001, 1001
            stmt.execute("insert into orders (onum, amt, odate, cnum, snum) values ( 7001, 150000, '2023-10-25', 4001, 1001)");
            conn.commit();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
