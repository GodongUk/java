package Car2;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.run();
        System.out.println("-------------------------------");
        myCar.tires[2] = new KumhoTire();
        myCar.run();
    }
}
