import java.util.Stack;

public class isValidString {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else {
                if(stack.isEmpty()) return false;
                if (stack.peek() == '(' && s.charAt(i) != ')') return false;
                if (stack.peek() == '[' && s.charAt(i) != ']') return false;
                if (stack.peek() == '{' && s.charAt(i) != '}') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}