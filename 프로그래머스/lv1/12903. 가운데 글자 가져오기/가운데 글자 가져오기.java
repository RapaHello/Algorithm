class Solution {
    public String solution(String s) {
        String temp = "";
        int len = s.length();
        if (len % 2 == 0) {
            temp = s.substring(len / 2 - 1, len / 2 + 1);
        } else {
            temp = s.substring(len / 2, len / 2 + 1);
        }
        return temp;
    }
}