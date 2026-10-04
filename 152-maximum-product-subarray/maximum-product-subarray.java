class Solution {
    public int maxProduct(int[] nums) {
        int maxi=Integer.MIN_VALUE;
    
        for(int i=0;i<nums.length;i++){
            int prepro=1;
            for(int j=i;j<nums.length;j++){
             prepro=prepro*nums[j];
             maxi=Math.max(maxi,prepro);
            }
        }
        return maxi;
    }
}