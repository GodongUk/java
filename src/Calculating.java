import java.util.Scanner;

public class Calculating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫번째 숫자 입력: ");
        String strnum1 = scanner.nextLine();
        int num1 = Integer.parseInt(strnum1);

        System.out.print("두번째 숫자 입력: ");
        String strnum2 = scanner.nextLine();
        int num2 = Integer.parseInt(strnum2);

        System.out.println("사칙 연산 종류를 선택해주세요");
        System.out.println("1.더하기, 2.빼기, 3.곱하기, 4.나누기, 5.한번에 다보여줘");
        String strnum3 = scanner.nextLine();
        int num3 = Integer.parseInt(strnum3);

        if (num3 > 5) {
            System.out.println("잘못 입력 하였습니다. 다시 실행해 주세요");
        } else {
            if (num3 == 1) {
                int sum = 0;
                sum = num1 + num2;
                System.out.println("더한 값은: " + sum + " 입니다.");
            } else if (num3 == 2) {
                int sum = 0;
                sum = num1 - num2;
                System.out.println("뺀 값은: " + sum + " 입니다.");
            } else if (num3 == 3) {
                int sum = 0;
                sum = num1 * num2;
                System.out.println("곱한 값은: " + sum + " 입니다.");
            } else if (num3 == 4) {
                int sum = 0;
                sum = num1 / num2;
                System.out.println("나눈 값은: " + sum + " 입니다.");
            } else if (num3 == 5) {
                int sum1 = num1 + num2;
                int sum2 = num1 - num2;
                int sum3 = num1 * num2;
                int sum4 = num1 / num2;
                System.out.println("더한 값은: " + sum1 + " 입니다.");
                System.out.println("뺀 값은: " + sum2 + " 입니다.");
                System.out.println("곱한 값은: " + sum3 + " 입니다.");
                System.out.println("나눈 값은: " + sum4 + " 입니다.");
            }

        }

    }
}
