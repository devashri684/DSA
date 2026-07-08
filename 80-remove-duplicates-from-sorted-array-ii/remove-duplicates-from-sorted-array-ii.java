class Solution {
    public int removeDuplicates(int[] nums) {
      int stop = 0;
        int moving = 0;
        int n = nums.length;

        while (moving < n) {
            if (stop < 2 || nums[moving] != nums[stop - 2]) {
                nums[stop] = nums[moving];
                stop++;
            }
            moving++;
        }

        return stop;
    }
}