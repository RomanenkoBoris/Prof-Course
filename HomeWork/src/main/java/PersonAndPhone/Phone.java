package PersonAndPhone;

public class Phone {

        private final int number;
        private final String model;
        private final double weight;

        public Phone(int number, String model, double weight){
            this.number = number;
            this.model = model;
            this.weight = weight;
        }

        public void receiveCall (Person person){
            System.out.println(person.getFullName() + " calls you");
        }

        public String toString (){
            return "Phone [model: " + model + ", number: " + number + ", weight: " + weight + " kilogram]";
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
