import java.util.Stack;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int prev = -1;
        for (int i : arr) {
            if (i != prev) {
                list.add(i);
                prev = i;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}