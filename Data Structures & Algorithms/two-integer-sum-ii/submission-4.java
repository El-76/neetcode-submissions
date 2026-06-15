class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (r > l) {
            int s = numbers[l] + numbers[r];
            if (s > target) {
                r--;
            } else if (s < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }

        return new int[]{};
    }
}
