class Solution {
    public String countAndSay(int n) {
        
    String res = "1";

        for (int i = 2; i <= n; i++) {
            String temp = "";
            int count = 1;

            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == res.charAt(j - 1)) {
                    count++;
                } else {
                    temp = temp + count + res.charAt(j - 1);
                    count = 1;
                }
            }

            // last group
            temp = temp + count + res.charAt(res.length() - 1);
            res = temp;
        }

        return res;
    }


}