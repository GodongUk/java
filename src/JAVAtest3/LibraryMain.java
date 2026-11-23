package JAVAtest3;

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager();
        int num1 = 0;
        int num2 = 0;
        // 프로그램 시작 시 DB 데이터 불러오기
        bookManager.loadFromFile();
        while (num1 != 3) {
            System.out.println("===== LIBRARY SYSTEM =====");
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 목록 조회");
            System.out.println("3. 저장 및 종료");
            System.out.print("메뉴 선택 >> ");
            try {
                String strnum1 = scanner.nextLine();
                num1 = Integer.parseInt(strnum1);
                if (num1 == 1) {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("제목: ");
                    String title = scanner.nextLine();
                    System.out.print("저자: ");
                    String author = scanner.nextLine();
                    Book book = new Book(id, title, author);
                    bookManager.addItem(book);
                } else if (num1 == 2) {
                    System.out.println("1. 아이디 검색");
                    System.out.println("2. 전체 검색");
                    System.out.print(">> ");
                    String strnum2 = scanner.nextLine();
                    num2 = Integer.parseInt(strnum2);
                    if (num2 == 1) {
                        System.out.println("아이디 번호를 입력해주세요");
                        int searchId = Integer.parseInt(scanner.nextLine());
                        bookManager.searchById(searchId);
                    } else if (num2 == 2) {
                        bookManager.displayAll();
                    } else {
                        System.out.println("잘못된 메뉴 번호입니다.");
                    }
                } else if (num1 == 3) {
                    bookManager.saveToFile();
                } else {
                    System.out.println("잘못된 메뉴 번호입니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
                num1 = 0;
            }
        }
        scanner.close();
    }
}
