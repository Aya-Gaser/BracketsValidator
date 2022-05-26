import java.util.Stack;

public class BracketsValidator {
    public static void main(String[] args){
        BracketsValidator bv = new BracketsValidator();
        System.out.println(bv.validateBrackets("{{[(()))]}}"));

    }

    private boolean validateBrackets(String s){
        if (s.length() == 0){
            System.out.println("empty string");
            return false;
        }
        Stack<Character> reversedS = new Stack<Character>();
        for (int i = 0; i <s.length() ; i++) {
            reversedS.push(s.charAt(i));
           // System.out.println(s.charAt(i));
        }
        char expected ='a';
        for (int i = 0; i < s.length() ; i++) {
            //System.out.println(s.charAt(i));
            switch (reversedS.pop()){
                case ']':
                    expected = '[';
                    break;
                case '[':
                    expected = ']';
                    break;
                case '}':
                    expected = '{';
                    break;
                case '{':
                    expected = '}';
                    break;
                case ')':
                    expected = '(';
                    break;
                case '(':
                    expected = ')';
                    break;
                default: return false;
            }
            //System.out.println(s.charAt(i) + " "+ expected+ " "+reversedS.peek());
            if(s.charAt(i) != expected)
                return false;
        }

        return true;
    }
}
