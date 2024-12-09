import java.math.BigInteger;
import java.util.*;

public class CPOthers {

    private static final int MOD = 1_000_000_007;




    // Segment tree
    private static void testSegmentTree(){
        final int n = 7;

        long[] arr = {0,4,-9,3,7,1,0,2}; // 8 elements, 1 indexed = 7 elements

        final SegmentTree segmentTree = new SegmentTree(n, arr, SegmentTree.UpdateType.REPLACE);

//        out.println( segmentTree.sumQuery(1,7) );
//        segmentTree.update(1,7,0);
//        out.println( segmentTree.sumQuery(1,7) );
    }

    static private class SegmentTree {
        // must be one base indexing
        private final int n;
        private final Node[] tree;
        private final UpdateType updateType;

        public SegmentTree(int n, long[] arr, UpdateType updateType) {
            this.n = n;
            this.updateType = updateType;

            this.tree = new Node[4 * n];
            for(int i=0; i<4*n; i++){
                this.tree[i] = new Node(0,-1);
            }
            build(arr,1, 1, n);
        }

        private void build(long[] arr, int node, int left, int right) {
            if (left == right) { // leaf
                tree[node].value = arr[left];
                return;
            }

            int mid = (left + right) / 2;
            build(arr,2 * node, left, mid);
            build(arr,2 * node + 1, mid + 1, right);
            // sum of left and right child
            tree[node].value = tree[2 * node].value + tree[2 * node + 1].value;
        }

        // Find ranged sum <−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−
        public long sumQuery(int left, int right) {
            return sumQuery(1, 1, n, left, right);
        }

        private long sumQuery(int node, int treeLeft, int treeRight, int arrLeft, int arrRight) {
            if( tree[node].lazy != -1 ){
                if(treeLeft != treeRight) {
                    tree[2*node].lazy = tree[2*node+1].lazy = tree[node].lazy;
                }

                long newVal = (treeRight - treeLeft + 1) * tree[node].lazy;
                tree[node].set( newVal, -1 );
            }

            // Range become invalid
            if(arrLeft > treeRight || arrRight < treeLeft) {
                return 0; // sum query
            }

            // Current node range fully contains the arr range
            if (treeLeft >= arrLeft  && treeRight <= arrRight) {
                return tree[node].value;
            }

            // Other-wise splitting into two parts
            int treeMid = (treeLeft + treeRight) / 2;
            return sumQuery(node*2, treeLeft, treeMid, arrLeft, arrRight) +
                    sumQuery(node*2+1,treeMid+1, treeRight, arrLeft, arrRight);
        }

        public void update(int left, int right, int value) { // index must be one-based
            update(1, 1, n, left, right, value);
        }
        private void update(int node, int treeLeft, int treeRight, int arrLeft, int arrRight, int value) {

            if( tree[node].lazy != -1 ){
                if(treeLeft != treeRight) { // propagate
                    tree[2*node].lazy = tree[2*node+1].lazy = tree[node].lazy;
                }

                long newVal = (treeRight - treeLeft + 1) * tree[node].lazy;
                tree[node].set( newVal, -1 ); // update value and reset lazy
            }

            if(arrLeft > arrRight || arrLeft > treeRight || arrRight < treeLeft) return;

            // Current node range fall within the array range. Ex: node range: 2 to 4, array range, 1 to 7
            // So we will update the lazy here and return
            if(treeLeft >= arrLeft && treeRight <= arrRight){
                tree[node].value = (treeRight-treeLeft+1L) * value;

                if(treeLeft != treeRight) {
                    tree[2*node].lazy = tree[2*node+1].lazy = value;
                }
                tree[node].lazy = -1;
                return;
            }


            final int treeMid = (treeLeft + treeRight) / 2;

            update(2*node, treeLeft, treeMid, arrLeft, arrRight, value);
            update(2*node+1, treeMid + 1, treeRight, arrLeft, arrRight, value);
            // Remember this is sum query
            tree[node].value = tree[2 * node].value + tree[2*node+1].value;
        }

        private static class Node{
            private long value, lazy;

            public Node(long value, long lazy) {
                this.value = value;
                this.lazy = lazy;
            }

            void set(long nodeValue, long lazyValue){
                this.value = nodeValue;
                this.lazy = lazyValue;
            }

            @Override
            public String toString() {
                return value +", "+ lazy;
            }
        }
        public enum UpdateType{ ADD, REPLACE }
    }

    // Segment tree above

    // Segment tree above

    // Binomial coefficient
    static final int MAX = 2_000_00;
    static long[] fact;
    static long[] inv;

    static {
        fact = calcFact(MAX);
        inv = calcInverses(MAX, fact);
    }


