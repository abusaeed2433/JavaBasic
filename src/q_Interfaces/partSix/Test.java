package q_Interfaces.partSix;

public class Test {

    public static void main(String[] args) {
        testPolymorphic();

        Turtle turti = new Turtle("Turti");
        startWalking(turti); // Turti is walking...
    }

    private static void testPolymorphic(){
        Turtle turti = new Turtle("Turti");

        Swimmable swimmable = turti;
        Walkable walkable = turti;
        Object obj = turti;

    }

    private static void startWalking(Walkable walkable){
        walkable.walk(); // Can't access other method
        // ((Turtle)walkable).bite(); // ok after converting
    }

}
