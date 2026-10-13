class Solution {
    public long maxAlternatingSum(int[] nums) {
      long[] square=new long[nums.length];
      for(int i=0;i<nums.length;i++){
        square[i]=(long) nums[i]* nums[i];
      }
      Arrays.sort(square);
      long sum=0;
      int n=square.length;
      for(int i=0;i<n/2;i++){
        sum-=square[i];
      }
      for(int i=n/2;i<n;i++){
        sum+=square[i];
      }

      return sum;

    }
}