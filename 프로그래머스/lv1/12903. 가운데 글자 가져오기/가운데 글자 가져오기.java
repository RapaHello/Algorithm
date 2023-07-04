class Solution {
    public String solution(String s) {
        String temp = "";
        char[] chars = s.toCharArray();

        int len = s.length();
        if (len % 2 == 0) {
            temp += String.valueOf(chars[len / 2 - 1] + String.valueOf(chars[len / 2]));
        } else {
            temp = String.valueOf(chars[len / 2]);
        }
        return temp;
    }
}