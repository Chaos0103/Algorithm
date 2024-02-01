class Solution {
    public int[] solution(long n) {
        StringBuilder builder = new StringBuilder(Long.toString(n));
        builder.reverse();
        char[] arr = builder.toString().toCharArray();
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = Character.getNumericValue(arr[i]);
        }
        return answer;
    }
}