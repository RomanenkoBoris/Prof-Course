package lesson44.dao;

import java.util.List;

public class DaoTester {
    public static void main(String[] args) {
        SalesDao salesDao = new SalesDao();
        Sales s1001 = salesDao.getSalesById(1001);
        System.out.println(s1001); // Sales{snum=1001, sname='Peel', city='London', comm=14}

        List<Sales> sales = salesDao.getAll();
        sales.forEach(System.out::println);
        /*
        Sales{snum=1001, sname='Peel', city='London', comm=14}
        Sales{snum=1002, sname='Serres', city='San Jose', comm=15}
        Sales{snum=1004, sname='Motika', city='London', comm=13}
        Sales{snum=1007, sname='Rifkin', city='Barcelona', comm=17}
        Sales{snum=1003, sname='Axelrod', city='New York', comm=12}
         */

        Sales max = new Sales(2002, "Max Kotkov", "Prague", 8);
        System.out.println(salesDao.create(max)); // 1
        System.out.println(salesDao.getSalesById(2002));
        // Sales{snum=2002, sname='Max Kotkov', city='Prague', comm=8}

        System.out.println(salesDao.delete(max)); // 1

        Sales axel = salesDao.getSalesById(1003);
        axel.setComm(14);
        salesDao.update(axel);

        CustomerDao customerDao = new CustomerDao();
        System.out.println("========getCustomerById=========");
        System.out.println(customerDao.getCustomerById(2008));
        System.out.println("========getALL=========");
        List<Customer> customerList = customerDao.getAll();
        customerList.forEach(System.out::println);
        System.out.println("========create=========");
        Customer smith = new Customer(2010, "Smith", "New York", 100, 1001);
        System.out.println(customerDao.create(smith));
        System.out.println("========delete=========");
        System.out.println(customerDao.delete(smith));
        System.out.println("========update=========");
        Customer pereira = customerDao.getCustomerById(2001);
        pereira.setCity("Berlin");
        pereira.setRating(1000);
        System.out.println(customerDao.update(pereira));
        System.out.println(customerDao.getCustomerById(2001));

    }
}
