import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }


        int answer[] = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                answer[i] += map.getOrDefault(photo[i][j], 0);
            }
        }

        return answer;
    }
}