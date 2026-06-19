class Solution {
    private class Item {
        private final int height;
        private final int width;

        private Item(int height, int width) {
            this.height = height;
            this.width = width;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Item> stack = new Stack<Item>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = 0;
            if (i < heights.length) {
                h = heights[i];
            }

            int width = 1;
            for (;;) {
                if (stack.empty()) {
                    stack.push(new Item(h, width));

                    break;
                } else {
                    Item top = stack.peek();

                    if (top.height >= h) {
                        stack.pop();

                        width += top.width;
                        int area = (width - 1) * top.height;
                        if (area > maxArea) {
                            maxArea = area;
                        }
                    } else {
                        stack.push(new Item(h, width));

                        break;
                    }
                }
            }
        }

        return maxArea;
    }
}