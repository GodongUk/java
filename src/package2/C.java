package package2;
import package1.A;

public class C {
    A a1 = new A(true);
    //A a2 = new A(1); // class A 안에 생성자가 default라 같은 패키지 안에서만 사용가능
    //A a3 = new A("문자열"); // A생성자는 private 라 본인 class 에서만 사용가능
}
