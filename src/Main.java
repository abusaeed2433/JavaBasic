import java.io.*;
import java.util.*;

public class Main {
    public static final int MOD = 1_000_000_007;
    public static final int INF = Integer.MAX_VALUE;

    static InputReader scanner;
//    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new InputReader(System.in);
        //scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);

        int t = 1;//scanner.nextInt();
        for(int i=1; i<=t; i++){
            solve(t);
        }

        out.close();
    }


    private static void solve(int caseNo) {
        final String str = "abcabcabc";//"aabbbbcccbbaa";
        final int k = 3;

        final Stack<Pair> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if(stack.isEmpty()){
                stack.push( new Pair(str.charAt(i),1) );
            }
            else {
                final Pair top = stack.peek();
                if(top.first == str.charAt(i)){
                    top.second++;
                }
                else{
                    stack.push(new Pair(str.charAt(i),1));
                }
            }

            final Pair top = stack.peek();
            if(top.second == k){
                stack.pop();
            }
        }

        final StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()){
            final Pair top = stack.pop();
            builder.append(String.valueOf(top.first).repeat(top.second));
        }

        System.out.println(builder.reverse().toString());

    }


    private static int[] take(int n){
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    static class Pair implements Comparable<Pair> {
        char first;
        int second;

        public Pair(char first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;

            if(obj == null || getClass() != obj.getClass()) return false;

            Pair pair = (Pair) obj;
            return first == pair.first && second == pair.second;
        }

        @Override
        public String toString() {
            return first+" "+second;
        }

        @Override
        public int compareTo(Pair o) {
            if(first == o.first) return Integer.compare(second, o.second);
            return Integer.compare(first, o.first);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong(){ return Long.parseLong(next()); }
        public double nextDouble(){ return Double.parseDouble(next()); }
    }
}
