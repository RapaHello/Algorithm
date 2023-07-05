import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] score = {3, 2, 1, 0, 1, 2, 3};
        String[] type = {"RT", "CF", "JM", "AN"};

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < survey.length; i++) {
            int idx = choices[i] - 1;
            String left = survey[i].substring(0, 1);
            String right = survey[i].substring(1);

            if (idx < 3) {
                map.put(left, map.getOrDefault(left, 0) + score[idx]);
            } else if (3 < idx) {
                map.put(right, map.getOrDefault(right, 0) + score[idx]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : type) {
            String left = str.substring(0, 1);
            String right = str.substring(1);

            int lScore = map.getOrDefault(left, 0);
            int rScore = map.getOrDefault(right, 0);

            if (lScore > rScore) {
                sb.append(left);
            } else if (lScore < rScore) {
                sb.append(right);
            } else {
                int compare = left.compareTo(right);
                if (compare <= 0) {
                    sb.append(left);
                } else {
                    sb.append(right);
                }
            }
        }

        return sb.toString();
    }
}