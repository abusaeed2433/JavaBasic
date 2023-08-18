package y_JavaSeventeen.partOne;

public class Test {

    public static void main(String[] args) {
        varTest();
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
