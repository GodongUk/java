package JAVA3_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BookManager {
    // DB 연결 정보
    String url = "jdbc:oracle:thin:@//localhost:1521/XE";
    String user = "system";
    String password = "1234";

    // DB 연결
    public Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection conn = DriverManager.getConnection(
                url, user, password);
        return conn;
    }

    Books books = new Books();

    // 전체 책 목록 출력
    public void booksList() {
        String sql = "SELECT booknum, bookname, bookauthor, bookpublisher, bookyn "
                + "FROM books";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("--------------------------------------");
                System.out.println("책넘버 : " + rs.getInt("booknum"));
                System.out.println("책이름 : " + rs.getString("bookname"));
                System.out.println("저자 : " + rs.getString("bookauthor"));
                System.out.println("출판사 : " + rs.getString("bookpublisher"));
                System.out.println("대여가능여부 : " + rs.getString("bookyn"));
                System.out.println("--------------------------------------");
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("뭔가오류");
            e.printStackTrace();
        }
    }

    // 검색 기능
    public void booksSearch(String bookName) {
        String sql = "SELECT booknum, bookname, bookauthor, bookpublisher, bookyn "
                + "FROM books "
                + "WHERE bookname LIKE ? ";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + bookName + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("--------------------------------------");
                System.out.println("책넘버 : " + rs.getInt("booknum"));
                System.out.println("책이름 : " + rs.getString("bookname"));
                System.out.println("저자 : " + rs.getString("bookauthor"));
                System.out.println("출판사 : " + rs.getString("bookpublisher"));
                System.out.println("대여가능여부 : " + rs.getString("bookyn"));
                System.out.println("--------------------------------------");
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("뭔가오류");
            e.printStackTrace();
        }
    }
    

}
