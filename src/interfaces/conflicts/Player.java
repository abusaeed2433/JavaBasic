package interfaces.conflicts;

import interfaces.without.Person;

public class Player extends Person implements RunAndWalkable{

    public Player(int id) {
        super(id);
    }

    @Override
    public void run() {
        System.out.println("Player running...");
    }

    @Override
    public void walk() {
        System.out.println("Player walking...");
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }
}
