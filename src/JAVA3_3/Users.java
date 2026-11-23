package JAVA3_3;

public class Users {
    private String userId;
    private String userPassword;
    private int userRent;
    private String userName;
    private String userPhoneNumber;
    private String userYn;
    private String userRole;
    private String userJoinDate;

    public Users() {
    }

    public Users(String userId, String userPassword, String userName, String userPhoneNumber) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
    }

    public Users(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserRent() {
        return userRent;
    }

    public void setUserRent(int userRent) {
        this.userRent = userRent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserYn() {
        return userYn;
    }

    public void setUserYn(String userYn) {
        this.userYn = userYn;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserJoinDate() {
        return userJoinDate;
    }

    public void setUserJoinDate(String userJoinDate) {
        this.userJoinDate = userJoinDate;
    }
}