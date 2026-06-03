class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer f = freq.get(c);
            if (f == null) {
                f = 1;
            } else {
                f++;
            }
            freq.put(c, f);
        }

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            Integer f = freq.get(c);
            if (f == null) {
                freq.put(c, -1);
            } else if (f == 1) {
                freq.remove(c);
            } else {
                freq.put(c, f - 1);
            }
        }

        return freq.isEmpty();
    }
}
