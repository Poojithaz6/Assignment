import java.util.*;

public class w1 {
    static class Analytics {
        Map<String, Integer> views = new HashMap<>();
        Map<String, Set<String>> users = new HashMap<>();
        Map<String, Integer> source = new HashMap<>();

        void process(String url, String user, String src) {
            views.put(url, views.getOrDefault(url, 0) + 1);
            users.putIfAbsent(url, new HashSet<>());
            users.get(url).add(user);
            source.put(src, source.getOrDefault(src, 0) + 1);
        }

        List<String> top() {
            List<String> res = new ArrayList<>(views.keySet());
            res.sort((a, b) -> views.get(b) - views.get(a));
            return res.subList(0, Math.min(3, res.size()));
        }
    }

    public static void main(String[] args) {
        Analytics a = new Analytics();
        a.process("page1", "u1", "google");
        a.process("page1", "u2", "facebook");
        System.out.println(a.top());
    }
}