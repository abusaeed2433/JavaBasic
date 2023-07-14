package sort;

public class Person implements Comparable<Person>{
    private final String name;
    private final int roll, age, height;

    public Person(String name, int roll, int age, int height) {
        this.name = name;
        this.roll = roll;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public void print(){
        System.out.printf("%1$5d %2$10s %3$5d %4$5d%n",roll,name,age,height);
    }

    @Override
    public int compareTo(Person o) {
        return roll - o.roll;
    }

}
