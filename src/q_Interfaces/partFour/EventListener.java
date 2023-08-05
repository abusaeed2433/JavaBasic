package q_Interfaces.partFour;

public interface EventListener extends Clickable{

    @Override
    default void onClicked() {
        System.out.println("click from event listener");
    }

}
