package e_ClassesAndObject;
import javax.swing.plaf.synth.SynthUI;

import static e_ClassesAndObject.TriState.StateEnum.*;
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


        Hooman anik = new Hooman("Anik",22);
        anik.showSpecificCharacter(); // Name is => Anik

        anik.showSomeCharacter(); // General characteristics. ok but not recommended
        Hooman.showSomeCharacter(); // General characteristics. best practice

        TriState triState = new TriState(SECOND);
        System.out.println(triState.state); // SECOND

        birdTest();
        finalTest();
    }

    private static void finalTest(){
        Circle circle = new Circle();
        System.out.println(circle.getArea()); // 0.0

        Circle circle1 = new Circle(4);
        System.out.println(circle1.getArea()); // 50.264
    }

    private static double getArea(final double r){ // final parameter
        final double pi = 3.1415; // final local variable
        //pi = 3; error
        //r=5;
        return pi*r*r;
    }

    private static void birdTest(){
        Bird deadBird = new Bird(); // 1
        deadBird.printDetails(); // Unknown -> Not found -> false

        Bird unknownBird = new Bird(true); // 2
        unknownBird.printDetails(); // Eagle -> Eagle -> true

        Bird eagle = new Bird("Eagle", "Eagle", true); // 3
        eagle.printDetails(); // unknown -> Not found -> true

        Bird secondEagle = new Bird(eagle); // 4
        secondEagle.printDetails(); // Eagle -> Eagle -> true

    }

    public int add(int num1, int num2){
        return num1+num2;
    }

}
