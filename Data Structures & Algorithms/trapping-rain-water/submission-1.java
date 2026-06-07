class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int totalTrapped = 0;
        int rh, lh, trapped;

        trapped = 0;
        lh = height[0];
        for (int i = 1; i < height.length; i++) {
            rh = height[i];
            if (rh > lh) {
                totalTrapped += trapped;
                trapped = 0;
                lh = rh;
            } else {
                trapped += (lh - rh);
            }
        }

        trapped = 0;
        rh = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            lh = height[i];
            if (lh >= rh) {
                totalTrapped += trapped;
                trapped = 0;
                rh = lh;
            } else {
                trapped += (rh - lh);
            }
        }

        return totalTrapped;
    }
}
