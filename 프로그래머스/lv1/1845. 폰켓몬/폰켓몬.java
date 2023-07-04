import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int num = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        
        int result, size = set.size();
        if (num <= size) {
            result = num; 
        } else {
            result = size;
        }
                
        return result;
    }
}