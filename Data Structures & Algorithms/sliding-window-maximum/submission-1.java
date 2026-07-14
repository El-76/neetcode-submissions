class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> s = new LinkedList<Integer>();

        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            for (;;) {
                if (s.isEmpty()) {
                    s.addLast(i);

                    break;
                } else {
                    int j = s.peekLast();

                    if (nums[j] < nums[i]) {
                        s.removeLast();
                    } else {
                        s.addLast(i);

                        break;
                    }
                } 
            }
        }

        res[0] = nums[s.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            int l = s.peekFirst();

            if (l == i - k) {
                s.removeFirst();
            }

            for (;;) {
                if (s.isEmpty()) {
                    s.addLast(i);

                    break;
                } else {
                    int j = s.peekLast();

                    if (nums[j] < nums[i]) {
                        s.removeLast();
                    } else {
                        s.addLast(i);

                        break;
                    }
                } 
            }

            l = s.peekFirst();

            res[i - k + 1] = nums[l];
        }

        return res;
    }
}
