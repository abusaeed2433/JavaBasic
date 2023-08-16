

## Formatting Numbers
- Two classes can be used to format and parse numbers,
  - `java.text.NumberFormat`:
    - Used to format a number in a particular `locale`’s predefined format,
 
  - `java.text.DecimalFormat`:
    - Used to format a number in a format `of your choice` in a particular `locale`,
    - Provides advanced formatting,
- Ex(`NumberFormat`): see `numberFormat()` in `Test.java`,
    ```
    private static void numberFormat(){
    
        //------------   default locale USA -----------
        NumberFormat format = NumberFormat.getNumberInstance();
    
        double num = 175570;
        String sn = format.format(num);
        System.out.println(sn); // 175,570
    
        NumberFormat format1 = NumberFormat.getCurrencyInstance();
    
        double num1 = 175570;
        String st = format1.format(num1);
        System.out.println(st); // $175,570.00
    
        //-------------------   BD locale --------------
        NumberFormat format2 = NumberFormat.getNumberInstance(new Locale("en","BD"));
    
        double num2 = 175570;
        sn = format2.format(num2);
        System.out.println(sn); // 175,570
    
        NumberFormat format3 = NumberFormat.getCurrencyInstance(new Locale("en","bd"));
        st = format3.format(num);
        System.out.println(st); // BDT175,570.00
    }
    ```
- Ex(`DecimalFormat`): see `decimalFormat()` in `Test.java`,