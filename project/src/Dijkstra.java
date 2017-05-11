import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Comparator;
import java.util.PriorityQueue;



public class Dijkstra {


  public static void main(String[] args) {
    Input in = new Input();

    int T = in.nextInt();
    do {
      solve(in);
    } while (--T > 0);
  }

  public static void solve(Input in) {
    int N = in.nextInt();
    int M = in.nextInt();

    int[][] adjMat = new int[N][N];

    int i = M;
    do {
        int x = in.nextInt();
        int y = in.nextInt();
        int r = in.nextInt();

        adjMat[x-1][y-1] = r;
        adjMat[y-1][x-1] = r;
        // if (outNgbrs.contains(x-1)) {
        //   List<Integer> list = new ArrayList<Integer>();
        //   list.add(y-1);
        //   outNgbrs.put(x-1, list);
        // } else {
        //   outNgbrs.get(x-1).add(y-1);
        // }
        //
        // if (outNgbrs.contains(y-1)) {
        //   List<Integer> list = new ArrayList<Integer>();
        //   list.add(x-1);
        //   outNgbrs.put(y-1, list);
        // } else {
        //   outNgbrs.get(y-1).add(x-1);
        // }

    } while (--i > 0);

    Comparator<Vertex> comaparator = new Comparator<Vertex>() {
      @Override
      public int compare(Vertex x, Vertex y)
      {
          if (x.d < y.d)
          {
              return -1;
          }
          if (x.d > y.d)
          {
              return 1;
          }
          return 0;
      }
    };
    

    PriorityQueue<Vertex> heap = new PriorityQueue<Vertex>(N, comaparator);

    heap.add(new Vertex());
    while(!heap.isEmpty()) {
    	Vertex min = heap.remove();
    	
    	
    }
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

class Vertex {
  int vertex;
  int d;
  int parent;
}
