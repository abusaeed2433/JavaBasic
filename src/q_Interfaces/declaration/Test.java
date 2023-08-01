package q_Interfaces.declaration;

public class Test {

    public static void main(String[] args) {
        testConstantField();
    }

    private static void testConstantField(){
        System.out.println(Clickable.SINGLE_CLICK); // 1

        System.out.println(Clickable.DOUBLE_CLICK_INTERVAL); // 500

        //Clickable.DOUBLE_CLICK = 10; // error since implicitly final

    }

}
