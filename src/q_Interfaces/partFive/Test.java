package q_Interfaces.partFive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        instanceOfTest(); // giver is an object
        comparableTest();
    }

    private static void comparableTest(){
        System.out.println("--------------------- comparableTest -----------------");

        // using Bard
        Student student1 = new Student(112, "Rakib Hasan", "rakibhasan@gmail.com", 1.75);
        Student student2 = new Student(23, "Sadia Akter", "sadiaakter@gmail.com", 1.65);
        Student student3 = new Student(34, "Ariful Islam", "arifulislam@gmail.com", 1.80);
        Student student4 = new Student(4, "Tasnim Akhter", "tasnimakhter@gmail.com", 1.55);
        Student student5 = new Student(54, "Rafi Ahmed", "rafi@gmail.com", 1.70);
        Student student6 = new Student(15, "Sumaiya Khatun", "sumaiya@gmail.com", 1.60);

        List<Student> students = new ArrayList<>();
        students.add(student1); students.add(student2); students.add(student3);
        students.add(student4); students.add(student5); students.add(student6);

        printRolls(students); // Rakib(112) Sadia(23) Ariful(34) Tasnim(4) Rafi(54) Sumaiya(15)
        Collections.sort(students);
        printRolls(students); // Tasnim(4) Sumaiya(15) Sadia(23) Ariful(34) Rafi(54) Rakib(112)
    }

    private static void printRolls(List<Student> list){
        for(Student std : list){
            System.out.print(std.getFirstName()+"("+std.getRoll()+") ");
        }
        System.out.println("");
    }

    private static void instanceOfTest(){
        System.out.println("----------------------- instanceOfTest ------------------");
        Giver giver = new Giver();
        if(giver instanceof Object){
            System.out.println("giver is an object");
        }
        else{
            System.out.println("giver is not an object");
        }
    }

}
