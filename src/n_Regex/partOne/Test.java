package n_Regex.partOne;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        basicRegex();
        compileRegex();
    }

    private static void compileRegex(){
        System.out.println("--------------- compileRegex -------------------");

        String regex = "[ABO][+-]";
        Pattern pattern = Pattern.compile(regex);

        String input = "O+";
        Matcher matcher = pattern.matcher(input);


    }

    private static void basicRegex(){
        System.out.println("--------------- basicRegex --------------------");

        String regex = "[ABO][+-]";
        Pattern pattern = Pattern.compile(regex);

        String[] arr = {"A+","AB-","B-","O"};

        for(String bg : arr) {
            Matcher matcher = pattern.matcher(bg);

            if(matcher.matches()){ System.out.println(bg+" passed"); }
            else{ System.out.println(bg+" failed"); }

        }

        /*
         A+ passed
         AB- failed
         B- passed
         O failed
         */

    }

}
