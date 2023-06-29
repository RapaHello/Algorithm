import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingMap = new TreeMap<>();

        for (String record : records) {
            String[] temp = record.split(" ");
            int parking = temp[2].equals("IN") ? -1 : 1;
            int time = timeParseInt(temp[0]) * parking;
            parkingMap.compute(temp[1], (key, value) -> value == null ? time : value + time);
        }

        int idx = 0, answer[] = new int[parkingMap.size()];
        for (int time : parkingMap.values()) {
            if (time < 1) time += 1439;
            time -= fees[0];
            int fare = fees[1];
            if (time > 0) {
                fare += (time % fees[2] == 0 ? time / fees[2] : time / fees[2] + 1) * fees[3];
            }

            answer[idx++] = fare;
        }
        return answer;
    }
    
    private int timeParseInt(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}