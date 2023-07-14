package commandLineCalc;

import java.util.Arrays;

public class Calculator {

    //not executing through command line. Ignoring
    public static void main(String[] args) {

        if(args.length < 3 || args[1].length() != 1) {
            System.out.println("Invalid operation");
            return;
        }

        try {
            double n1 = Double.parseDouble(args[0]);
            double n2 = Double.parseDouble(args[2]);

            System.out.println(Arrays.toString(args) +" = "+ calc(n1,n2,args[1]));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static double calc(double n1, double n2, String op) throws Exception{
        return switch (op) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            default -> throw new Exception("Invalid operation");
        };
    }

}
