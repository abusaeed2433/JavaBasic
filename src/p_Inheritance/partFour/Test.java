package p_Inheritance.partFour;

public class Test {

    public static void main(String[] args) {

        System.out.println( add(5,10) ); // 15
        System.out.println( add(5.0,10) ); // 15.8


        MyMath myMath = new MyMath();
        myMath.sub(5.0,2); // fine
        myMath.sub(5,2.0); // fine
        //myMath.sub(5,5); // ambiguous - compile-time error

    }


    private static int add(int x, int y){
        int res = (x+y);
        System.out.println("int add");
        return res;
    }

    private static double add(double x, double y){
        double res = x+y;
        System.out.println("double add");
        return res;
    }

}
