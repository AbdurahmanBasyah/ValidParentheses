import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Scanner;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        // Map to store matching brackets
        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put(')', '(');
        bracketPairs.put('}', '{');
        bracketPairs.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (bracketPairs.containsKey(c)) {
                // Closing bracket: Pop from stack and check
                if (stack.isEmpty() || stack.pop() != bracketPairs.get(c)) {
                    return false;
                }
            } else {
                // Opening bracket: Push onto stack
                stack.push(c);
            }
        }

        // Stack should be empty if all brackets were matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input: s = ");
        String testCase = input.nextLine();
        System.out.println(isValid(testCase));
        input.close();
    }
}
