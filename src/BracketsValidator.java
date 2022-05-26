import java.util.Stack;

import static java.lang.Math.ceil;
import static java.lang.Math.round;

public class BracketsValidator {
    public static void main(String[] args){
        BracketsValidator bv = new BracketsValidator();
        System.out.println(bv.validateBrackets("{[([])]]}"));

    }

    private boolean validateBrackets(String s){
        if (s.length() == 0){
            System.out.println("empty string");
            return false;
        }
        Stack<Character> reversedS = new Stack<Character>();
        char expected = '0';
        boolean close=false;
        for (int i = 0; i  < s.length() ; i++) {
            //System.out.println(s.charAt(i));
            switch (s.charAt(i)){
                case ']':
                    if (reversedS.empty())
                        return false;
                    expected = '[';
                    close = true;
                    break;
                case '[':
                    reversedS.push(s.charAt(i));
                    break;
                case '}':
                    if (reversedS.empty())
                        return false;
                    expected = '{';
                    close = true;
                    break;
                case '{':
                    reversedS.push(s.charAt(i));
                    break;
                case ')':
                    if (reversedS.empty())
                        return false;
                    expected = '(';
                    close = true;
                    break;
                case '(':
                    reversedS.push(s.charAt(i));
                    break;
//                default: return false;
            }
            //System.out.println(s.charAt(i) + " "+ expected+ " "+reversedS.peek());
            if(close){
                if(reversedS.pop() != expected)
                    return false;

            }
            close = false;

        }

        return reversedS.empty();
    }
}
