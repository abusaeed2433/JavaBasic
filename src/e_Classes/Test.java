package e_Classes;

public class Test {



    public static void main(String[] args) {

        //creating object
        Hooman saeed = new Hooman("Saeed",21);
        System.out.println(saeed.isAdult()); // true

        // null
        String name = null;
        Integer number = null;
        Hooman none = null;
        //int count = null; //compile time error
        //none.getAge(); // runtime exception

        Hooman sh = new Hooman("sh",22);
        sh = null;


    }

    public int add(int num1, int num2){
        return num1+num2;
    }

}
