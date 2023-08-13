package g_TheObjectClass;

public class Test {

    public static void main(String[] args) {
        ruleTest1();
        testGetClass();
        hashTest();
        equalsTest();
        defaultEqualsTo();
        customEqualsTo();

        cloneTest();
        cloneTest2();
    }

    private static void cloneTest2(){
        System.out.println("-------------------- cloneTest2 ---------------");

        Human tomal = new Human("Tomal","Loki");

        System.out.println(tomal); // owner: Tomal, catName: Loki

        Human copied = (Human) tomal.clone();

        System.out.println(copied); // owner: Tomal, catName: Loki

        copied.setName("Totomal");
        System.out.println(tomal); // owner: Tomal, catName: Loki
        System.out.println(copied); // owner: Totomal, catName: Loki

        copied.setCatName("kilo");
        System.out.println(tomal); // owner: Tomal, catName: kilo <--------------------
        System.out.println(copied);// owner: Totomal, catName: kilo <-------------------

    }

    private static void cloneTest(){
        System.out.println("-------------------- cloneTest ---------------");

        Student who = new Student(269,"who",23,173);

        System.out.println(who); // roll: 269, name: who, age: 23, height: 173.0

        Student copied = (Student) who.clone();

        System.out.println(copied); // roll: 269, name: who, age: 23, height: 173.0

        copied.setAge(30);
        System.out.println(copied); // roll: 269, name: who, age: 30, height: 173.0
        System.out.println(who); // roll: 269, name: who, age: 23, height: 173.0
    }

    private static void customEqualsTo() {
        System.out.println("-------------------- customEqualsTo ---------------");

        Student atik = new Student(38,"Atik",22,168);

        System.out.println(atik.toString()); // roll: 38, name: Atik, age: 22, height: 168.0


        Student galib = new Student(35,"Galib",22,-173);

        int heightInFeet = (int)(galib.getHeight() / 39);
        System.out.println(heightInFeet); // negative so, must have some problem with value

        //finding that problem
        System.out.println(galib.toString()); // roll: 35, name: Galib, age: 22, height: -173.0

        galib.setHeight(173); // fixing

        heightInFeet = (int)(galib.getHeight() / 39);
        System.out.println(heightInFeet); // fine

    }


    private static void defaultEqualsTo(){
        System.out.println("-------------------- defaultEqualsTo ---------------");
        Cat cat = new Cat("Happy 3X");

        System.out.println(cat.toString()); // g_TheObjectClass.Cat@4dd8dc3
        System.out.println(cat); // g_TheObjectClass.Cat@4dd8dc3

        //above two statements are equivalent
    }


    private static void equalsTest(){
        System.out.println("-------------------- equalsTest ---------------------");

        Student saeed = new Student(57,"Saeed",21,170);
        Student jakaria = new Student(56,"Jakaria",22,171);
        Student saeedAgain = new Student(57,"Saeed",21,170);

        Cat cat = new Cat("Happy");

        System.out.println(jakaria.equals(jakaria)); // same reference - true

        System.out.println(cat.equals(saeed)); // object of different classes - false

        System.out.println(saeed.equals(jakaria)); // different hashCode - false

        System.out.println(saeed.equals(saeedAgain)); // fine - true

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
