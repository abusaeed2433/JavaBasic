package assertion;

public class Test {

    public Test(){

    }

    public static void main(String[] args) {
        new Test().startTest();
    }

    private void startTest(){
        int divider = getDivider();

        assert divider != 0 : "idiot";;


        //above code won't show any error or exception. For catching exception just compile with cmd using -ea[enable assertion]
        //java -ea -cp D:\own\Java\Projects\CompleteJava\src assertion.Test

        //after enabling
        /*Exception in thread "main" java.lang.AssertionError: idiot
                at assertion.Test.startTest(Test.java:16)
                at assertion.Test.main(Test.java:10)*/

//        int ans = 100/divider;
//
//        System.out.println(ans);


        boolean enabled = false;
        boolean idiot = false;


        //assert enabled = true;  -- -- -- 1
        assert idiot = enabled = true;

        // above code(1) is like
        // assert true
        // if assert is not enabled then, enabled = become false.
        // same for line 2

        System.out.println(enabled);
        System.out.println(idiot);

        //output false - false

    }

    private int getDivider(){
        return 0;
    }

}
