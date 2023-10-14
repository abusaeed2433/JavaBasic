import jdk.jshell.EvalException;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CP {

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1); pq.add(2); pq.add(454); pq.add(-1);

        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }
        call();

//        Map<String, String> map = new HashMap<>();
//        map.computeIfAbsent("key", new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return "aas";
//            }
//        });
//
//        Map<String, List<String>> map1 = new HashMap<>();
//        map1.computeIfAbsent("a", s -> null);
//        map1.computeIfAbsent("a", arr -> new ArrayList<>()).add("a");

    }

    private static void call(){
        try{
            System.out.println("try");
            int y = 10/0;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }
        finally {
            System.out.println("finally");
        }
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
