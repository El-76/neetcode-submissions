class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        int l = 1;
        int r = max;
        int i = -1;

        for (;;) {
            int m = l + ((r - l) / 2);

            int t = calcTime(piles, m);

            if (l == r) {
                if (i < 0) {
                    return m;
                } else if (t == h) {
                    return m;
                } else {
                    return i;
                }
            }

            if (t > h) {
                l = m + 1;
            } else if (t < h) {
                r = m;
            } else {
                i = m;
                r = m;
            }
        }
    }

    private int calcTime(int[] piles, int k) {
        int h = 0;
        for (int pile : piles) {
            h += (pile / k);

            if ((pile % k) > 0) {
                h++;
            }
        }

        return h;
    }
}
