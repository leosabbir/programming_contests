import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
* http://initcodes.blogspot.com/2018/04/number-pairs-whose-sum-is-multiple-of.html
*
* Kelly gives Ashley N chocolates each having a price pi, (where pi is the price of ith chocolate),
* and an integer X. She asks her to group the N chocolates in to pairs such that sum of prices of 
* chocolates in each pair is a multiple of X.
* 
* Output yes if its possible to group the chocolates in to pairs and No if its not possible.
*/
public class PairNumberByMultipleOfX {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T > 0) {
            int X = sc.nextInt();
            int N = sc.nextInt();
            int[] p = new int[N];
            
            for (int i = 0; i < N; i++) {
                p[i] = sc.nextInt();
            }
            
            //bruteForce(N, X, p);
            //efficient(N, X, p);
            efficient2(N, X, p);
            
            T--;
        }
    }

    //-------------------------------------------------------------------------------
    
    /**
   * Linear Time solution to determine if all the numberes pairs up
   * O(n^2) solution
   * @param N number of elements in the array
   * @param X
   * @param p array of inputs 
   * @return max profit
   */
    public static void bruteForce(int N, int X, int[] p) {
        int[] paired = new int[N];
            boolean pairFound = false;
            
            if (N % 2 == 0) {
                for(int i = 0; i < N; i++) {
                    if (paired[i] == 1) {
                        continue;
                    }
                    pairFound = false;
                    for(int j = i+1; j < N; j++) {
                        if (i == j || paired[j] == 1) {
                            continue;
                        }
                        int sum = p[i] + p[j];
                        if (sum % X == 0) {
                            pairFound = true;
                            paired[i] = 1;
                            paired[j] = 1;
                            break;
                        }
                    }
                    if (!pairFound) {
                        break;
                    }
                }
            } 
            if (pairFound) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
    }

    //--------------------------------------------------------------------------------
    
   /**
   * Linear Time solution to determine if all the numberes pairs up
   * O(n) solution
   * @param N number of elements in the array
   * @param X
   * @param p array of inputs 
   * @return max profit
   */
    public static void efficient(int N, int X, int[] p) {
        int[] counts = new int[X]; // max value of X is 2000
        
        boolean unmatchFound = true;
        
        if (N % 2 == 0) { // no pairing for odd inputs
            for (int i = 0; i < N; i++) { // O(n)
                int idx = p[i] % X;
                counts[idx]++;
            }
            
            if (counts[0] % 2 != 1) {
                for (int i = 1; i <= X/2; i++) { // O(X)
                    unmatchFound = false;
                    if (counts[i] != counts[X-i]) {
                        unmatchFound = true;
                        break;
                    }
                }
            }
        }
        
        if (unmatchFound) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    //---------------------------------------------------------------------------------------
    
    /**
   * Linear Time solution to determine if all the numberes pairs up
   * O(n) solution
   * @param N number of elements in the array
   * @param X
   * @param p array of inputs 
   * @return max profit
   */
    public static void efficient2(int N, int X, int[] p) {
        Map<Integer, Integer>  pairTracker = new HashMap<Integer, Integer>();
        
        boolean unmatchFound = true;
        
        if (N % 2 == 0) { // no pairing for odd inputs
            for (int i = 0; i < N; i++) { // O(n)
                int remainder = p[i] % X;
                if (!pairTracker.containsKey(remainder)) {
                    pairTracker.put(remainder, 1);
                } else {
                    pairTracker.put(remainder, pairTracker.get(remainder) + 1);
                }
            }
            
            if (!pairTracker.containsKey(0) || pairTracker.get(0) % 2 != 1) {
                for (int i = 1; i <= X/2; i++) { // O(X)
                    unmatchFound = false;
                    int count1 = pairTracker.containsKey(i) ? pairTracker.get(i) : 0;
                    int count2 = pairTracker.containsKey(X-i) ? pairTracker.get(X-i) : 0;
                    //System.out.println(i + " : " + (X-i) + " || " + count1 + " : " + count2);
                    if (count1 != count2) {
                        unmatchFound = true;
                        break;
                    }
                }
            }
        }
        
        if (unmatchFound) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}