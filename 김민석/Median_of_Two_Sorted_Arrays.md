## Median of Two Sorted Arrays

https://leetcode.com/problems/median-of-two-sorted-arrays/description/

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int total = m + n;
        int leftSize = (total + 1) / 2; 

        int lo = 0, hi = m; 
        while (lo <= hi) {
            int i = (lo + hi) >>> 1; 
            int j = leftSize - i;  

            int Aleft  = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int Aright = (i < m) ? nums1[i]     : Integer.MAX_VALUE;
            int Bleft  = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int Bright = (j < n) ? nums2[j]     : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if ((total & 1) == 1) {
                    return Math.max(Aleft, Bleft);
                } else {
                    int leftMax  = Math.max(Aleft, Bleft);
                    int rightMin = Math.min(Aright, Bright);
                    return (leftMax + rightMin) / 2.0;
                }
            }
            if (Aleft > Bright) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
        }

        return 0.0;
    }
}
```
