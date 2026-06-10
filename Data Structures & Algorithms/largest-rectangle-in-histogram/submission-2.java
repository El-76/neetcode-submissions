class Solution {
    private class Item {
        private final int height;
        private final int head;

        private Item(int height, int head) {
            this.height = height;
            this.head = head;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Item> stack = new Stack<Item>();
        int maxSquare = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = 0;
            if (i < heights.length) {
                h = heights[i];
            }

            int head = 0;
            for (;;) {
                if (stack.empty()) {
                    break;
                } else {
                    Item top = stack.peek();

                    if (top.height > h) {
                        stack.pop();

                        head += (top.head + 1);
                        int square = head * top.height;
                        if (square > maxSquare) {
                            maxSquare = square;
                        }
                    } else {
                        break;
                    }
                }
            }

            stack.push(new Item(h, head));
        }

        return maxSquare;
    }
}
