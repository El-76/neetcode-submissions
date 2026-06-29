class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();

        String s;
        String l;
        int sl;
        int ll;

        int s1l = s1.length();
        int s2l = s2.length();

        if (s1l > s2l) {
            return false;
        } else {
            l = s2;
            s = s1;

            ll = s2l;
            sl = s1l;
        }

        for (int i = 0; i < sl; i++) {
            Character c = s.charAt(i);

            freq.put(c, freq.getOrDefault(c, 0) - 1);
        }

        for (int i = 0; i < sl; i++) {
            Character c = l.charAt(i);

            Integer n = freq.getOrDefault(c, 0) + 1;

            if (n == 0) {
                freq.remove(c);
            } else {
                freq.put(c, n);
            }
        }

        for (int i = sl; ; i++) {
            if (freq.isEmpty()) {
                return true;
            }

            if (i == ll) {
                break;
            }

            Character c = l.charAt(i);

            Integer n = freq.getOrDefault(c, 0) + 1;

            if (n == 0) {
                freq.remove(c);
            } else {
                freq.put(c, n);
            }

            c = l.charAt(i - sl);

            n = freq.getOrDefault(c, 0) - 1;

            if (n == 0) {
                freq.remove(c);
            } else {
                freq.put(c, n);
            }
        }

        return false;
    }
}
