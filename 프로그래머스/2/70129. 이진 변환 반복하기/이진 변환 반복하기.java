class Solution {

    private int removeZero(String binary) {
        int count = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
    
    public int[] solution(String s) {
        int[] answer = {0, 0};

        while (!s.equals("1")) {
            int length = removeZero(s);
            answer[1] += s.length() - length;
            s = Integer.toString(length, 2);
            answer[0]++;
        }

        return answer;
    }
}