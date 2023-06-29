import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int sum = 0, oSum = 0, pSum = 0;
        Queue<Integer> oQueue = new LinkedList<>();
        Queue<Integer> pQueue = new LinkedList<>();
        for (int q1 : queue1) {
            oQueue.add(q1);
            oSum += q1;
        }
        for (int q2 : queue2) {
            pQueue.add(q2);
            pSum += q2;
        }

        sum = oSum + pSum;
        if (sum % 2 == 1) {
            return -1;
        }

        sum /= 2;
        while (oSum != pSum) {
            if (answer > queue1.length * 4) {
                return -1;
            }

            if (oSum < sum) {
                pSum -= pQueue.peek();
                oSum += pQueue.peek();
                oQueue.add(pQueue.poll());
            } else {
                pSum += oQueue.peek();
                oSum -= oQueue.peek();
                pQueue.add(oQueue.poll());
            }

            answer++;
        }

        return answer;
    }
}
