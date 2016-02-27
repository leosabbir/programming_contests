import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;



public class StdReader {

    public static void main(String[] args) {
        Input in = new Input();
        
        System.out.println(in.next());
        System.out.println(in.nextLine());
    }

    static class Input {
        BufferedReader in;
        StringBuilder sb = new StringBuilder();

        public Input() {
            this.in = new BufferedReader(new InputStreamReader(System.in));
        }

        public Input(String s) {
            this.in = new BufferedReader(new StringReader(s));
        }

        //reads a single word
        public String next() {
            sb.setLength(0);
            while (true) {
                int c = -1;
                try {
                   c = in.read();
                } catch(IOException e) {
                   e.printStackTrace();
                   return null;
                }
                if (c == -1) {
                    return null;
                }
                if (" \n\r\t".indexOf(c) == -1) {
                    sb.append((char)c);
                    break;
                }
            }
            while (true) {
                int c = -1;
                try {
                   c = in.read();
                } catch (IOException e) {
                   e.printStackTrace();
                   return null;
                }
                if (c == -1 || " \n\r\t".indexOf(c) != -1) {
                    break;
                }
                sb.append((char)c);
            }
            return sb.toString();
        }

        // read line
        public String nextLine() {
            sb.setLength(0);
            while (true) {
               int c = -1;
               try {
                  c = in.read();
               } catch(IOException e) {
                  e.printStackTrace();
                  return null;
               }
                if (c == -1) {
                    return null;
                }
                if ("\n\r".indexOf(c) == -1) {
                    sb.append((char)c);
                    break;
                }
            }
            while (true) {
               int c = -1;
               try {
                  c = in.read();
               } catch (IOException e) {
                  e.printStackTrace();
                  return null;
               }
                if (c == -1 || "\n\r".indexOf(c) != -1) {
                    break;
                }
                sb.append((char)c);
            }
            return sb.toString();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
