class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Keep only k largest elements
        for (int num : nums) {

            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Root = Kth largest
        return pq.peek();
    }
}