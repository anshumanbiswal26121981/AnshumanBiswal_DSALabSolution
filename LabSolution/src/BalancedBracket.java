import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BalancedBracket {
   public static Map<String, String> BRACKET_MAP = Stream.of(new String[][] {
         { "}", "{" },
         { ")", "(" },
         { "]", "[" },
   }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      if (isBalanced(s.trim())) {
         System.out.println("The entered String has Balanced Brackets");
      } else {
         System.out.println("The entered Strings do not contain Balanced Brackets");
      }

   }

   public static boolean isBalanced(String str) {
      Stack<String> bracketStack = new Stack<>();
      boolean isBalanced = true;
      for (int i = 0 ; i < str.trim().length(); ++i) {
         char ch = str.charAt(i);
         String bracket = ""+ch;
         if (!bracket.trim().isEmpty()) {
            if (BRACKET_MAP.containsValue(bracket)) {
               bracketStack.push(bracket);
            } else {
               if (BRACKET_MAP.containsKey(bracket)) {
                  if (!bracketStack.isEmpty()) {
                     String popedBracket = bracketStack.pop();
                     if (!popedBracket.equals(BRACKET_MAP.get(bracket))) {
                        isBalanced = false;
                        break;
                     }
                  } else {
                     isBalanced = false;
                  }
               }
            }
         }
      }

      if (isBalanced) {
         if (bracketStack.isEmpty()) {
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
