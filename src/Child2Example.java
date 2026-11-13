public class Child2Example {
    public static void main(String[] args) {
        Parent2 parent = new Child2();
        parent.field1 = "data1";
        parent.method1();
        parent.method2();

        Child2 child = (Child2) parent;
        child.field2 = "yyy";
        child.method3();
    }
}
