package e_Classes;

public class Hooman {
    private String name;
    private int age;
    private boolean isAdult;

    public Hooman(String name, int age) {
        this.name = name;
        this.age = age;
        isAdult = age >= 18;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0 || age < this.age) return;

        this.age = age;
        isAdult = (age>=18);
    }

    public boolean isAdult() {
        return isAdult;
    }

}
