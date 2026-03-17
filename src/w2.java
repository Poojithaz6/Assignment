import java.util.*;

public class w2 {

    static List<int[]> twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int comp = target - arr[i];
            if (map.containsKey(comp)) {
                res.add(new int[]{map.get(comp), i});
            }
            map.put(arr[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {500, 300, 200};
        List<int[]> res = twoSum(arr, 500);
        for (int[] p : res) {
            System.out.println(p[0] + " " + p[1]);
        }
    }
}