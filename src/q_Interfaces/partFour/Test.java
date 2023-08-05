package q_Interfaces.partFour;

public class Test {

    public static void main(String[] args) {
        conflictTest1();
    }

    private static void conflictTest1(){
        System.out.println("------------------- conflictTest1 -------------------");
        MultipleClick mc = new MultipleClick();
        mc.onClicked(); //Calling from click detector
    }

}
