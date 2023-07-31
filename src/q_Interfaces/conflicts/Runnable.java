package q_Interfaces.conflicts;

public interface Runnable {
    int STATUS = 1;

    void run();

    default int getStatus(){
        return STATUS;
    }

    static void stop(){
        System.out.println("Runnable stopped...");
    }

}