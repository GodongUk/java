package JAVA3_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RentManager {
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

    // 책 빌렸을때
    public void bookRent(int bookNum) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE books SET bookyn = 'N' "
                    + "WHERE booknum = ? AND bookyn = 'Y'";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookNum);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("책이 대여 되었습니다.");
            } else {
                System.out.println("음 ..........");
            }
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    // 연결 끊기
                    conn.close();

                } catch (SQLException e) {
                }
            }
        }
    }
}
