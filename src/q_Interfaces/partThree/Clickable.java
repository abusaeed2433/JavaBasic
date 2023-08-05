package q_Interfaces.partThree;

public interface Clickable {

    default void onClicked(){
        System.out.println("Clicked in clickable");
    }

}
