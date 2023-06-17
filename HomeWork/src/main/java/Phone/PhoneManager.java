package Phone;

public class PhoneManager {
    public static void main(String[] args) {

        Phone iphone = new Phone(5123459, "IPhone13", 0.221);
        Phone samsung = new Phone(5660654, "Galaxy", 0.196);
        Phone nokia = new Phone(79874564, "3310", 0.295);

        System.out.println(iphone.getModel() + " " + iphone.getNumber() + " " + iphone.getWeight());
        System.out.println(samsung.getModel() + " " + samsung.getNumber() + " " + samsung.getWeight());
        System.out.println(nokia.getModel() + " " + nokia.getNumber() + " " + nokia.getWeight());

        iphone.receiveCall("John");
        samsung.receiveCall("Jane");
        nokia.receiveCall("Mike");
    }
}
