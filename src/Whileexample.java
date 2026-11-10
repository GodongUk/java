import java.util.Scanner;

public class Whileexample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int num = 0;
        int sum = 0;
        int temp = 0;
        int y = 0;
        while (run) {
            System.out.println("1.점수 입력 | 2.입력 종료");
            String strNum = scanner.nextLine();
            num = Integer.parseInt(strNum);
            if (num == 1) {
                System.out.println("--------------------");
                System.out.println("점수를 입력하세요");
                System.out.println("--------------------");
                String strTemp = scanner.nextLine();
                temp = Integer.parseInt(strTemp);
                sum += temp;
                y++;
            } else if (num == 2) {
                run = false;
            }
        }
        System.out.println("총점 = " + sum + "입니다.");
        System.out.println("평균 = " + (sum / y) + "입니다.");
    }
}
