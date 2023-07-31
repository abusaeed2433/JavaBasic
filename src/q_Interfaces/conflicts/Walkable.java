package q_Interfaces.conflicts;

public interface Walkable {
    int STATUS = 2;


    void walk();

    int getStatus();

    static void stop(){
        System.out.println("Walkable stopped...");
    }

}
