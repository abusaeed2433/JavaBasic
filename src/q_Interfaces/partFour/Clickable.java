package q_Interfaces.partFour;

public interface Clickable {

    default void onClicked(){
        System.out.println("Clicked in clickable");
    }

}
