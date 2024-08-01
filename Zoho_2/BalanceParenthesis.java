
import java.util.Stack;

public class BalanceParenthesis {
    public static void main(String[] args) {
        String input="(([]))[]";
        int len=input.length();
        Stack<Character> stack=new Stack<>();
        int i=0;
        while(i!=len)
        {
            if(input.charAt(i)=='(' || input.charAt(i)=='{' || input.charAt(i)=='[')
            {
                stack.push(input.charAt(i));
            }
            else if(!stack.isEmpty() && input.charAt(i)==')' && stack.peek()=='(')
            {
                stack.pop();
            }
            else if(!stack.isEmpty() && input.charAt(i)==']' && stack.peek()=='[')
            {
                stack.pop();
            }
            else if(!stack.isEmpty() && input.charAt(i)=='}' && stack.peek()=='{')
            {
                stack.pop();
            }
            else
            {
                System.out.println("Unbalanced");
                return;
            }
            i++;
        }
        if(stack.isEmpty())
        {
            System.out.println("Balanced");
        }
        else
        {
            System.out.println("UnBalanced");
        }
    }
}
