import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        String[] sArr = s.split("");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < sArr.length; i++) {
            if (i == 0 || stack.empty()) {
                stack.push(sArr[i]);
                continue;
            }

            if (sArr[i].equals(stack.peek())) {
                stack.pop();
            } else {
                stack.push(sArr[i]);
            }
        }

        if (stack.empty()) {
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }
}