class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        int maxSquare = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = 0;
            if (i < heights.length) {
                h = heights[i];
            }

            int p = 0;
            int l = 0;
            for (;;) {
                if (stack.empty()) {
                    break;
                } else {
                    ArrayList<Integer> top = stack.peek();

                    if (top.get(0) > h) {
                        stack.pop();

                        l += (top.get(1) + 1);
                        int square = l * top.get(0);
                        if (square > maxSquare) {
                            maxSquare = square;
                        }

                        p++;
                    } else {
                        break;
                    }
                }
            }


            ArrayList<Integer> val = new ArrayList<Integer>();
            val.add(h);
            val.add(l);

            stack.push(val);
        }

        return maxSquare;
    }
}
