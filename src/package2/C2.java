package package2;

import package1.A2;

public class C2 {
    public C2() {
        A2 a = new A2();
        a.field1 = 1;
        // a.field2 = 1;// default라 같은 패키지가 아니면 사용할수없음
        // a.field3 = 1;// private라 본인 class 에서만 쓸수 있음
        a.method1();
        //a.method2();
        //a.method3();
        
    }
}
