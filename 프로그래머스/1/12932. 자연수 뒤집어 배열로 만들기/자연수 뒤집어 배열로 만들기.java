class Solution {
    public int[] solution(long n) {
        String numberToString = String.valueOf(n);
        StringBuilder builder = new StringBuilder(numberToString);
        builder.reverse();

        int[] answer = new int[builder.length()];
        String number = builder.toString();
        for (int i = 0; i < builder.length(); i++) {
            char ch = number.charAt(i);
            answer[i] = Character.getNumericValue(ch);
        }
        return answer;
    }
}