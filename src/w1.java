import java.util.*;

public class w1 {
    static class UsernameChecker {
        Map<String, Integer> users = new HashMap<>();
        Map<String, Integer> freq = new HashMap<>();

        boolean check(String name) {
            freq.put(name, freq.getOrDefault(name, 0) + 1);
            return !users.containsKey(name);
        }

        List<String> suggest(String name) {
            List<String> res = new ArrayList<>();
            for (int i = 1; i <= 3; i++) res.add(name + i);
            res.add(name.replace("_", "."));
            return res;
        }

        void add(String name, int id) {
            users.put(name, id);
        }

        String mostAttempted() {
            String ans = "";
            int max = 0;
            for (String k : freq.keySet()) {
                if (freq.get(k) > max) {
                    max = freq.get(k);
                    ans = k;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        UsernameChecker u = new UsernameChecker();
        u.add("john_doe", 1);
        System.out.println(u.check("john_doe"));
        System.out.println(u.suggest("john_doe"));
    }
}
