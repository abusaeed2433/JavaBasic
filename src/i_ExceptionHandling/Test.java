package i_ExceptionHandling;

import java.io.*;

public class Test {

    public static void main(String[] args) {
//        firstTest(0);
//        firstTestBadSolution(0);
//        firstTestSolution(0);

        String fullPath = "/D:/Own/Java/Projects/JavaPractice/out/production/JavaPractice/i_ExceptionHandling/files/dummy.txt";
        catchExceptionOrder(0,"Saeed",fullPath);
        catchExceptionOrder(2,null,fullPath);
        catchExceptionOrder(1,"Saeed","invalid.txt");
    }

    private static void catchExceptionOrder(int y, String message, String filePath){
        try{

            int x = 10;
            int result = x/y;

            String lower = message.toLowerCase();

            FileReader fileReader = new FileReader(filePath);
            printFile(fileReader);
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error in reading file");
        }
        catch (ArithmeticException e){
            System.out.println("Can't divide");
        }
        catch (RuntimeException e){
            System.out.println("lower failed");
        }
    }

    private static void printFile(FileReader fileReader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder content = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n"); // Append each line to the StringBuilder
        }
        bufferedReader.close();
        System.out.println(content.toString().trim());

    }

    private static void firstTest(int y){
        int x = 10;

        int result = (x/y); // will throw exception if y == 0

        System.out.println(result); // `/ by zero when` y = 0;

    }

    private static void firstTestBadSolution(int y){
        int x = 10;

        if(y == 0){
            System.out.println("Can't divide"); // Can't divide
        }
        else{
            int result = x/y;
            System.out.println(result);
        }
    }

    private static void firstTestSolution(int y){
        int x = 10;
        try {
            int result = x/y;
            System.out.println(result);
        }
        catch (Exception e){
            System.out.println("Can't divide"); // executed when y = 0
        }
    }

}
