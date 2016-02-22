import java.io.*;
import java.util.HashSet;

public class HR_scalar_products {

    public static void solve(Input in, PrintWriter out) throws IOException {
        long c = in.nextInt();
        long m = in.nextInt();
        int n = in.nextInt();
        c = c * c % m;
        long u = 8 * c % m, v = 13 * c % m;
        HashSet<Long> set = new HashSet<>();
        // [3..2*n-1]
        for (int i = 0; i < 2 * n - 3; ++i) {
            set.add(v);
            long u1 = (u + v) % m, v1 = (u1 + v) % m;
            u = u1;
            v = v1;
        }
//        System.err.println(set);
        out.println(set.size());
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        solve(new Input(new BufferedReader(new InputStreamReader(System.in))), out);
        out.close();
    }

    static class Input {
        BufferedReader in;
        StringBuilder sb = new StringBuilder();

        public Input(BufferedReader in) {
            this.in = in;
        }

        public Input(String s) {
            this.in = new BufferedReader(new StringReader(s));
        }

        public String next() throws IOException {
            sb.setLength(0);
            while (true) {
                int c = in.read();
                if (c == -1) {
                    return null;
                }
                if (" \n\r\t".indexOf(c) == -1) {
                    sb.append((char)c);
                    break;
                }
            }
            while (true) {
                int c = in.read();
                if (c == -1 || " \n\r\t".indexOf(c) != -1) {
                    break;
                }
                sb.append((char)c);
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
