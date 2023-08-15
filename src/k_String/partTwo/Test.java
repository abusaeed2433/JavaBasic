package k_String.partTwo;

import java.util.Arrays;
import java.util.Locale;

public class Test {

    public static void main(String[] args) {

        testFewOperations();

    }

    private static void testFewOperations(){
        String str = "I can write poems";

        // str.charAt(int i) return character at position i, Runtime error if i is invalid
        System.out.println( str.charAt(2) ); // c

        // str1.equals(str2) or str1.equalsIgnoreCase(str2)
        String str1 = "Hello";
        String str2 = "hello";

        System.out.println( str1.equals(str2) ); // false
        System.out.println( str1.equalsIgnoreCase(str2) ); // true

        System.out.println("--------------------------- ");
        // empty check
        String name = "";

        System.out.println( name.isEmpty() ); // true
        System.out.println( name.equals("") ); // true
        System.out.println( name.length()==0 ); // true

        System.out.println("--------------------------- ");
        // changing case - new object is created. Remember, String is immutable

        String mix = "Process FINISHED";
        System.out.println( mix.toUpperCase() ); // PROCESS FINISHED
        System.out.println( mix.toLowerCase() ); // process finished

        System.out.println("--------------------------- ");

        String msg = "You are welcome";
        System.out.println( msg.indexOf('o') ); // 1 - first o
        System.out.println( msg.indexOf('x') ); // -1
        System.out.println( msg.indexOf("are") ); // 4

        System.out.println( msg.lastIndexOf('o') ); // 12

        System.out.println("--------------------------- ");

        // Representing value into String
        String strInt = String.valueOf(1000);
        System.out.println(strInt); // 10000

        String strDou = String.valueOf(200.5d);
        System.out.println(strDou); // 200.5

        String strBoo = String.valueOf(true);
        System.out.println(strBoo); // true

        System.out.println("--------------------------- ");

        // substring(startIndex) or substring(startIndex,lastIndex) = startIndex = before lastIndex

        String total = "Rahim Karim Tamim";

        String rahim = total.substring(0,5);
        System.out.println(rahim); // Rahim

        String karim = total.substring(6,11);
        System.out.println(karim); // Karim

        // str.trim() remove all leading and trailing whitespaces and control characters from a string

        String code = " \n hello pluto \t ";
        System.out.println( code.trim() ); // hello pluto


        System.out.println("-----------------------------------");
        // replace(old,new)

        String greeting = "Hello old man, Hello";
        System.out.println( greeting.replace("Hello","Hi") ); // Hi old man, Hi
        System.out.println( greeting.replaceAll("Hello","Hi") ); // Hi old man, Hi
        // in replaceAll regex(will discuss later insha'Allah) can be used.

        System.out.println("-----------------------------------");
        // Matching Start and End of a String
        String eq = "20 + 22 = 42";
        System.out.println( eq.startsWith("2")); // true
        System.out.println( eq.endsWith("42")); // true

        System.out.println("-----------------------------------");

        // splitting and joining string
        String strVowels = "a,e,i,o,u";
        String[] vowels = strVowels.split(","); //split(regex)
        System.out.println(Arrays.toString(vowels)); // [a, e, i, o, u]

        System.out.println("-----------------------------------");

        String joined = String.join(",","A","E","I","O","U"); // 1st one is separator
        System.out.println(joined); // A,E,I,O,U

        System.out.println("-----------------------------------");



    }

}
