package g_TheObjectClass;

public class Test {

    public static void main(String[] args) {
        ruleTest1();
        testGetClass();
        hashTest();
    }



    private static void hashTest(){
        System.out.println("-------------------- hashTest ---------------------");

        Student saeed = new Student(57,"Saeed",21,170);
        Student jakaria = new Student(56,"Jakaria",22,171);
        Student saeedAgain = new Student(57,"Saeed",21,170);


        System.out.println(saeed.hashCode()); // 4218704
        System.out.println(jakaria.hashCode()); // 4213539
        System.out.println(saeedAgain.hashCode()); // 4218704


    }



    private static void testGetClass(){
        System.out.println("-------------------- testGetClass ---------------------");
        Cat cat = new Cat("Cat");
        Class<?> catClass = cat.getClass();

        System.out.println(catClass); // class g_TheObjectClass.Cat

        System.out.println(catClass.getName()); // g_TheObjectClass.Cat

        System.out.println(catClass.getSimpleName()); // Cat
    }

    private static void ruleTest1(){

        Object myObj = new Object();


        String name = "hello";
        Object nameObj = name; // ok

        Object name2 = "hello"; // ok
        System.out.println(name2); // hello


        Exception exception = new Exception("anything");
        Object ex = exception;
    }

}
