import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(int a, int b) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int sum = b;
        for (int i = 0; i < (a - 1); i++) {
            sum += date[i];
        }

        int idx = sum % 7;
        return day[idx];
    }
}