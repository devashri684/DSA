class Solution {
    public int removeDuplicates(int[] nums) {
        int fistpoi=0;
        int unique=1;
        int secondpoi=1;
        int n=nums.length;
        while(secondpoi<n){
            if(nums[secondpoi]==nums[secondpoi-1]){
                secondpoi++;
                continue;
            }
            nums[fistpoi+1]=nums[secondpoi];
            fistpoi++;
            unique++;
            secondpoi++;
        }
        return unique;
    }
}