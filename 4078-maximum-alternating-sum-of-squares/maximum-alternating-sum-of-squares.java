class Solution {
    public long maxAlternatingSum(int[] nums) {
    
    //step1: Square every element
    long[] Square=new long[nums.length];

    for(int i=0;i<nums.length;i++){
        Square[i]=(long) nums[i]* nums[i];
    }
    
    //step 2: sort the squared values in ascending order
    Arrays.sort(Square);

    long sum=0;
    int n=Square.length;
    //step 3: Substract the smaller half
    for(int i=0;i< n/2 ;i++){
        sum -=Square[i];
    }

    //step 4: Add the larger half
    for(int i=n/2 ; i < n; i++){
        sum += Square[i];
    }

    // Step 5: Return the maximun alterbating sum
    return sum;
    }
}