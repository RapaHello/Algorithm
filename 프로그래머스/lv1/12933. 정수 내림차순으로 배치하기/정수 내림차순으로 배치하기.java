import java.util.*;

class Solution {
    public long solution(long n) {
        String[] strArr = String.valueOf(n).split("");
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num1 = Integer.parseInt(o1);
                int num2 = Integer.parseInt(o2);
                return num2 - num1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : strArr) {
            sb.append(s);
        }

        return Long.parseLong(sb.toString());
    }
}