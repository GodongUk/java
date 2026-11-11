public class Calculator4Example {
    public static void main(String[] args) {
        Calculator4 Calc = new Calculator4();

        double result1 = 10 * 10 * Calculator4.pi;
        int result2 = Calculator4.plus(10, 5);
        int result3 = Calculator4.minus(10, 5);

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);

        double result4 = 10 * 10 * Calc.pi;
        System.out.println(result4);
    }
}
