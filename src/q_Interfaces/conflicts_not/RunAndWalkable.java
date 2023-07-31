package q_Interfaces.conflicts_not;

public interface RunAndWalkable extends Runnable, Walkable{

    @Override
    default int getStatus() {
        return Runnable.super.getStatus();
    }

}
