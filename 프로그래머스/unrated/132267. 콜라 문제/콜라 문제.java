class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0, bottle = 0;

        while (true) {
            bottle = (n / a) * b;
            answer += bottle;
            n = bottle + (n % a);

            if (n < a) {
                break;
            }
        }

        return answer;
    }
}