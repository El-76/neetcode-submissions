class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int i = 0;

        for (String token : tokens) {
            if ("+".equals(token)) {
                stack[i - 2] = stack[i - 1] + stack[i - 2];

                i --; 
            } else if ("-".equals(token)) {
                stack[i - 2] = stack[i - 2] - stack[i - 1];

                i --;
            } else if ("/".equals(token)) {
                stack[i - 2] = stack[i - 2] / stack[i - 1];

                i --;
            } else if ("*".equals(token)) {
                stack[i - 2] = stack[i - 1] * stack[i - 2];

                i --;
            } else {
                stack[i] = Integer.parseInt(token);

                i++;
            }
        }

        return stack[0];
    }
}
