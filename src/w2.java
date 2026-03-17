import java.util.*;

public class w2 {

    static class TokenBucket {
        int tokens;
        int maxTokens;
        long lastRefill;
        int refillRate;

        TokenBucket(int maxTokens, int refillRate) {
            this.tokens = maxTokens;
            this.maxTokens = maxTokens;
            this.refillRate = refillRate;
            this.lastRefill = System.currentTimeMillis();
        }

        synchronized boolean allow() {
            long now = System.currentTimeMillis();
            long diff = (now - lastRefill) / 1000;
            int refill = (int) diff * refillRate;
            if (refill > 0) {
                tokens = Math.min(maxTokens, tokens + refill);
                lastRefill = now;
            }
            if (tokens > 0) {
                tokens--;
                return true;
            }
            return false;
        }
    }

    static class RateLimiter {
        Map<String, TokenBucket> map = new HashMap<>();

        boolean check(String client) {
            map.putIfAbsent(client, new TokenBucket(5, 1));
            return map.get(client).allow();
        }
    }

    public static void main(String[] args) {
        RateLimiter r = new RateLimiter();
        for (int i = 0; i < 10; i++) {
            System.out.println(r.check("user1"));
        }
    }
}