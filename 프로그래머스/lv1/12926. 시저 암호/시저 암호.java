class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int dec = (int) s.charAt(i);
            if (65 <= dec && dec <= 90) {
                if (dec + n <= 90) {
                    sb.append((char) (dec + n));
                } else {
                    sb.append((char) (65 + dec + n - 91));
                }
            } else if (97 <= dec && dec <= 122) {
                if (dec + n <= 122) {
                    sb.append((char) (dec + n));
                } else {
                    sb.append((char) (97 + dec + n - 123));
                }
            } else {
                sb.append((char) dec);
            }
        }
        return sb.toString();
    }
}