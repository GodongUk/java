package JAVA3_3;

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();
        BookManager bookManager = new BookManager();
        // Users users = new Users();
        int selectNum = 0;
        String selectStr = "";

        while (selectNum != 4) {
            System.out.println("도서관에 오신걸 환영합니다.");
            System.out.println("원하시는 메뉴를 선택해 주세요");

            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 도서 검색");
            System.out.println("4. 도서관 나가기");
            System.out.print(">>");
            selectStr = scanner.nextLine();
            selectNum = Integer.parseInt(selectStr);
            System.out.println();

            if (selectNum == 1) {
                System.out.println("아이디를 입력하세요: ");
                System.out.println(">>");
                String userId = scanner.nextLine();

                System.out.println("비밀번호를 입력하세요: ");
                String userPassword = scanner.nextLine();
                Users users = new Users(userId, userPassword);
                System.out.println();

                boolean loginSuccess = userManager.login(users);

                if (loginSuccess) {
                    // 유저 아이디 비밀번호 확인
                    System.out.println("원하시는 메뉴를 선택해 주세요");
                    System.out.println("1. 도서 대여");
                    System.out.println("2. 도서 반납");
                    System.out.println("3. 마이페이지");
                    System.out.println("4. 개인정보 수정");
                    System.out.print(">>");
                    selectStr = scanner.nextLine();
                    selectNum = Integer.parseInt(selectStr);
                    if (selectNum == 1) {
                        System.out.println("도서 대여 화면");
                    } else if (selectNum == 2) {
                        System.out.println("도서반납 화면");
                    } else if (selectNum == 3) {
                        System.out.println("마이페이지");
                        userManager.mypage(userId);
                    } else if (selectNum == 4) {
                        System.out.println("개인정보 수정");
                        System.out.println("변경할 비밀번호를 입력하세요");
                        userPassword = scanner.nextLine();
                        System.out.println("변경할 전화번호를 입력하세요");
                        String userPhoneNumber = scanner.nextLine();
                        userManager.edit(userId, userPassword, userPhoneNumber);
                    }
                } else {
                    System.out.println("로그인 실패");
                    continue;
                }

            } else if (selectNum == 2) {
                System.out.println("가입할 아이디를 입력하세요: ");
                String userId = scanner.nextLine();
                System.out.println("비밀번호를 입력하세요: ");
                String userPassword = scanner.nextLine();
                System.out.println("이름을 입력하세요: ");
                String userName = scanner.nextLine();
                System.out.println("핸드폰 번호를 입력해주세요");
                String userPhoneNumber = scanner.nextLine();
                Users users = new Users(userId, userPassword, userName, userPhoneNumber);
                userManager.signup(users);
                System.out.println("회원가입이 완료 되었습니다.");

            } else if (selectNum == 3) {
                System.out.println("도서 검색");
            } else if (selectNum == 4) {
                System.out.println("도서관을 탈출합니다.");
            }

        }

    }
}
