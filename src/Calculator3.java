public class Calculator3 {
    int plus(int x, int y) {
        int result = x + y;
        return result;
    }

    double avg(int x, int y) {
        double sum = plus(x, y);
        double result = sum / 2;
        return result;
    }

    void execute() {
        double result = avg(7, 10);
        println("실행 결과: " + result);
    }

    int execute(int x, int y) {
        int result = x * y;
        println(x + "*" + y + "=" + result);
        return result;
    }

    double execute(double x, double y) {
        double result = x * y;
        println(x + "*" + y + "=" + result);
        return result;
    }

    void execute(String x) {
        for (int i = 0; i < 3; i++) {
            println("입력값을 3번 반복합니다.");
            println(x);
        }
    }

    void println(String message) {
        System.out.println(message);
    }
}
