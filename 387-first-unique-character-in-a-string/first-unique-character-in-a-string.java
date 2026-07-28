class Solution {
    public int firstUniqChar(String s) {
        //precompute
        int hash[]=new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }

        //fetch
        for(int i=0;i<s.length();i++){
            if(hash[s.charAt(i)-'a']==1){
                return i;
            }
        }

        return -1;
    
    }

}