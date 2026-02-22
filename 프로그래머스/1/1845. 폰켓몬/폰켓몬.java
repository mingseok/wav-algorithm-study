import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for( int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        int n = nums.length/2;
        
        if(map.size() > n ) {
            return n;
        }else{
            return map.size();
        }
        
    }
}