package classmate;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//added in .gitignore
public class ClassMate {

    public static void main(String[] args) {
        //new ClassMate().testDate();
        //new ClassMate().routine();

        //new ClassMate().getDateFromDays();
        //new ClassMate().sortCheck();
        //new ClassMate().curTimeTest();
        //new ClassMate().slowParse();

        //new ClassMate().findProject();

        //System.out.println(new ClassMate().getFormattedDate());
        //System.out.println(new ClassMate().getTimestampForDeletion());

        //System.out.println(new ClassMate().getFormattedTime());
        //System.out.println(new ClassMate().getTimeStamp());

        // 1678377600000L - expected
        // 1678399200000
        // 1678399200000

        long ts = 1678378500000L;
//        timestampTest(ts);
        long timestamp = getUtcTimeStamp("09/03/2023","10:15PM");
        System.out.println(timestamp + "  "+ts+ " "+(timestamp==ts));


    }

    private static void timestampTest(long timestamp){
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        System.out.println(localDateTime);
    }

    private void regexTest(){
        String code = "PHY lab";
        String regex = "\\b([a-zA-Z]+)\\D*(\\d*)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(code);
        if(matcher.find()){
            String newCode = matcher.group(1)+" "+matcher.group(2);
            System.out.println(newCode.toUpperCase());
        }
        else{
            System.out.println("No match found");
        }

    }

