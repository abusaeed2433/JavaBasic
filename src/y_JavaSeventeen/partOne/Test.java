package y_JavaSeventeen.partOne;

import java.util.Map;

public class Test {

    public static void main(String[] args) {
        varTest();
        switchTest();
    }

    private static void switchTest(){
        System.out.println("------------------------- switchTest -------------------------");

        int i = 20;
        switch (i){
            case 10 -> {
                System.out.println(10);
                System.out.println("10");
            }
            case 20-> System.out.println(20); // executed
            default-> System.out.println("Other");
        }

        i = 40;
        String message = switch (i){
            case 10 -> "10";
            case 20 -> "20";
            case 30 -> throw new RuntimeException("idk");
            case 40 ->{
                System.out.println("40"); // executed
                yield "like return";
            }
            default -> "none";
        };

        System.out.println(message); // like return

    }


    private static void varTest(){
        System.out.println("------------------- varTest -------------------------");
        var name = new String("hello");
        System.out.println(name); // hello

        var student = new Student(121,"Doniel",5.9);
        System.out.println(student.getName()); // Doniel
        System.out.println(student.getHeight()); // 5.9

    }

}
