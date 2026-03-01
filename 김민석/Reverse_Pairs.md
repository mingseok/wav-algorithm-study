## Reverse Pairs

- https://leetcode.com/problems/reverse-pairs/description/

```java
import java.util.*;

class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int[] tmp = new int[nums.length];
        long count = mergeSort(nums, 0, nums.length - 1, tmp);
        return (int) count;
    }

    private long mergeSort(int[] nums, int left, int right, int[] tmp) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        long count = 0;
        count += mergeSort(nums, left, mid, tmp);
        count += mergeSort(nums, mid + 1, right, tmp);

        // count cross pairs: i in [left..mid], j in [mid+1..right]
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * (long) nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        // merge two sorted halves
        int i = left;
        j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) tmp[k++] = nums[i++];
            else tmp[k++] = nums[j++];
        }
        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= right) tmp[k++] = nums[j++];

        for (int p = left; p <= right; p++) {
            nums[p] = tmp[p];
        }

        return count;
    }
}
```
