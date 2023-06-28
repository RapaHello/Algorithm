import java.util.Stack;

public class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> dStack = new Stack<Integer>();
        Stack<Integer> pStack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < deliveries[i]; j++) {
                dStack.push(i + 1);
            }
            for (int j = 0; j < pickups[i]; j++) {
                pStack.push(i + 1);
            }
        }

        while (!dStack.empty() && !pStack.empty()) {
            int peekD = dStack.peek();
            int peekP = pStack.peek();

            for (int i = 0; i < cap; i++) {
                if (!dStack.empty()) {
                    dStack.pop();
                }
                if (!pStack.empty()) {
                    pStack.pop();
                }
            }

            answer += Math.max(peekD, peekP) * 2L;
        }

        if (!dStack.empty()) {
            answer = repetition(answer, cap, dStack);
        }
        if (!pStack.empty()) {
            answer = repetition(answer, cap, pStack);
        }

        return answer;
    }

    private long repetition(long answer, int cap, Stack<Integer> stack) {
        while (!stack.empty()) {
            int peek = stack.peek();

            for (int i = 0; i < cap; i++) {
                if (!stack.empty()) {
                    stack.pop();
                }
            }

            answer += peek * 2L;
        }

        return answer;
    }
}
