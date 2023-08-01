package z_Others;

public class Test {
    public static void main(String[] args) {

    }

}

class OverridingTest{
    public static void main(String[] args) {
        A a= new B();
        a.m1(); // A.m1()
        a.m2(); // B.m2()
    }
}

class A{

    public void m1(){
        System.out.println("A.m1()");
    }

    public void m2(){
        System.out.println("A.m2()");
    }
}
class B extends A{

    public void m2(){
        System.out.println("B.m2()");
    }
}