class Solution {
    private class Frequency implements Comparable<Frequency> {
        private final int frequency;
        private final int value;

        private Frequency(int frequency, int value) {
            this.frequency = frequency;
            this.value = value;
        }

        public int compareTo(Frequency that) {
            return that.frequency - frequency;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqByNum = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            Integer freq = freqByNum.get(num);
            if (freq == null) {
                freq = 1;
            } else {
                freq++;
            }

            freqByNum.put(num, freq);
        }

        ArrayList<Frequency> freqList = new ArrayList<Frequency>();
        for (Map.Entry<Integer, Integer> entry : freqByNum.entrySet()) {
            freqList.add(new Frequency(entry.getValue(), entry.getKey()));
        }

        PriorityQueue<Frequency> queue = new PriorityQueue<Frequency>(freqList);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.remove().value;
        }

        return result;
    }
}
