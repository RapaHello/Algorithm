import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(int a, int b) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] month = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < 12; i++) {
            tempMap.put(month[i], date[i]);
        }

        int sum = b;
        for (int i = 1; i < a; i++) {
            sum += tempMap.get(i);
        }

        int idx = sum % 7;
        return day[idx];
    }
}