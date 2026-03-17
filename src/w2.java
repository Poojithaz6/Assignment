import java.util.*;

public class w2 {

    static class AutoComplete {
        Map<String, Integer> map = new HashMap<>();

        void add(String query) {
            map.put(query, map.getOrDefault(query, 0) + 1);
        }

        List<String> search(String prefix) {
            List<String> res = new ArrayList<>();
            for (String q : map.keySet()) {
                if (q.startsWith(prefix)) res.add(q);
            }
            res.sort((a, b) -> map.get(b) - map.get(a));
            return res.subList(0, Math.min(3, res.size()));
        }
    }

    public static void main(String[] args) {
        AutoComplete a = new AutoComplete();
        a.add("java");
        a.add("javascript");
        a.add("java tutorial");
        System.out.println(a.search("jav"));
    }
}