import java.util.*;

public class w1{
    static class Entry {
        String ip;
        long expiry;

        Entry(String ip, long ttl) {
            this.ip = ip;
            this.expiry = System.currentTimeMillis() + ttl;
        }
    }

    Map<String, Entry> map = new HashMap<>();
    int hits = 0, misses = 0;

    String resolve(String domain) {
        if (map.containsKey(domain)) {
            Entry e = map.get(domain);
            if (System.currentTimeMillis() < e.expiry) {
                hits++;
                return e.ip;
            }
        }
        misses++;
        String ip = "1.1.1." + new Random().nextInt(255);
        map.put(domain, new Entry(ip, 3000));
        return ip;
    }

    public static void main(String[] args) {
        w1 d = new w1();
        System.out.println(d.resolve("google.com"));
        System.out.println(d.resolve("google.com"));
    }
}