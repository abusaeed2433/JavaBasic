package q_Interfaces.problemAndSolution;

public class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public void walk() {
        System.out.println(name + " (a person) is walking.");
    }
}
