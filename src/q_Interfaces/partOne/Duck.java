package q_Interfaces.partOne;

public class Duck {
    private String name;
    public Duck(String name) {
        this.name = name;
    }
    public void walk() {
        System.out.println(name + " (a duck) is walking.");
    }
}
