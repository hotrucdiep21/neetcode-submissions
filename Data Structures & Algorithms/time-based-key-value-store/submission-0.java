class Entry {
    int timestamp;
    String value;

    Entry(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}
class TimeMap {
    Map<String, List<Entry>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        List<Entry> list = timeMap.get(key);
        int l = 0;
        int r = list.size() - 1;

        Entry candidate = null;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            Entry current = list.get(mid);

            if (current.timestamp <= timestamp) {
                candidate = current;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (candidate == null) {
            return "";
        }

        return candidate.value;
    }
}
