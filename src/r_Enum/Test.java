package r_Enum;

import java.sql.SQLSyntaxErrorException;

public class Test {

    public static void main(String[] args) {
        testGenderEnum();
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
