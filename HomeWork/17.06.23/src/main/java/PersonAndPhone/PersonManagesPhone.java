package PersonAndPhone;

public class PersonManagesPhone {
    public static void main(String[] args) {

        Person john = new Person();
        john.setFullName("John Johnson");
        john.setAge(35);

        Person adam = new Person("Adam Adamson", 41);
        Person mike = new Person("Mike Maerson", 45);

        john.move();
        john.talk();

        adam.move();
        adam.talk();

        Phone iphone = new Phone(5123459, "IPhone 13", 0.221);
        Phone samsung = new Phone(5660654, "Samsung Galaxy", 0.196);
        Phone nokia = new Phone(79874564, "Nokia 3310", 0.295);

        System.out.println(iphone);
        System.out.println(samsung);
        System.out.println(nokia);

        iphone.receiveCall(john);
        samsung.receiveCall(adam);
        nokia.receiveCall(mike);

        PersonOwnPhone owner1 = new PersonOwnPhone(john, samsung);
        PersonOwnPhone owner2 = new PersonOwnPhone(adam, nokia);
        PersonOwnPhone owner3 = new PersonOwnPhone(mike, iphone);

        owner1.own();
        owner2.own();
        owner3.own();




    }
}
