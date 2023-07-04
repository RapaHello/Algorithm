import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
         Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num1, num2;
                while (true) {
                    num1 = (int) o1.charAt(n);
                    num2 = (int) o2.charAt(n);

                    if (num1 == num2) {
                        return o1.compareTo(o2);
                    } else {
                        return num1 - num2;
                    }
                }

            }
        });
        return strings;
    }
}