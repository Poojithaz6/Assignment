import java.util.*;

public class w2 {

    static class LRUCache extends LinkedHashMap<String, String> {
        int cap;

        LRUCache(int cap) {
            super(cap, 0.75f, true);
            this.cap = cap;
        }

        protected boolean removeEldestEntry(Map.Entry<String, String> e) {
            return size() > cap;
        }
    }

    static class MultiCache {
        LRUCache l1 = new LRUCache(2);
        Map<String, String> l2 = new HashMap<>();
        Map<String, String> l3 = new HashMap<>();

        String get(String key) {
            if (l1.containsKey(key)) return l1.get(key);
            if (l2.containsKey(key)) {
                String v = l2.get(key);
                l1.put(key, v);
                return v;
            }
            if (l3.containsKey(key)) {
                String v = l3.get(key);
                l2.put(key, v);
                return v;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        MultiCache m = new MultiCache();
        m.l3.put("v1", "data1");
        System.out.println(m.get("v1"));
        System.out.println(m.get("v1"));
    }
}