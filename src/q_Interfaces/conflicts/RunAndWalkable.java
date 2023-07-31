package q_Interfaces.conflicts;

public interface RunAndWalkable extends Runnable, Walkable{

    @Override
    default int getStatus() {
        return Runnable.super.getStatus();
    }

}
