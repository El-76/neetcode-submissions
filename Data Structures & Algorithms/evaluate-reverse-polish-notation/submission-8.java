class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String token : tokens) {
            if ("+".equals(token)) {
                Integer a = stack.pop();
                Integer b = stack.pop();

                stack.push(a + b);
            } else if ("-".equals(token)) {
                Integer a = stack.pop();
                Integer b = stack.pop();

                stack.push(b - a);
            } else if ("/".equals(token)) {
                Integer a = stack.pop();
                Integer b = stack.pop();

                stack.push(b / a);
            } else if ("*".equals(token)) {
                Integer a = stack.pop();
                Integer b = stack.pop();

                stack.push(a * b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}