package k_String.partOne;

public class Test {

    public static void main(String[] args) {
        escapeTest();
        charSequenceTest();
        stringConstructorTest();
    }

    private static void stringConstructorTest(){
        System.out.println("--------------------- constructorTest ---------------------");

        String name;

        name = new String(); // empty String
        System.out.println(name); //

        name = new String("Hello");
        System.out.println(name); // Hello

        char[] chars = {'1','2','3','4','a','b','d'};
        name = new String(chars);
        System.out.println(name); // 1234abd

        name = new String(chars,3,3); // start from index - 3 & take 3 characters from index-3
        System.out.println(name); // 4ab

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
