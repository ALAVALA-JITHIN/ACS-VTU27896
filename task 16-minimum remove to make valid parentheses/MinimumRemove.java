public class MinimumRemove {

    public String minRemoveToMakeValid(String s) {

        StringBuilder result = new StringBuilder();
        int open = 0;

        // First pass: remove invalid ')'
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
                result.append(ch);
            }

            else if (ch == ')') {

                if (open > 0) {
                    open--;
                    result.append(ch);
                }
            }

            else {
                result.append(ch);
            }
        }

        // Second pass: remove extra '('
        StringBuilder answer = new StringBuilder();

        for (int i = result.length() - 1; i >= 0; i--) {

            char ch = result.charAt(i);

            if (ch == '(' && open > 0) {
                open--;
            }

            else {
                answer.append(ch);
            }
        }

        return answer.reverse().toString();
    }

    public static void main(String[] args) {

        MinimumRemove obj = new MinimumRemove();

        System.out.println(
            obj.minRemoveToMakeValid("lee(t(c)o)de)")
        );

        System.out.println(
            obj.minRemoveToMakeValid("a)b(c)d")
        );

        System.out.println(
            obj.minRemoveToMakeValid("))((")
        );
    }
}
