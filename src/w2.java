import java.util.*;

public class w2 {

    static class Parking {
        String[] table;
        int size;

        Parking(int n) {
            size = n;
            table = new String[n];
        }

        int hash(String s) {
            return Math.abs(s.hashCode()) % size;
        }

        int park(String plate) {
            int idx = hash(plate);
            int start = idx;
            while (table[idx] != null) {
                idx = (idx + 1) % size;
                if (idx == start) return -1;
            }
            table[idx] = plate;
            return idx;
        }

        void exit(String plate) {
            int idx = hash(plate);
            while (table[idx] != null) {
                if (table[idx].equals(plate)) {
                    table[idx] = null;
                    return;
                }
                idx = (idx + 1) % size;
            }
        }
    }

    public static void main(String[] args) {
        Parking p = new Parking(10);
        System.out.println(p.park("ABC123"));
        System.out.println(p.park("XYZ999"));
    }
}