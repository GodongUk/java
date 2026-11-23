package JAVAtest3;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookManager implements Manageable {
    // 도서 정보를 저장하는 리스트
    List<Book> books = new ArrayList<Book>();
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

    // 도서 등록
    @Override
    public void addItem(Book book) {
        String sql = "INSERT INTO books (userId, userTitle, userAuthor) "
                + "VALUES (?, ?, ?)";

        try {
            Connection conn = getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, book.getId());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("결과: 성공적으로 등록되었습니다.");
            }
            pstmt.close();
            conn.close();
        } catch (java.sql.SQLException e) {
            if (e.getErrorCode() == 1) {
                System.out.println("이미 등록된 도서 ID입니다.");
                System.out.println("다른 ID를 입력해주세요.");
            } else {
                System.out.println("오류뜸");
                e.printStackTrace();
            }

        } catch (Exception e) {

            System.out.println("DB오류");
            e.printStackTrace();

        }
    }

    // 전체 도서 목록 조회
    @Override
    public void displayAll() {
        books.clear();
        String sql = "SELECT userId, userTitle, userAuthor " +
        "FROM books";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("userId");
                String title = rs.getString("userTitle");
                String author = rs.getString("userAuthor");
                Book book = new Book(id, title, author);
                books.add(book);
            }
            if (books.size() == 0) {
                System.out.println("등록된 도서가 없습니다.");
            } else {
                System.out.println("======================================");
                System.out.println("ID\t제목\t\t저자");
                System.out.println("======================================");
                for (int i = 0; i < books.size(); i++) {
                    System.out.println(
                            books.get(i).getId() + "\t" +
                                    books.get(i).getTitle() + "\t" +
                                    books.get(i).getAuthor());

                }
                System.out.println("======================================");
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("조회 오류");
            e.printStackTrace();
        }
    }

    // DB 데이터 불러오기
    @Override
    public void loadFromFile() {
        books.clear();
        String sql = "SELECT userId, userTitle, userAuthor " + 
                     "FROM books";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("userId");
                String title = rs.getString("userTitle");
                String author = rs.getString("userAuthor");
                Book book = new Book(id, title, author);
                books.add(book);
            }
            System.out.println("DB 데이터를 불러왔습니다.");
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("DB 오류");
            e.printStackTrace();
        }
    }

    // DB는 등록 즉시 저장되므로 별도 저장 불필요
    @Override
    public void saveToFile() {
        System.out.println("DB에 데이터가 저장되어 있습니다.");
    }

    // 아이디로 도서 검색
    public void searchById(int id) {
        String sql = "SELECT userId, userTitle, userAuthor "
                + "FROM books WHERE userId = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("==============================");
                System.out.println("ID : " + rs.getInt("userId"));
                System.out.println("제목 : " + rs.getString("userTitle"));
                System.out.println("저자 : " + rs.getString("userAuthor"));
                System.out.println("==============================");
            } else {
                System.out.println("해당 아이디의 도서가 없습니다.");
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("도서오류");
            e.printStackTrace();
        }
    }
}