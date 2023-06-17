package PersonAndPhone;

public class PersonOwnPhone {
    public Person person;
    public Phone phone;

    public PersonOwnPhone(Person person, Phone phone){
        this.person = person;
        this.phone = phone;
    }

    public void own(){
        System.out.println(person.getFullName() + " owns a/an " + phone.getModel());
    }
}
