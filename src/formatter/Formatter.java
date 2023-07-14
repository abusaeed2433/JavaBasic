package formatter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Formatter {

    public static void main(String[] args) {
        //new Formatter().numberFormat();
        new Formatter().decimalFormat();
    }

    private void decimalFormat(){
        double num = 175.570;

        String pattern = "####.####";
        DecimalFormat format = new DecimalFormat();
        format.applyPattern(pattern);
        String sn = format.format(num);
        System.out.println(sn); // 175.57

        pattern = "0000.0000";
        format.applyPattern(pattern);
        sn = format.format(num);
        System.out.println(sn); // 0175.5700

        num = -125.53;
        pattern = "#.##";
        format.applyPattern(pattern);
        sn = format.format(num);
        System.out.println(sn);// -125.53

        num = 12.53;
        pattern = "#.##;#.##";
        format.applyPattern(pattern);
        sn = format.format(num); System.out.println(sn); // 12.53

        num = -12.53;
        sn = format.format(num); System.out.println(sn); // -12.53


        num = 12.53;
        pattern = "#.##;(#.##)";
        format.applyPattern(pattern);
        sn = format.format(num); System.out.println(sn); // 12.53

        num = -12.53;
        sn = format.format(num); System.out.println(sn); // (12.53) idk whats happening here

    }

    private void numberFormat(){
        double num = 175570;

        //------------   default locale USA -----------
        NumberFormat format = NumberFormat.getNumberInstance();
        String sn = format.format(num);
        System.out.println(sn); // 175,570

        NumberFormat format1 = NumberFormat.getCurrencyInstance();
        String st = format1.format(num);
        System.out.println(st); // $175,570.00


        //-------------------   BD locale --------------
        format = NumberFormat.getNumberInstance(new Locale("en","BD"));
        sn = format.format(num);
        System.out.println(sn); // 175,570

        format1 = NumberFormat.getCurrencyInstance(new Locale("en","bd"));
        st = format1.format(num);
        System.out.println(st); // BDT175,570.00

        // if wrong locale is used then
        // Number: 175,570
        // Currency: �175,570.00

    }

}
