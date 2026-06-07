class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int trappedAmount = 0; 

        int argGlobalMax = argMax(0, height.length - 1, height);

        int right = argGlobalMax;
        while (right > 0) {
            int argMax = argMax(0, right - 1, height);

            trappedAmount += trapped(argMax, right, height);

            right = argMax; 
        }

        int left = argGlobalMax;
        while (left < height.length - 1) {
            int argMax = argMax(left + 1, height.length - 1, height);

            trappedAmount += trapped(left, argMax, height);

            left = argMax; 
        }

        return trappedAmount;
    }
}

private int argMax(int start, int end, int[] values) {
    int max = Integer.MIN_VALUE;
    int argMax = -1;

    for (int i = start; i <= end; i++) {
        if (values[i] > max) {
            max = values[i];
            argMax = i;
        }
    }

    return argMax;
}

private int trapped(int start, int end, int[] height) {
    int minHeight = height[start];
    if (minHeight > height[end]) {
        minHeight = height[end];
    }

    int trappedAmount = 0;

    for (int i = start + 1; i < end; i++) {
        trappedAmount += (minHeight - height[i]);
    }

    return trappedAmount;
}
