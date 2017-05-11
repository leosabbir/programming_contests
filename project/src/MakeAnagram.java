import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;


public class MakeAnagram {
   
   public static void main(String[] args) {
      Input in = new Input();
      
      String first = in.next();
      String second = in.next();
      
      int[] count = new int[26];
      
      for(int i = 0; i < first.length(); i++) {
         int index = first.charAt(i) - 97;
         count[index]++;
      }
      
      for(int i = 0; i < second.length(); i++) {
         int index = second.charAt(i) - 97;
         count[index]--;
      }
      
      int totalCount = 0;
      for(int i = 0; i < 26; i++) {
         totalCount += Math.abs(count[i]);
      }
      
      System.out.print(totalCount);
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
