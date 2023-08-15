package k_String.partOne;

public class Test {

    public static void main(String[] args) {
        escapeTest();
        charSequenceTest();
    }


    private static void printWithLength(CharSequence cs){
        System.out.println(cs+" -> "+cs.length());
    }

    private static void charSequenceTest(){
        System.out.println("--------------------- charSequenceTest -----------------------");

        String name = "Hello S";
        printWithLength(name); // Hello S -> 7

        StringBuffer buffer = new StringBuffer("Buffer"); // will be discussed later
        printWithLength(buffer); // Buffer -> 6

        StringBuilder builder = new StringBuilder("Builder"); // will be discussed later
        printWithLength(builder); // Builder -> 7

    }


    private static void escapeTest(){
        System.out.println( "hello" ); // hello

        System.out.println( "he\nllo" );
        // he
        // llo

        System.out.println( "100%" ); // 100%
        System.out.println( "Said by \"Unknown\"" ); // Said by "Unknown"

        System.out.println("Apple"); // Apple
        System.out.println("\u0041pple"); // Apple

    }


}
