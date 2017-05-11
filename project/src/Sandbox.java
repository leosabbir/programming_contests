import java.util.Map.Entry;


public class Sandbox {
   public static void main(String[] args) {
      String ss = "kingofkings";
      //System.out.println(ss.toCharArray().toString());
      
      //System.out.println(ss.substring(0, 1));
      print(6);
   }
   
   public static void print(int n) {
      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= n; j++) {
            if (j < n-i+1) {
               System.out.print(" ");
            } else {
               System.out.print("#");
            }
         }
         System.out.println();
      }
   }
}
