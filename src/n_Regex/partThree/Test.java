package n_Regex.partThree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {

        groupNameTest();
        resetTest();

    }

    private static void resetTest(){
        System.out.println("---------------------- resetTest ---------------------------");
        String[] arr = {"+8801792101111", "+8801234567890", "+8804324567890","+2101234"};

        String regex = "(?<code>\\+\\d{3})(?<num>\\d+)\\b";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(""); // dummy

        for(String phone : arr){
            matcher.reset(phone);

            matcher.find();

            String code = matcher.group("code");
            String num = matcher.group("num");
            System.out.println(code+" - "+num);
        }

        /*
        Output
        +880 - 1792101111
        +880 - 1234567890
        +880 - 4324567890
        +210 - 1234
        */
    }

    private static void groupNameTest(){
        System.out.println("------------------- groupNameTest -----------------------------------");

        /*
            will find phone number,
            find code & number from that phone number,
            format the number & print
        */

        String phones = "+8801792101111, +8801234567890, +++8804324567890,+-+2101234";

        String regex = "(?<code>\\+\\d{3})(?<num>\\d+)\\b"; // \ is used before +, since + has special meaning
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(phones);

        while (matcher.find()){
            String code = matcher.group("code");
            String num = matcher.group("num");

            System.out.println(code+" - "+num);
        }

        /*
        +880 - 1792101111
        +880 - 1234567890
        +880 - 4324567890
        +210 - 1234
        */

    }

}
