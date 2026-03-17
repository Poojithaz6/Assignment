import java.util.*;

public class w1 {
    static Set<String> grams(String text) {
        String[] w = text.split(" ");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < w.length - 2; i++) {
            set.add(w[i] + " " + w[i + 1] + " " + w[i + 2]);
        }
        return set;
    }

    static double similarity(String a, String b) {
        Set<String> s1 = grams(a);
        Set<String> s2 = grams(b);
        int match = 0;
        for (String g : s1) if (s2.contains(g)) match++;
        return (match * 100.0) / s1.size();
    }

    public static void main(String[] args) {
        System.out.println(similarity("this is a test text", "this is a test data"));
    }
}