package JAVA3_3;


public interface  Manageable {
    void signup(Users users);
    boolean login(Users users);
    void mypage(String userId);
    void edit(String userId, String userPassword, String userPhoneNumbeString);
}
