package inheritence.partTwo;

public class Test {

    public static void main(String[] args) {
        basicBindingTest();
    }

    private static void basicBindingTest(){
        Parent parent = new Child();
        parent.print();

        parent = new Parent();
        parent.print();
    }

}
