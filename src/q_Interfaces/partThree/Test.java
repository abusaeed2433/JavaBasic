package q_Interfaces.partThree;

public class Test {

    public static void main(String[] args) {
        testReferenceType();
        testOperationOnVariable();
    }

    private static void testReferenceType(){
        System.out.println("------------- testReferenceType ---------------------------");
        Swimmer swimmer = new Swimmer("John",1);
        swimmer.swim();
    }

    private static void testOperationOnVariable(){
        System.out.println("------------------------ testOperationOnVariable ----------------");

        Swimmable swimmable = null; // can be null
        System.out.println(swimmable);

        swimmable = new Swimmer("Tamim",60);
        double speed = swimmable.DEFAULT_SPEED; // can access constant field
        System.out.println(speed); // 20.0

    }

}
