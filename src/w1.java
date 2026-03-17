import java.util.*;

public class w1 {
    static class InventoryManager {
        Map<String, Integer> stock = new HashMap<>();
        Map<String, Queue<Integer>> wait = new HashMap<>();

        void addProduct(String id, int count) {
            stock.put(id, count);
            wait.put(id, new LinkedList<>());
        }

        synchronized String purchase(String id, int user) {
            int s = stock.getOrDefault(id, 0);
            if (s > 0) {
                stock.put(id, s - 1);
                return "Success";
            } else {
                wait.get(id).offer(user);
                return "Waitlist";
            }
        }

        int check(String id) {
            return stock.getOrDefault(id, 0);
        }
    }

    public static void main(String[] args) {
        InventoryManager i = new InventoryManager();
        i.addProduct("p1", 2);
        System.out.println(i.purchase("p1", 1));
        System.out.println(i.purchase("p1", 2));
        System.out.println(i.purchase("p1", 3));
    }
}