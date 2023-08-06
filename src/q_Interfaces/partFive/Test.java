package q_Interfaces.partFive;

public class Test {

    public static void main(String[] args) {
        instanceOfTest(); // giver is an object
    }

    private static void instanceOfTest(){
        System.out.println("----------------------- instanceOfTest ------------------");
        Giver giver = new Giver();
        if(giver instanceof Object){
            System.out.println("giver is an object");
        }
        else{
            System.out.println("giver is not an object");
        }
    }

}
