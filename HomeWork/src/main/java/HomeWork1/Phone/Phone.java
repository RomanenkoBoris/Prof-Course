package Phone;

public class Phone {
    private final int number;
    private final String model;
    private final double weight;

    public Phone(int number, String model, double weight){
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public void receiveCall (String name){
        System.out.println(name + " calls you");
    }
    public int getNumber (){
        return number;
    }

    public String getModel() {
        return model;
    }

    public double getWeight() {
        return weight;
    }
}
