import java.util.*;

public class ParenGenerator {

  public static void main(String[] args) {
    List<String> results = run(Integer.parseInt(args[0]));

    for (String result : results) {
      System.out.println(result);
    }
  }

  public static List<String> run(int count) {
    char[] s = new char[count + count];
    List<String> results = new ArrayList<String>();

    generate(results, count, count, 0, s);
    return results;
  }

  public static void generate(List<String> results, int left, int right, int index, char[] s) {
    if (left < 0 || right < left) {
      System.out.println("error: " + left + " " + right);
      return; // error. Invalid state
    }

    if (left == 0 && right == 0) {
      System.out.println("inserting: " + String.valueOf(s) + " " + index);
      results.add(String.valueOf(s));
      return;
    } else {
      if (left > 0) {
        System.out.println("left");
        s[index] = '(';
        generate(results, left-1, right, index+1, s);
      }

      if (right > 0) {
        System.out.println("right");
        s[index] = ')';
        generate(results, left, right-1, index+1, s);
      }
    }
  }
}
