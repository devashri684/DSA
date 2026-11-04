import java.util.*;

class Solution {

    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    long leftSum = 0;
    long rightSum = 0;
    int leftSize = 0;
    int rightSize = 0;

    void add(TreeMap<Integer, Integer> map, int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    void remove(TreeMap<Integer, Integer> map, int num) {
        int count = map.get(num);

        if (count == 1)
            map.remove(num);
        else
            map.put(num, count - 1);
    }

    void insert(int num) {
        if (leftSize == 0 || num <= left.lastKey()) {
            add(left, num);
            leftSum += num;
            leftSize++;
        } else {
            add(right, num);
            rightSum += num;
            rightSize++;
        }

        balance();
    }

    void erase(int num) {
        if (left.containsKey(num)) {
            remove(left, num);
            leftSum -= num;
            leftSize--;
        } else {
            remove(right, num);
            rightSum -= num;
            rightSize--;
        }

        balance();
    }

    void balance() {
        while (leftSize > rightSize + 1) {
            int num = left.lastKey();

            remove(left, num);
            leftSum -= num;
            leftSize--;

            add(right, num);
            rightSum += num;
            rightSize++;
        }

        while (leftSize < rightSize) {
            int num = right.firstKey();

            remove(right, num);
            rightSum -= num;
            rightSize--;

            add(left, num);
            leftSum += num;
            leftSize++;
        }
    }

    long getCost() {
        long median = left.lastKey();

        return median * leftSize - leftSum
             + rightSum - median * rightSize;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        long[] cost = new long[n - x + 1];

        for (int i = 0; i < x; i++) {
            insert(nums[i]);
        }

        cost[0] = getCost();

        for (int i = x; i < n; i++) {
            erase(nums[i - x]);
            insert(nums[i]);

            cost[i - x + 1] = getCost();
        }

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; j++) {

                dp[i][j] = dp[i - 1][j];

                if (i >= x && dp[i - x][j - 1] != INF) {

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}