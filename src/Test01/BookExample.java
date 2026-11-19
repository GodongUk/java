package Test01;

import java.util.Scanner;

public class BookExample {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        int num1 = 0;

        book.loadFromFile();
        while (num1 != 3) {
            System.out.println("===== LIBRARY SYSTEM =====");
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 목록 조회");
            System.out.println("3. 저장 및 종료");
            System.out.print("메뉴 선택 >> ");

            String strnum1 = scanner.nextLine();
            num1 = Integer.parseInt(strnum1);

            if (num1 == 1) {
                book.addItem(book);
            } else if (num1 == 2) {
                book.displayAll();
            } else if (num1 == 3) {
                book.saveToFile();
                System.out.println("저장 및 종료되었습니다.");
            }
        }

    }
}
