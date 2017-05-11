
public class EmployeeOrder {
   
   public static void main(String []args){
      System.out.println("Hello World");
      int[] numbers = {6, 4, 2, 6, 2, 0, 0, 0, 0, 0};//{2,1,1,0};
      int[] output = new int[numbers.length];
      
      compute(numbers, output);
      for (int i = 0; i < numbers.length; i++) {
          System.out.print(output[i] + " ");
      }
   }
   
   public static void compute(int[] numbers, int[] output) {
       for (int i = 0; i < numbers.length; i++) {
           for (int j = numbers[i]; j < numbers.length; j++) {
               if (output[j] == 0) {
                   int count = 0;
                   for (int k = 0; k < j; k++) {
                       if (output[k] > 0) {
                           count++;
                       }
                   }
                   output[count+numbers[i]] = i+1;
                   break;
               } else {
                   continue;
               }
           }
       }
       
   }

}
