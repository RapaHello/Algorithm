class Solution {
    public int solution(int num) {
        int result = 0;
        
        if (1 < num && num < 8000000) {
            while (true) {
                if (num % 2 == 0) {
                    num /= 2;
                } else if (num % 2 == 1) {
                    num = num * 3 + 1;
                }

                result += 1;
                if (num == 1) {
                    break;
                }
                if (result == 500) {
                    result = -1;
                    break;
                }
            }
        }

        return result;
    }
}