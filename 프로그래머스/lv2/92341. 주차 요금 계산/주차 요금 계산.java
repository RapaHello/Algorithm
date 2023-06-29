import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> standingTime = new HashMap<>();
        Map<String, Integer> parkingTime = new HashMap<>();

        for (String record : records) {
            String[] car = record.split(" ");
            String[] time = car[0].split(":");

            int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            if (car[2].equals("IN")) {
                standingTime.put(car[1], minute);
            } else {
                int standing = standingTime.get(car[1]);
                int parking = minute - standing;

                standingTime.put(car[1], -1);
                parkingTime.compute(car[1], (key, value) -> value == null ? parking : value + parking);
            }
        }

        Map<String, Integer> sortedMap = new TreeMap<>(standingTime);

        int cnt = 0;
        int[] answer = new int[sortedMap.size()];
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            int time = parkingTime.get(key) == null ? 0 : parkingTime.get(key);

            int day = 0, fare = 0;
            if (value >= 0) {
                if (time == 0) {
                    day = (23 * 60 + 59) - value;
                } else {
                    day = time + (23 * 60 + 59) - value;
                }

                if (day <= fees[0]) {
                    fare = fees[1];
                } else {
                    day -= fees[0];
                    if (day % fees[2] != 0) {
                        day += fees[2] - (day % fees[2]);
                    }
                    System.out.println("day = " + day);
                    fare = fees[1] + (day / fees[2]) * fees[3];
                }

                answer[cnt] = fare;
            } else {
                if (time <= fees[0]) {
                    fare = fees[1];
                } else {
                    day = time - fees[0];
                    if (day % fees[2] != 0) {
                        day += fees[2] - (day % fees[2]);
                    }
                    fare = fees[1] + (day / fees[2]) * fees[3];
                }

                answer[cnt] = fare;
            }

            cnt++;
        }

        return answer;
    }
}