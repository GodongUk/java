import java.util.Scanner;

public class Conditiona10perationExample2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("점수 입력: ");
        String strnum1 = scanner.nextLine();
        int score = Integer.parseInt(strnum1);

        if (score > 90) {
            System.out.println(score + "점은 A등급 입니다.");
        } else if (score > 80) {
            System.out.println(score + "점은 B등급 입니다.");
        } else if (score > 70) {
            System.out.println(score + "점은 C등급 입니다.");
        } else if (score > 60) {
            System.out.println(score + "점은 D등급 입니다.");
        } else {
            System.out.println(score + "점은 F등급 입니다.");
        }
    }
}
