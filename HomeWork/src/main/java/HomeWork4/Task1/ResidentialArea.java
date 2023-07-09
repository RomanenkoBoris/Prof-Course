package HomeWork4.Task1;

import java.util.ArrayList;
import java.util.List;

public class ResidentialArea {
    public static void main(String[] args) {
        Persons adam = new Persons("Adam Adamson", new Address("first Avenue", 1));
        Persons bob = new Persons("Bob Bobmson", new Address("second Avenue", 2));
        Persons cid = new Persons("Cid Cidson", new Address("third Avenue", 3));
        Persons dave = new Persons("Dave Daveson", new Address("forth Avenue", 4));
        Persons jack = new Persons("Jack Jackson", new Address("fifth Avenue", 5));
        Persons poll = new Persons("Poll Pollson", new Address("sixth Avenue", 6));
        Persons john = new Persons("John Johnson", new Address("seventh Avenue", 7));

        List<Persons> persons = new ArrayList<>();
        persons.add(adam);
        persons.add(bob);
        persons.add(cid);
        persons.add(dave);
        persons.add(jack);
        persons.add(poll);
        persons.add(john);

        List<Address> list = getAddresses(persons);
        for (Address address : list) {
            System.out.println(address);
        }

    }

    public static List<Address> getAddresses(List<Persons> personsList) {
        List<Address> addresses = new ArrayList<>();
        for (Persons name : personsList) {
            addresses.add(name.getAddress());
        }
        return addresses;
    }

}
