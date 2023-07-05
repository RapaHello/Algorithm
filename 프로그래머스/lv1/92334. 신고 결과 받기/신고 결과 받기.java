import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : id_list) {
            countMap.put(s, 0);
        }

        // 중복 제거 및 분배
        Set<String> set = new HashSet<>(Arrays.asList(report));
        Map<String, List<String>> reportList = new HashMap<>();
        for (String s : set) {
            String[] arr = s.split(" ");
            reportList.computeIfAbsent(arr[0], k1 -> new ArrayList<>()).add(arr[1]);
            countMap.put(arr[1], countMap.getOrDefault(arr[1], 0) + 1);
        }

        int[] resultArr = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            int cnt = 0;
            String temp = id_list[i];
            List<String> tempList = reportList.get(temp);
            if (tempList != null) {
                for (String s : tempList) {
                    if (countMap.get(s) >= k) {
                        cnt++;
                    }
                }
            }
            resultArr[i] = cnt;
        }
        return resultArr;
    }
}