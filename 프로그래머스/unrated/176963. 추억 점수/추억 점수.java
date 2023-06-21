import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = IntStream.range(0, name.length)
                .boxed()
                .collect(Collectors.toMap(i -> name[i], i -> yearning[i], (a, b) -> b, HashMap::new));

        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
               answer[i] += map.getOrDefault(photo[i][j], 0);
            }
        }
        
        return answer;
    }
}