class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int['z' - 'a' + 1];

        int d = 0;

        int s1l = s1.length();
        int s2l = s2.length();

        if (s1l > s2l) {
            return false;
        }

        for (int i = 0; i < s1l; i++) {
            if ((freq[s1.charAt(i) - 'a']--) == 0) {
                d++;
            }
        }

        for (int i = 0; i < s1l; i++) {
            int n = freq[s2.charAt(i) - 'a'];

            if (n == 0) {
                d++;
            }

            n++;

            freq[s2.charAt(i) - 'a'] = n;

            if (n == 0) {
                d--;
            }
        }

        for (int i = s1l; ; i++) {
            if (d == 0) {
                return true;
            }

            if (i == s2l) {
                break;
            }

            int n = freq[s2.charAt(i) - 'a'];

            if (n == 0) {
                d++;
            }

            n++;

            freq[s2.charAt(i) - 'a'] = n;

            if (n == 0) {
                d--;
            }

            n = freq[s2.charAt(i - s1l) - 'a'];

            if (n == 0) {
                d++;
            }

            n--;

            freq[s2.charAt(i - s1l) - 'a'] = n;

            if (n == 0) {
                d--;
            }
        }

        return false;
    }
}
