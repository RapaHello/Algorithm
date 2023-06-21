import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        boolean nameCondition = name.length >= 3 && name.length <= 100;

        Map<String, Integer> nameScoreMap = new HashMap<>();
        if (name.length == yearning.length && nameCondition) {
            for (int i = 0; i < name.length; i++) {
                nameScoreMap.put(name[i], yearning[i]);
            }
        }

        Map<Integer, String[]> photoMap = new HashMap<>();
        if (3 <= photo.length && photo.length <= 100) {
            for (int i = 0; i < photo.length; i++) {
                photoMap.put(i, photo[i]);
            }
        }

        for (int i = 0; i < photoMap.size(); i++) {
            String[] list = photoMap.get(i);
            for (int j = 0; j < list.length; j++) {
                if (nameScoreMap.containsKey(list[j])) {
                    answer[i] += nameScoreMap.get(list[j]);
                }
            }
        }
        
        return answer;
    }
}