    private static long[] calcFact(int MAX){
        final long[] fact = new long[MAX + 1];

        fact[0] = 1L;
        for(int i=1; i<=MAX; i++){
            fact[i] = (fact[i-1] * i) % MOD;
        }
        return fact;
    }

    /**
     * @return base ^ power
     */
    private static long exp(long base, int power) {
        long result = 1L;
        while (power > 0) {
            if ((power & 1) == 1) { // odd = (n%2 == 1)
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            power >>= 1; // n / =2
        }
        return result;
    }

    /**
     * Precomputes all modular inverse factorials
     * from 0 to MAX in O(n + log p) time
     */
    private static long[] calcInverses(int MAX, long[] fac) {
        long[] inv = new long[MAX+1];

        inv[MAX] = exp(fac[MAX], MOD-2);
        for (int i = MAX; i >= 1; i--) {
            inv[i - 1] = inv[i] * i % MOD;
        }

        return inv;
    }

    private static long nCk(int n, int k) {
        if(n < k) return 0L;

        return ( ((fact[n] * inv[k]) % MOD ) *  inv[n - k]) % MOD;
    }

    // Binomial coefficient above


    // DSU
    private static void test(){
        final int n = 8;
        List< List<Integer> > adjList = new ArrayList<>();
        for(int i=0; i<n; i++){ adjList.add( new ArrayList<>() ); }

        adjList.get(1).add(7); adjList.get(7).add(1);
        adjList.get(1).add(3); adjList.get(3).add(1);
        adjList.get(3).add(7); adjList.get(7).add(3);

        adjList.get(2).add(6); adjList.get(6).add(2);

        adjList.get(4).add(5); adjList.get(5).add(4);

        final UFDS ufds = createDS(n, adjList);

//        out.println(ufds.getNoOfSets()); // 4
//        out.println(ufds.getSizeOfSet(0)); // 1
//        out.println(ufds.getSizeOfSet(1)); // 3
//        out.println(ufds.getSizeOfSet(2)); // 2
//        out.println(ufds.getSizeOfSet(4)); // 2
    }

    private static UFDS createDS(int n, List<List<Integer>> adjList){
        final UFDS ufds = new UnionFind(n);

        for(int u=0; u<n; u++){
            if(adjList.get(u).isEmpty()) continue;

            for(int v : adjList.get(u)) {
                ufds.unionSet(u, v);
            }
        }

        return ufds;
    }

    interface UFDS {
        // create a disjoint set
        void makeSet(int v);

        // return the id of the representative node
        int findSet(int v);

        // returns if both nodes are in same set or not
        boolean isInSameSet(int u, int v);

        // merge two sets
        void unionSet(int u, int v);

        // returns the number of sets
        int getNoOfSets();

        // returns the size of the set containing u
        int getSizeOfSet(int u);
    }

    static class UnionFind implements UFDS{
        private int noOfSet;

        // store the immediate parent
        private final int[] parents;

        // used for keeping the tree/set height short. ranks can also be used.
        // but sizes gives extra info like no of nodes in a set
        private final int[] sizes;

        public UnionFind(int n) {
            this.parents = new int[n];
            this.sizes = new int[n];
            this.noOfSet = n;

            // Initialize n disjoint set
            for(int i=0; i<n; i++) makeSet(i);

            // Set size to all set to 1
            Arrays.fill(this.sizes, 1);
        }

        @Override
        public void makeSet(int v) {
            parents[v] = v;
        }

        @Override
        public int findSet(int v) {
            if(parents[v] == v) return v;

            // setting it just to avoid unnecessary look-up later
            return parents[v] = findSet(parents[v]);
        }

        @Override
        public boolean isInSameSet(int u, int v) {
            return findSet(u) == findSet(v);
        }

        @Override
        public void unionSet(int u, int v) {
            if(isInSameSet(u,v)) return;

            final int rootOne = findSet(u);
            final int rootTwo = findSet(v);

            this.noOfSet--;

            if(sizes[rootOne] > sizes[rootTwo]){ // first set is large
                parents[rootTwo] = rootOne;
                sizes[rootOne] += sizes[rootTwo];
            }
            else{
                parents[rootOne] = rootTwo;

                sizes[rootTwo] += sizes[rootOne];
            }
        }

        @Override
        public int getNoOfSets() {
            return noOfSet;
        }

        @Override
        public int getSizeOfSet(int u) {
            int root = findSet(u);
            return sizes[root];
        }
    }
    // DSU above

    // XOR Basis generator from int[]

    /**
     *
     * @param arr initial set for which we have to find basis
     * @param vecLength length of an item in the list. i.e. length of bitmask
     * @return basis
     */
    private static List<Integer> createBasis(final int[] arr, final int vecLength){
        final Integer[] basis = new Integer[vecLength];

        for(int num : arr){
            updateBasis(basis,vecLength,num);
        }

        final List<Integer> basisList = new ArrayList<>();
        for(Integer item : basis){
            if(item == null) continue;
            basisList.add(item);
        }
        return basisList;
    }

    /**
     *
     * @param basisList current basis list
     * @param d size of a vector or bitmask
     * @param curMask to add if needed
     */
    private static void updateBasis(Integer[] basisList, int d, int curMask){
        for(int i=0; i<d; i++){
            if( (curMask & (1 << i)) == 0) continue;

            if(basisList[i] == null){ // add the modified basis since no lower basis to match
                basisList[i] = curMask;
                return;
            }

            curMask ^= basisList[i]; // subtract from current basis
        }
        // no need to add since already added inside loop or can be represented by current basis(curMask has become = 0)
    }
    // XOR Basis generator from int[] above

//    private static List<Integer> getLongestPath(int n, final Map<Integer,List<Integer>> adj, int st){
//
//        final Map<Integer, Main.Pair<Integer,Integer>> parMap = new HashMap<>();
//        final boolean[] visited =  new boolean[n];
//
//        final Stack<Integer> stack = new Stack<>();
//
//        stack.push(st);
//
//        parMap.put(st, new Main.Pair<>(-1,0));
//        visited[st] = true;
//
//        Main.Pair<Integer,Integer> lastNode = new Main.Pair<>(0,0);
//
//        while (!stack.isEmpty()){
//            int top = stack.pop();
//
//            for(Integer v2 : adj.get(top)){
//                if(visited[v2]) continue;
//                visited[v2] = true;
//                stack.push(v2);
//
//                int dist = parMap.get(top).second+1;
//
//                if(dist > lastNode.second){
//                    lastNode.setBoth(v2,dist);
//                }
//
//                parMap.put(v2, new Main.Pair<>(top ,dist));
//            }
//        }
//
//        final List<Integer> list = new ArrayList<>();
//
//        int last = lastNode.first;
//        while (last != -1){
//            list.add(last);
//            last = parMap.get(last).first;
//        }
//        return list;
//    }

    // Mod inverse
    private static BigInteger modInverse(BigInteger a, BigInteger m) {
        BigInteger[] result = extendedGcd(a, m);
        BigInteger x = result[1];

        return x.mod(m);
    }

    // copied function
    private static BigInteger[] extendedGcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return new BigInteger[]{a, BigInteger.ONE, BigInteger.ZERO};
        }
        BigInteger[] values = extendedGcd(b, a.mod(b));
        BigInteger gcd = values[0];
        BigInteger x = values[2];
        BigInteger y = values[1].subtract(a.divide(b).multiply(values[2]));
        return new BigInteger[]{gcd, x, y};
    }

    private static long expMod(long base, long num) {
        long result = 1L;

        BigInteger exp = BigInteger.valueOf(num);

        while (exp.compareTo(BigInteger.ZERO) > 0) {

            if (exp.mod(BigInteger.TWO).equals(BigInteger.ONE)) result = (result * base) % MOD;

            base = (base * base) % MOD;
            exp = exp.shiftRight(1);
        }

        return result;
    }


    private static List<Integer> getPrimeFactors(int n) {

        final List<Integer> list = new ArrayList<>();

        while (n % 2 == 0) {
            list.add(2);
            n /= 2;
        }

        int mx = (int)Math.sqrt(n);
        for (int i = 3; i <= n; i+= 2) {
            while (n % i == 0) {
                list.add(i);
                n /= i;
            }
        }

        if (n > 2)
            list.add(n);
        return list;
    }

    private static boolean isSumPossible(int sum, int n, int[] arr){
        final boolean[][] dp = new boolean[sum+1][n+1];

        for(int j=0; j<n+1; j++) dp[0][j] = true;
        for(int i=1; i<sum+1; i++) dp[i][0] = false;

        for(int i=1; i<=sum; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = dp[i][j-1];

                if(i < arr[j-1]) continue;

                int prevIndex = i - arr[j-1];
                dp[i][j] = dp[i][j-1] | dp[prevIndex][j-1];
            }
        }

        return dp[sum][n];
    }

    private static long lcm(long a, long b) {
        long gcd = gcd(a,b);

        if( a > b) return a / gcd * b;

        return b / gcd * a;
    }

    private static long gcd(long a, long b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    private static boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }


    /**
     *
     * @param list sorted list
     * @param left the element to find
     * @return the index of the first element greater than left or n+1 if not found
     */
    private static int upperBound(List<Integer> list, int left) {
        int mid, n = list.size();
        int low = 0, high = n;

        while (low < high) {
            mid = low + (high - low) / 2;
            if (left >= list.get(mid)) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        if (low == n ) {
            return n + 1; // not found
        }

        return low;
    }

    /**
     *
     * @param list sorted list
     * @param key the element to find
     * @return the index of the first element greater than or equal to key.
     * 1 2 3 4 5 6
     * for key = 3, it will return 2
     */
    private static int lowerBound(List<Integer> list, int key) {
        int low = 0, high = list.size();
        int mid;

        while (low < high) {

            mid = low + (high - low) / 2;

            if (key <= list.get(mid) ) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        if (low < list.size() && list.get(low) < key) {
            low++;
        }

        return low;
    }

    // <======================================================================================================>

    static class Pair{
        public int first;
        public int second;
        private final int hashCode;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
            this.hashCode = Objects.hash(first,second);
        }

        @Override
        public int hashCode() {
            return hashCode;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;

            if(obj == null || obj.getClass() != this.getClass()) return false;

            Pair pair = (Pair) obj;
            return pair.first == first && pair.second == this.second;
        }
    }

    static class Thair extends Pair {
        public int third;
        private final int hashCode;

        public Thair(int first, int second, int third) {
            super(first, second);
            this.third = third;
            this.hashCode = Objects.hash(first,second,third);
        }

        @Override
        public int hashCode() {
            return hashCode;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;

            if(obj == null || obj.getClass() != this.getClass()) return false;

            Thair thair = (Thair)obj;

            return thair.first == this.first && thair.second == this.second && thair.third == this.third;
        }
    }


    private static class StringHash {
        private static final long P = 239017L;
        private static final long MOD_X = 1000000007L;
        private static final long MOD_Y = 1000000009L;

        private static class HashPair {
            long x, y;

            HashPair(long x, long y) {
                this.x = x;
                this.y = y;
            }

            long subtractAndMultiply(HashPair p1, HashPair p2) {
                long x = (p1.x * p2.x) % MOD_X;
                long y = (p1.y * p2.y) % MOD_Y;

                x = (this.x - x + MOD_X) % MOD_X;
                y = (this.y - y + MOD_Y) % MOD_Y;

                long hash = 17L;
                hash = 31 * hash + (int)(x ^ (x >>> 32L));
                hash = 31 * hash + (int)(y ^ (y >>> 32L));
                return hash;
            }

            HashPair multiply() {
                return new HashPair((this.x * StringHash.P) % MOD_X, (this.y * StringHash.P) % MOD_Y);
            }

            HashPair multiplyAndAdd(long charValue) {
                return new HashPair(
                        (this.x * StringHash.P + charValue) % MOD_X,
                        (this.y * StringHash.P +charValue) % MOD_Y
                );
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;

                if (obj == null || getClass() != obj.getClass()) return false;

                return this.isEqual((HashPair) obj);
            }

            boolean isEqual(HashPair other) {
                return this.x == other.x && this.y == other.y;
            }

            @Override
            public int hashCode() {
                int hash = 17;
                hash = 31 * hash + (int)(x ^ (x >>> 32));
                hash = 31 * hash + (int)(y ^ (y >>> 32));
                return hash;
            }
        }

        private HashPair[] p, h;

        public void init(String s) {
            int n = s.length();
            p = new HashPair[n+1];
            h = new HashPair[n+1];

            p[0] = new HashPair(1, 1);
            h[0] = new HashPair(0, 0);

            for (int i = 0; i < n; i++) {
                int charValue = s.charAt(i);
                h[i + 1] = h[i].multiplyAndAdd(charValue);
                p[i + 1] = p[i].multiply();
            }
        }

        public long get(int l, int r) {
            return h[r].subtractAndMultiply(p[r - l],h[l]);
        }
    }

//    static class Thair<F, S, T> extends Main.Pair<F,S> {
//        public T third;
//        private final int hashCode;
//
//        public Thair(F first, S second, T third) {
//            super(first, second);
//            this.third = third;
//            this.hashCode = Objects.hash(first,second,third);
//        }
//        public void setToth(F first, S second, T third){
//            setBoth(first,second);
//            this.third = third;
//        }
//
//        @Override
//        public int hashCode() {
//            return hashCode;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if(this == obj) return true;
//
//            if(obj == null || obj.getClass() != this.getClass()) return false;
//
//            Thair<?,?,?> thair = (Thair<?,?,?>)obj;
//
//            return Objects.equals(thair.first, this.first) && Objects.equals(thair.second, this.second) && Objects.equals(thair.third, this.third);
//        }
//    }

}
