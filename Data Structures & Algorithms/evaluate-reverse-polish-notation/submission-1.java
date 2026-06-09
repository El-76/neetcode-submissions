class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();

        for (String token : tokens) {
            if ("+".equals(token)) {
                String a = stack.pop();
                String b = stack.pop();

                stack.push(Integer.toString(Integer.parseInt(a) + Integer.parseInt(b)));
            } else if ("-".equals(token)) {
                String a = stack.pop();
                String b = stack.pop();

                stack.push(Integer.toString(Integer.parseInt(b) - Integer.parseInt(a)));
            } else if ("/".equals(token)) {
                String a = stack.pop();
                String b = stack.pop();

                stack.push(Integer.toString(Integer.parseInt(b) / Integer.parseInt(a)));
            } else if ("*".equals(token)) {
                String a = stack.pop();
                String b = stack.pop();

                stack.push(Integer.toString(Integer.parseInt(a) * Integer.parseInt(b)));
            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
