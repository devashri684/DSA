class Solution {
    public int mySqrt(int x) {
   if (x == 0 || x == 1) return x;

        int left = 1, right = x;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;        // store possible answer
                left = mid + 1;   // move right
            } else {
                right = mid - 1;  // move left
            }
        }

        return ans;
    }
}