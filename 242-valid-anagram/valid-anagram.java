class Solution {
    public boolean isAnagram(String s, String t) {
        //precompute
        int hash1[]=new int[26];
        for(int i=0;i<s.length();i++){
           hash1[s.charAt(i)-'a']++; 
        }
        int hash2[]=new int[26];
        for(int i=0;i<t.length();i++){
           hash2[t.charAt(i)-'a']++; 
        }
        if(Arrays.equals(hash1,hash2)){
            return true;
        }
        return false;
    }
}