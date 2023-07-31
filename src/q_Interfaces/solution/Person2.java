package q_Interfaces.solution;

public class Person2 implements Walkable{
    private String name;
    public Person2(String name) {
        this.name = name;
    }

    @Override
    public void walk() {
        System.out.println(name + " (a person) is walking.");
    }

}
