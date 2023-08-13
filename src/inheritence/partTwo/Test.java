package inheritence.partTwo;

public class Test {

    public static void main(String[] args) {
        basicBindingTest();

        earlyBindingTest();
    }

    private static void earlyBindingTest(){
        System.out.println("-------------------- earlyBindingTest ----------------");

        Parent parent = new Parent();
        parent.send(); // Parent sending...
        parent.run(); // Parent running...
        System.out.println(parent.id); // 0

        parent = new Child();
        parent.send(); // Parent sending...
        parent.run(); // Parent running...
        System.out.println(parent.id); // 0


        Child child = new Child();
        child.send(); // Child sending...
        child.run(); // Child running...
        System.out.println(child.id); // 1

        ((Parent)child).send(); // Parent sending...
        ((Parent)child).run(); // Parent running...
        System.out.println(((Parent)child).id); // 0

    }

    private static void basicBindingTest(){
        System.out.println("------- basicBindingTest -----------");
        Parent parent = new Child();
        parent.print(); // Child printing...

        parent = new Parent();
        parent.print(); // Parent printing...
    }

}
