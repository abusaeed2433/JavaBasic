import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;


public class CP {

    public static void main(String[] args) throws IOException {
        StringBuilder output = new StringBuilder();
//        Scanner sc = new Scanner(System.in);
        Reader sc = new Reader();
        int t = sc.nextInt();

        main:
        while (t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n+1];
            int[] brr = new int[n+1];

            for(int i=1; i<=n; i++) arr[i] = sc.nextInt();
            boolean allSame = true;
            for(int i=1; i<=n; i++) {
                brr[i] = sc.nextInt();
                if(arr[i] != brr[i]) allSame = false;
            }

            int m = sc.nextInt();
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=1; i<=m; i++) {
                int tmp = sc.nextInt();
                map.put(tmp,map.getOrDefault(tmp,0)+1);
            }

            Stack<Integer> stack = new Stack<>();
            Map<Integer,Integer> mapStack = new HashMap<>();
            for(int i=n; i>0; i--){

                //if(arr[i] == brr[i]) continue;

                if(arr[i] < brr[i]){
                    output.append("NO").append('\n');
                    continue main;
                }

                while (!stack.isEmpty() && stack.peek() < brr[i]){
                    mapStack.remove(stack.pop());
                }

                if(arr[i] != brr[i] && !mapStack.containsKey(brr[i])){
                    if(map.getOrDefault(brr[i],0) <= 0){
                        output.append("NO\n");
                        continue main;
                    }
                    map.put(brr[i],map.get(brr[i])-1);
                    stack.push(brr[i]);
                    mapStack.put(brr[i],1);
                }
            }

            output.append("YES").append('\n');
        }

        System.out.println(output);
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
