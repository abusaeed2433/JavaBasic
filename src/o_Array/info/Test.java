package o_Array.info;

import java.sql.Array;

public class Test {

    public static void main(String[] args) {
        declareArray();
        arrayTest();
    }

    private static void arrayTest(){
        int[] arr = new int[5];
        for(int i=0;i<arr.length;i++) arr[i] = i+5;

        Object obj = arr; // array are object. So assignment is possible
        printArray(arr); // 5 6 7 8 9

        int[] brr = (int[])obj;
        printArray(brr); // 5 6 7 8 9

        // default
        String[] names = new String[4];
        printArray(names); // null null null null

        names[0] = "Pantho";
        names[2] = "Aslam";
        printArray(names); // Pantho null Aslam null

        names[1] = "Maruf";
        names[3] = "Anik";

        printArray(names); // Pantho Maruf Aslam Anik
        for (int i=0;i<names.length; i++){
            names[i] = names[i].substring(0,1);
        }
        printArray(names); // P M A A

        int[] rolls = new int[]{1,2,3,4,5};
        int[] rolls2 = {1,2,3,4,5};

    }

    private static void printArray(int[] arr){
        for (int t : arr) {
            System.out.print(t + " ");
        }
        System.out.println("");
    }

    private static <T> void printArray(T[] arr){
        for (T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println("");
    }

    private static void declareArray(){
        int[] arr = new int[5];
        for(int i=0; i<5; i++) arr[i] = i+1;

        for(int i=0; i<5; i++) System.out.print(arr[i]+" "); // 1 2 3 4 5
        System.out.println("");
    }
}
