package ex01;

import java.util.*;

public class TryCatchFinallyRuntimeExceptionExample {
    public static void main(String[] args) {
        Add add = new Add();
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫번째 숫자 입력: ");
        String strnum1 = scanner.nextLine();

        System.out.print("두번째 숫자 입력: ");
        String strnum2 = scanner.nextLine();

        String[] data = { strnum1, strnum2 };
        add.add(data);

        
    }
}
