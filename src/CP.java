import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CP {

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(4);

        List<String> strings = new ArrayList<>();
        strings.add("legal");
        strings.add("legal");
        strings.add("illegal");
        strings.add("legal");
        strings.add("legal");

        // 0 3 2 3 4
        // l l i l l

        System.out.println( maxCost(list,strings,1));
    }

    public static int maxCost(List<Integer> cost, List<String> labels, int dailyCount) {
        // Write your code here
        int ans = 0;
        long cur = 0;
        int count = 0;
        for(int i=0; i<cost.size();i++){

            cur += cost.get(i);
            if( labels.get(i).equals("illegal") ) continue;

            count++;
            if(count == dailyCount){
                ans =(int) Math.max(ans,cur);
                count = 0;
                cur = 0;
            }

        }
        return ans;

    }

    public static void typeCounter(String sentence) {

        String regex = "\\b[a-z]+\\b";
        long sc = getCount(sentence,regex);

        regex = "\\b[0-9^\\.^a-z]+\\b";
        long ic = getCount(sentence,regex);


        regex = "\\b[0-9]*\\.[0-9]+\\b";
        long dc = getCount(sentence,regex);

        System.out.println("string "+sc+"\n"+"integer "+ic+"\n"+"double "+dc);


    }

    private static long getCount(String inp,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inp);

        long count = 0;
        while (matcher.find()) count++;

        return count;
    }

    static String isBalanced(String s)
    {
        LinkedList<Character> list = new LinkedList<>();
        for(int i=0;i<s.length(); i++){
            char ch = s.charAt(i);
            if( ch == '(' || ch == '{'){
                list.add(0,ch);
            }
            else{
                if(list.isEmpty()) return "false";

                if( (ch == '}' && list.get(0) == '{') || (ch == ')' && list.get(0) == '(')) list.remove(0);
                else{
                    return "false";
                }
            }
        }
        return String.valueOf(list.isEmpty());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            String key = getKey(s);
            map.computeIfAbsent(key, ss -> new ArrayList<>()).add(s);
        }

        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String,List<String>> entry : map.entrySet()) {
            if(entry.getValue() != null) ans.add(entry.getValue());
        }
        return ans;
    }

    private String getKey(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        return Arrays.toString(arr);
    }


    private static void print(String str){
        PrintWriter writer = new PrintWriter(System.out,true);
        writer.print(str);
        writer.close();
    }

    private static long f(int x){
        long num = 1;

        while (num < x) num *= 2;

        return num;
    }

    static class Pair{
        public int x = -1;
        public int y = 0;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void print(){
            System.out.println(x+" "+y);
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine(int... lens) throws IOException
        {
            byte[] buf = new byte[lens.length >= 1 ? lens[0] : 64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
