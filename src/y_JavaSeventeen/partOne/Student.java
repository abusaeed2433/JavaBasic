package y_JavaSeventeen.partOne;

public class Student {
    private int roll;
    private String name;
    private double height;
    private JustListener justListener;

    public Student(int roll, String name, double height) {
        this.roll = roll;
        this.name = name;
        this.height = height;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


}
