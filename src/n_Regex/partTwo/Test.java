package n_Regex.partTwo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {

        backslashTest();

    }

    private static void backslashTest(){
        System.out.println("-------------------- backslashTest ----------------------");

        //String regex = "\\[[0-9]\\]";
        String regex = "\\[[0-9]]"; // both are valid. ] itself don't have special meaning. So backslashes is optional

        Pattern pattern = Pattern.compile(regex);

        String[] arr = {"[0]","[1","[s]","2]","[5]","[O]"};

        for (String str : arr){
            Matcher matcher = pattern.matcher(str);
            if(matcher.find()){
                System.out.println(str+" -> passed");
            }
            else {
                System.out.println(str+" -> failed");
            }
        }

        /*
         Output:
         [0] -> passed
         [1 -> failed
         [s] -> failed
         2] -> failed
         [5] -> passed
         [O] -> failed. This capital 'O', not zero
         */

    }

}
