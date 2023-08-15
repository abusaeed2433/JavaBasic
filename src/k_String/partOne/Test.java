package k_String.partOne;

public class Test {

    public static void main(String[] args) {
        escapeTest();
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
