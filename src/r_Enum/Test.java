package r_Enum;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import static r_Enum.MyWeekDay.*;


public class Test {

    public static void main(String[] args) {
        testGenderEnum();
        testMyWeekDayEnum();
    }

    private static void testMyWeekDayEnum(){
        // statically imported. So can be directly used by constant name
        System.out.println(SATURDAY.name());

        ArrayList<MyWeekDay> days = new ArrayList<>();
        days.add(SATURDAY);
        days.add(MONDAY);
        days.add(THURSDAY);

        System.out.println(countWorkingDays(days)); // 2


    }

    private static int countWorkingDays(List<MyWeekDay> days){
        int counter = 0;

        for(MyWeekDay day : days){
            if(day.isHoliday()) continue;

            counter++;
        }

        return counter;
    }

    private static void testGenderEnum(){

        System.out.println(Gender.MALE); // MALE
        System.out.println(Gender.FEMALE); // FEMALE
        System.out.println(Gender.OTHERS); // OTHERS

        System.out.println(Gender.MALE.name()); // MALE
        System.out.println(Gender.FEMALE.name()); // FEMALE
        System.out.println(Gender.OTHERS.name()); // OTHERS

        System.out.println(Gender.MALE.ordinal());   // 0
        System.out.println(Gender.FEMALE.ordinal()); // 1
        System.out.println(Gender.OTHERS.ordinal()); // 2

        Gender[] values = Gender.values();
        printArray(values); // MALE FEMALE OTHERS
    }

    private static<T> void printArray(T[] arr){
        for(T t : arr){
            System.out.print(t+" ");
        }
        System.out.println("");
    }

}
