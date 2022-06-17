/*
 * The Solution to this problem is to use a stack to detect for validity of open and
 *  closing brackets. 
 * So whenever we encounter an opening bracket, we push a closing bracket into the stack
 *  When we counter a closing bracket, we check if the stack is empty or the top
 *   of the stack will be opener for the current closing bracket
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Char> stack = new Stack<Char>();
        for (int i=0; i < s.length(); i++)
        {
            switch(s.charAt(i)){
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ')': 
                    case '}': 
                        case ']':{
                            if(stack.isEmpty() || stack.pop() != s.charAt[i])
                                return false;
                        }
            }
        }
        return stack.isEmpty();
    }
}