public class Computer5Example {
    public static void main(String[] args) {
        int r = 10;
        Calculator5 calculator = new Calculator5();
        System.out.println("원면적 : " + calculator.areaCircle(r));
        System.out.println();
        Computer5 computer = new Computer5();
        System.out.println("원면적 : " + computer.areaCircle(r));
    }
}
