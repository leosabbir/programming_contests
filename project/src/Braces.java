import java.util.Stack;


public class Braces {
   
   public static void main(String[] args) {
      String[] inputs = {"([]())([])({})", "({)}", "()}", "({}[]())([][])([][])({{{[[]]}}})(((())))", "(", ")"};
      String[] output = new String[inputs.length];
      
      braces(inputs, output);
      for(String o : output) {
         System.out.println(o);
      }
   }
   
   public static void braces(String[] inputs, String[] output) {
      
      for (int i = 0; i < inputs.length; i++) {
         Stack<Character> stack = new Stack<Character>();
         boolean error = false;
         for (int j = 0; j < inputs[i].length(); j++) {
            if (inputs[i].charAt(j) == '(' || inputs[i].charAt(j) == '{' || inputs[i].charAt(j) == '[') {
               stack.push(inputs[i].charAt(j));
            } else {
               if (stack.isEmpty() || stack.pop() != getMatchingBrace(inputs[i].charAt(j))) {
                  error = true;
                  break;
               }
            }
         }
         if (error || !stack.isEmpty()) {
            output[i] = "NO";
         } else {
            output[i] = "YES";
         }
      }
      
   }
   
   private static char getMatchingBrace(char brace) {
      switch (brace) {
      case ')':
         return '(';
      case '}':
         return '{';
      default:
         return '[';
      }
   }

}
