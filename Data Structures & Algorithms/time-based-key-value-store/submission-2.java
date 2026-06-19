class TimeMap {
    private static class Entry implements Comparable<Entry> {
        private final String value;
        private final int timestamp;

        private Entry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        public int compareTo(Entry that) {
            return this.timestamp - that.timestamp;
        }
    }

    private final HashMap<String, ArrayList<Entry>> map;

    public TimeMap() {
        map = new HashMap<String, ArrayList<Entry>>();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Entry> entries = map.computeIfAbsent(key, k -> new ArrayList<Entry>());

        entries.add(new Entry(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Entry> entries = map.get(key);

        if (entries == null) {
            return "";
        }

        int i = Collections.binarySearch(entries, new Entry("", timestamp));

        if (i < 0) {
            i = ~i - 1;
        }

        if (i < 0) {
            return "";
        }

        return entries.get(i).value;
    }
}
