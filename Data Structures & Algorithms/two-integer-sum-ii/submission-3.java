class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        for (;;) {
            int s = numbers[l] + numbers[r];
            if (s > target) {
                r--;
            } else if (s < target) {
                l++;
            } else if (l != r) {
                return new int[]{l + 1, r + 1};
            }
        }
    }
}
