class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       int n=nums.length;
       List<List<Integer>> result= new ArrayList<>();
       Arrays.sort(nums);
       
       for (int k = 0; k < n - 2; k++) {
       if (k > 0 && nums[k] == nums[k - 1]) continue;
       int i=k+1;
       int j=n-1;

       while(i<j){
        int sum = -nums[k];
           if (nums[i] + nums[j] == sum) {
           result.add(Arrays.asList(nums[i],nums[j],nums[k]));
           while (i < j && nums[i] == nums[i + 1]){
            i++;
           }
           while(i<j && nums[j]==nums[j-1]){
            j--;
           }
            i++;
            j--;
            }
            else if (nums[i] + nums[j] < sum) {
                    i++;
            }
                else {
                    j--;
                }
            }
        }

        return result;
    }
}