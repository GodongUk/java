package package1;

public class B2 {
    public B2() {
        A2 a = new A2();
        a.field1 = 1;
        a.field2 = 1;
        // a.field3 = 1; // private 라 본인 class에서만 사용 가능

        a.method1();
        a.method2();
        // a.method3(); // private 라 본인 class에서만 사용 가능
    }
}
