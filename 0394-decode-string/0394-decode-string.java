class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String curr = "";
        int num = 0;

        for(char ch : s.toCharArray()) {

            // If digit
            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // If opening bracket
            else if(ch == '[') {
                countStack.push(num);
                stringStack.push(curr);

                num = 0;
                curr = "";
            }

            // If closing bracket
            else if(ch == ']') {

                int repeat = countStack.pop();
                String prev = stringStack.pop();

                StringBuilder temp = new StringBuilder(prev);

                for(int i = 0; i < repeat; i++) {
                    temp.append(curr);
                }

                curr = temp.toString();
            }

            // Normal character
            else {
                curr += ch;
            }
        }

        return curr;
    }
}