package scjp.com.java.algorithm.old.companies.makemytrip;


import java.io.*;
import java.util.*;

 class ConnectedHorses {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static int pos;

    public static void main(String[] args) throws IOException {
        final int t = readLineInt();

        int[] board = new int[1000 * 1000 + 1];
        for (int i = 1; i <= t; i++) {
            String values = readLine();
            final int n = readNextInt(values);
            final int m = readNextInt(values);
            final int q = readNextInt(values);

            ArrayList<Integer> horsePositions = new ArrayList<>(q + 1);
            for (int j = 0; j < q; j++) {
                values = readLine();
                int row = readNextInt(values);
                int col = readNextInt(values);
                int pos = m * (row - 1) + col;
                board[pos] = i;
                horsePositions.add(pos);
            }

            UnionFind uf = new UnionFind(n, m);

            for (int pos : horsePositions) {
                uf.makeParent(pos);
                int[] positions = getPositions(pos, n, m);
                for (int p : positions) {
                    if (isValidPos(p, n, m) && board[p] == i) {
                        uf.makeParent(p);
                        uf.union(pos, p);
                    }
                }
            }

            long answer = 1;
            final long MOD = 1000000007;
            int[] counts = uf.getComponentsWithCounts();
            for (int count :
                    counts) {
                while (count > 1) {
                    answer = (answer * (long) count) % MOD;
                    count--;
                }
            }
            out.println(answer);
        }

        out.flush();
        out.close();
    }

    static int[] getPositions(int pos, int n, int m) {
        int row = pos / m + 1;
        int col = pos % m;
        if(col == 0) {
            col = m;
        }

        boolean validLeft1 = col - 1 >= 1;
        boolean validRight1 = col + 1 <= m;
        boolean validUp1 = row - 1 >= 1;
        boolean validDown1 = row + 1 <= m;
        boolean validLeft2 = col - 2 >= 1;
        boolean validRight2 = col + 2 <= m;
        boolean validUp2 = row - 2 >= 1;
        boolean validDown2 = row + 2 <= m;
        return new int[]{
                validUp2 && validLeft1 ? pos - 2 * m - 1 : -1,
                validUp2 && validRight1 ? pos - 2 * m + 1 : -1,
                validLeft2 && validUp1 ? pos - 2 - m : -1,
                validLeft2 && validDown1 ? pos - 2 + m : -1,
                validRight2 && validUp1 ? pos + 2 - m : -1,
                validRight2 && validDown1 ? pos + 2 + m : -1,
                validDown2 && validLeft1 ? pos + 2 * m - 1 : -1,
                validDown2 && validRight1 ? pos + 2 * m + 1 : -1,
        };
    }

    static boolean isValidPos(int pos, int n, int m) {
        return (pos > 0 && pos <= n * m);
    }

    static class UnionFind {
        int[] parent;

        UnionFind(int n, int m) {
            parent = new int[n * m + 1];
        }

        public void makeParent(int n) {
            if (isValid(n) && parent[n] == 0) {
                parent[n] = n;
            }
        }

        private boolean isValid(int n) {
            return n > 0 && n < parent.length;
        }

        public int findRoot(int n) {
            if (isValid(n)) {
                while (n != parent[n]) {
                    parent[n] = parent[parent[n]];
                    n = parent[n];
                }
                return n;
            }
            return 0;
        }

        public void union(int n, int m) {
            if (isValid(n) && isValid(m)) {
                int a = findRoot(n);
                parent[a] = findRoot(m);
            }
        }

        public int getComponentCount() {
            int components = 0;
            for (int i = 1; i < parent.length; i++) {
                if (parent[i] == i) {
                    components++;
                }
            }
            return components;
        }

        private int[] getComponentsWithCounts() {
            int[] counts = new int[getComponentCount()];
            int[] components = new int[parent.length];
            int component = 0;
            for (int i = 1; i < parent.length; i++) {
                if (parent[i] == i) {
                    components[i] = component++;
                }
            }
            for (int i = 1; i < parent.length; i++) {
                if (parent[i] != 0) {
                    counts[components[findRoot(i)]]++;
                }
            }
            return counts;
        }
    }

    private static String readLine() throws IOException {
        return br.readLine().trim();
    }

    private static int readLineInt() throws IOException {
        return Integer.parseInt(readLine());
    }

    private static String readNextString(String input) {
        int end;
        String value;
        if ((end = input.indexOf(' ', pos)) >= 0) {
            value = input.substring(pos, end);
            pos = end + 1;
        } else {
            value = input.substring(pos);
            pos = 0;
        }
        return value;
    }

    private static int readNextInt(String input) {
        return Integer.parseInt(readNextString(input));
    }

    private static long readNextLong(String input) {
        return Long.parseLong(readNextString(input));
    }
}
