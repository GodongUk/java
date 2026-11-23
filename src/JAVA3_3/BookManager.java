package JAVA3_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookManager {
    String url = "jdbc:oracle:thin:@//localhost:1521/XE";
    String user = "system";
    String password = "1234";

    // DB 연결
    public Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");

        return DriverManager.getConnection(
                url, user, password);
    }

    // 도서 등록
    public void insertBook(Books books) {

        String sql = "INSERT INTO books "
                + "(booknum, isbn, bookname, bookauthor, "
                + "bookpublisher, bookcategory) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, books.getBookNum());
            pstmt.setInt(2, books.getIsbn());
            pstmt.setString(3, books.getBookName());
            pstmt.setString(4, books.getBookAuthor());
            pstmt.setString(5, books.getBookPublisher());
            pstmt.setString(6, books.getBookCategory());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("도서 등록 성공!");
            }

        } catch (Exception e) {
            System.out.println("도서 등록 오류");
            e.printStackTrace();
        }
    }

    // 전체 도서 조회
    public void selectAllBooks() {

        String sql = "SELECT * FROM books ORDER BY booknum";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            System.out.println("========== 도서 목록 ==========");

            while (rs.next()) {

                System.out.println("도서 번호 : "
                        + rs.getInt("booknum"));
                System.out.println("ISBN : "
                        + rs.getInt("isbn"));
                System.out.println("도서명 : "
                        + rs.getString("bookname"));
                System.out.println("저자 : "
                        + rs.getString("bookauthor"));
                System.out.println("출판사 : "
                        + rs.getString("bookpublisher"));
                System.out.println("분류 : "
                        + rs.getString("bookcategory"));
                System.out.println("대여 가능 여부 : "
                        + rs.getString("bookyn"));
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            System.out.println("도서 조회 오류");
            e.printStackTrace();
        }
    }

    // 도서 검색
    public void searchBook(String bookName) {
        String sql = "SELECT * FROM books "
                + "WHERE bookname LIKE ? "
                + "ORDER BY booknum";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + bookName + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println("도서 번호 : "
                            + rs.getInt("booknum"));
                    System.out.println("도서명 : "
                            + rs.getString("bookname"));
                    System.out.println("저자 : "
                            + rs.getString("bookauthor"));
                    System.out.println("출판사 : "
                            + rs.getString("bookpublisher"));
                    System.out.println("분류 : "
                            + rs.getString("bookcategory"));
                    System.out.println("----------------------");
                }
                if (!found) {
                    System.out.println("검색 결과가 없습니다.");
                }
            }
        } catch (Exception e) {
            System.out.println("도서 검색 오류");
            e.printStackTrace();
        }
    }

    // 도서 정보 수정
    public void updateBook(Books books) {

        String sql = "UPDATE books SET "
                + "bookname = ?, "
                + "bookauthor = ?, "
                + "bookpublisher = ?, "
                + "bookcategory = ? "
                + "WHERE booknum = ?";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, books.getBookName());
            pstmt.setString(2, books.getBookAuthor());
            pstmt.setString(3, books.getBookPublisher());
            pstmt.setString(4, books.getBookCategory());
            pstmt.setInt(5, books.getBookNum());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("도서 정보 수정 완료!");
            } else {
                System.out.println("해당 도서가 존재하지 않습니다.");
            }

        } catch (Exception e) {
            System.out.println("도서 수정 오류");
            e.printStackTrace();
        }
    }

    // 도서 폐기 처리
    public void deleteBook(int bookNum) {

        String sql = "UPDATE books "
                + "SET bookyn = 'N', "
                + "bookstatus = 'DISPOSED' "
                + "WHERE booknum = ? "
                + "AND bookstatus = 'NORMAL'";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, bookNum);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("도서 폐기 처리가 완료되었습니다.");
            } else {
                System.out.println("해당 도서가 없거나 이미 폐기되었습니다.");
            }

        } catch (Exception e) {
            System.out.println("도서 폐기 오류");
            e.printStackTrace();
        }
    }
}
