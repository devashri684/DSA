class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int id=0;
        int[] required = new int[m + n];

        int i = 0;
        int j = 0;

        // condition should be i < m and j < n
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                required[id] = nums1[i];
                i++;
            } else {
                required[id] = nums2[j];
                j++;
            }
            id++;
        }

        // remaining elements
        while (i < m) {
            required[id] = nums1[i];
            i++;
            id++;
        }

        while (j < n) {
            required[id] = nums2[j];
            j++;
            id++;
        }

        // copy back into nums1
        for (int k = 0; k < m + n; k++) {
            nums1[k] = required[k];
        }
    }

}