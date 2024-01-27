package z_Others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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


    public static void main(String[] args) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<10;i++){
            map.computeIfAbsent(i+100,v-> new LinkedList<>()).add(i);
        }

        System.out.println(map);

    }

}