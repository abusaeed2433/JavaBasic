package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Sort {


    public static void main(String[] args) {
        new Sort().sortData();
    }

    private void sortData(){

        Person[] people = new Person[5];

        for(int i=0;i<5;i++){

            people[i] = new Person(
                    "Person"+(i+1),
                    4-i,
                    (4-i)*2,
                    (100-i)/2
            );
        }

        printAll(people);

        System.out.printf("%s %n","After sorting....");
        Arrays.sort(people);
        printAll(people);

        System.out.printf("%s %n","Sorting height then roll reverse");

        Comparator<Person> heightComparator = Comparator.comparingInt(Person::getHeight);

        Comparator<Person> rollComparator = (Comparator.comparingInt(Person::getRoll)).reversed();

        heightComparator = heightComparator.thenComparing(rollComparator);

        Arrays.sort(people,heightComparator);
        printAll(people);

        // perfect

    }

    private void printAll(final Person[] people){
        System.out.printf("%1$5s %2$10s %3$5s %4$5s %n","Roll","Name","Age","Height");
        for(Person person : people){
            person.print();
        }
    }

}
