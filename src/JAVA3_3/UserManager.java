package JAVA3_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager implements Manageable {

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

    // User 자바
    Users users = new Users();

    // 회원가입
    @Override
    public void signup(Users users) {
        String sql = "INSERT INTO users (userid, userpassword, username, userphonenumber) "
                + "VALUES (?, ?, ?, ?)";

        try {
            Connection conn = getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, users.getUserId());
            pstmt.setString(2, users.getUserPassword());
            pstmt.setString(3, users.getUserName());
            pstmt.setString(4, users.getUserPhoneNumber());

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("결과: 성공적으로 등록되었습니다.");
            }
            pstmt.close();
            conn.close();
        } catch (java.sql.SQLException e) {

            System.out.println("오류뜸");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("DB오류");
            e.printStackTrace();

        }

    }

    // 로그인
    @Override
    public boolean login(Users users) {
        String sql = "SELECT userid, userpassword "
                + "FROM users "
                + "WHERE userid = ? AND userpassword = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, users.getUserId());
            pstmt.setString(2, users.getUserPassword());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("로그인 성공");
                rs.close();
                pstmt.close();
                conn.close();
                return true;
            } else {
                System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
                rs.close();
                pstmt.close();
                conn.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println("로그인 오류");
            e.printStackTrace();
            return false;
        }
    }

    // 마이페이지
    @Override
    public void mypage(String userId) {
        String sql = "SELECT userid, userpassword, userrent, username, userphonenumber, useryn, userjoindate "
                + "FROM users "
                + "WHERE userid = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("ID : " + rs.getString("userId"));
                System.out.println("PASSWORD : " + rs.getString("userPassword"));
                System.out.println("대여 숫자 : " + rs.getInt("userRent"));
                System.out.println("이름 : " + rs.getString("userName"));
                System.out.println("전화번호 : " + rs.getString("userPhoneNumber"));
                System.out.println("대출가능여부 : " + rs.getString("userYn"));
                System.out.println("가입일 : " + rs.getString("userJoinDate"));
            } else {
                System.out.println("뭔가 뭔가임");
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("뭔가오류");
            e.printStackTrace();
        }
    }

    // 정보 수정
    @Override
    public void edit(String userId, String userPassword, String userPhoneNumbeString) {
        Connection conn = null;
        try {
            // JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            // 연결하기
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234");
            // 매개변수화된 SQL 문 작성
            String sql = new StringBuilder()
                    .append("UPDATE users SET ")
                    .append("userpassword=?, ")
                    .append("userphonenumber=? ")
                    .append("WHERE userid=? ")
                    .toString();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userPassword);
            pstmt.setString(2, userPhoneNumbeString);
            pstmt.setString(3, userId);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("개인정보 변경이 완료되었습니다.");
            } else {
                System.out.println("해당 회원을 찾을 수 없습니다.");
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
