package JAVAtest;

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager();
        Book book = new Book();
        int num1 = 0;

        bookManager.loadFromFile();
        while (num1 != 3) {
            System.out.println("===== LIBRARY SYSTEM =====");
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 목록 조회");
            System.out.println("3. 저장 및 종료");
            System.out.print("메뉴 선택 >> ");

            String strnum1 = scanner.nextLine();
            num1 = Integer.parseInt(strnum1);
            if (num1 == 1) {
                bookManager.addItem(book);
            } else if (num1 == 2) {
                bookManager.displayAll();
            } else if (num1 == 3) {
                bookManager.saveToFile();

            }
        }
    }
}