    public static long getUtcTimeStamp(String date,String time){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mma",Locale.US);

            String timeHour = date + " " + time;

            TemporalAccessor accessor = formatter.parse(timeHour);
            LocalDateTime ldt = LocalDateTime.from(accessor);

            ZonedDateTime dateTime = ldt.atZone(ZoneId.systemDefault());

            ZonedDateTime zonedDateTime = dateTime.withZoneSameInstant(ZoneOffset.UTC);

            return zonedDateTime.toInstant().toEpochMilli();
        }
        catch (Exception e){
            e.printStackTrace();
            return Long.MIN_VALUE;
        }
    }

    private long getTimeStamp(){
        Map<Long,Integer> map = new HashMap<>();
        map.put(1L,43);
        System.out.println(map.containsKey(1L));
        System.out.println(map.containsKey(24L));
        map.remove(34L);


        String time = "03/10/21 at 10:52 PM";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy 'at' h:mm a",Locale.US);
        TemporalAccessor accessor = formatter.parse(time);
        LocalDateTime dateTime = LocalDateTime.from(accessor);
        return dateTime.toInstant(ZoneOffset.UTC).getEpochSecond();
    }

    private long getTimestampForDeletion(){
        try {
            LocalDate date = LocalDate.now().plusDays(2); // porshu shokal
            date = date.minusDays(2);

            return date.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();

        }catch (Exception i){
            return 0;
        }

    }

    private String getFormattedTime(){
        try {
            LocalDateTime dateTime = LocalDateTime.now();
            String pattern = "d MMM 'at' hh:mma";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return formatter.format(dateTime);

        }catch (Exception ignored){
            return "not found";
        }
    }


    private String getFormattedDate(){
        try {
            LocalDate date = LocalDate.now();
            String pattern = "dd-MM-yyyy";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return formatter.format(date);
        }catch (Exception ignored){
            return "today";
        }
    }

    private void findProject() throws NoSuchAlgorithmException {

        String[] problems = new String[]{
                "Not possible",
                "BFS","Knapsack", //2
                "DFS","Job Sequencing Problem", // 4
                "Topological Sort", "Sum of subset", // 6
                "Strongly Connected Components","Optimal Binary Search Tree", // 8
                "Kruskal","Travelling Salesman Problem", // 10
                "Prims","P NP, NP - Hard, NP - Complete", //12
                "Dijkstra","Approximation Algorithm", //14
                "Bellman Ford", "Sliding Window Algorithms", //16
                "Floyd - Warshall", "Job - shop Scheduling", //18
                "Johnson’s Algorithm", "Bin Packing", //20
                "Ford - Fulkerson Algorithm", "Multi - stage graph", //22
                "Push - relabel Algorithm" //23
            };


        int m2 = 1907005;
        while(m2 < 1907006) {
            Scanner sc = new Scanner(System.in);

            //System.out.print("Enter roll 1: ");
            int m1 = 1907071;//sc.nextInt();

            //if(m1 == -1) break;

            //System.out.print("Enter roll 2: ");
            //int m2 = sc.nextInt();

            if(m2 == -1) break;

            int sum = m1 + m2;

            //System.out.println("Sum -> " + sum);

            String text = String.valueOf(sum);

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));

            String val = bytesToHex(hash);

            int ans = 0, n = val.length();

            System.out.println("Encrypt -> " + val);

            for (int i = n - 1; i >= n - 4; i--) {
                ans += val.charAt(i) - 48;
            }
            //System.out.println("Last sum -> " + ans);

            int index = ans % 24;
            //System.out.println("Percent ->" + index);

            System.out.println("Problem -> " + m2 +": "+ problems[index]);
            System.out.println(" -- - - -- - - -- - - - -- - ");
            m2++;
        }

    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private void slowParse(){ // not slow here at all

        String lat = "21.42744529759191", longs = "91.9776271671949", title = "Not working";
        //double lat = Double.parseDouble(l);
        //double lon = Double.parseDouble(ln);

        //String abc = Double.parseDouble(l)+";";

        String geoUri = "http://maps.google.com/maps?q=loc:" + lat + "," + longs + " (" +title+ ")";

        //System.out.println(abc);
        System.out.println(lat);
        System.out.println(longs);
        System.out.println(geoUri);

        String[] dates = new String[]{
                "07/12/22",
                "08/12/22",
                "09/12/22",
                "10/12/22",
                "11/12/22",
                "12/12/22",
                "13/12/22"
        };

        long prev = System.currentTimeMillis();

        String pattern = "dd/MM/yy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate today = LocalDate.now();
        for(int i=0;i<7;i++){
            TemporalAccessor ta = formatter.parse(dates[i]);
            LocalDate localDate = today.plusDays(i);
            String ans = formatter.format(localDate);
        }

        long cur = System.currentTimeMillis();
        System.out.println(cur-prev);
    }

    private void curTimeTest(){

        long prevTime = System.currentTimeMillis();

        LocalDateTime dateTime = LocalDateTime.now();
        String pattern = "MMM d 'at' hh:mm a";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        String ans = formatter.format(dateTime);

        long curTime = System.currentTimeMillis();
        System.out.println(curTime-prevTime);
    }

    private void sortCheck(){

        List<Test> list = new ArrayList<>();
        list.add(new Test(4,4));
        list.add(new Test(4,3));
        list.add(new Test(1,2));
        list.add(new Test(2,1));

        list.sort(Comparator.comparingInt(Test::getX));

        for(Test test : list){
            System.out.println(test.getX()+" - "+test.getY());
        }
    }

    private void getDateFromDays(){

        DayOfWeek[] arr = new DayOfWeek[]{
                DayOfWeek.SATURDAY,
                DayOfWeek.SUNDAY,
                DayOfWeek.MONDAY,
                DayOfWeek.TUESDAY,
                DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY,
                DayOfWeek.FRIDAY
        };

        LocalDate today = LocalDate.now();

        String pattern = "EEE\nMMM dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        final String[] ans = new String[7];

        int todayPosition = 0;
        for(int i=0;i<7;i++){
            LocalDate newToday = today.with(TemporalAdjusters.nextOrSame(arr[i]));


            ans[i] = formatter.format(newToday);
            if(newToday.isEqual(today)) todayPosition = i;

            System.out.println(ans[i]);

        }

        System.out.println(todayPosition);

    }



    private void routine(){
        LocalDate today = LocalDate.now();

        String pattern = "dd/MM/yy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        String sToday = formatter.format(today);
        System.out.println("Today is: " + sToday);


        String tmpDate = "06/12/22";
        if(isDateValid(tmpDate,false)){
            System.out.println(tmpDate+" is after "+sToday);
        }
        else{
            System.out.println(tmpDate+" is before "+sToday);
        }

        String[] dates = new String[3];

        today = today.withDayOfMonth(30);

        for(int i=0;i<3;i++){
            dates[i] = formatter.format(today);
            today = today.plusDays(1);
        }
        System.out.println(Arrays.toString(dates));

    }


    public boolean isDateValid(String strDate,boolean shouldReplace){
        if(shouldReplace) strDate = strDate.replace("+","/");

        String pattern = "dd/MM/yy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        try {
            TemporalAccessor ta = formatter.parse(strDate);

            LocalDate date = LocalDate.from(ta);
            LocalDate today = LocalDate.now();

            // date must be after today or today i.e.
            return !(date.isBefore(today));

        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    private void testDate(){
        LocalDate today = LocalDate.now();

        String pattern = "ddMMM yy";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);

        String val = fmt.format(today);
        System.out.println(today.toString());
        System.out.println(val);

        String pattern2 = "MMM dd";
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern(pattern2);

        String val2 = fmt2.format(today);
        System.out.println(val2);


        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        String ans = formatter.format(today);
        System.out.println(ans);

    }

}
