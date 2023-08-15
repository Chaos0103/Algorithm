class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int totalCount = brown + yellow;
        for (int height = 3; height <= (int) Math.sqrt(totalCount); height++) {
            int count = height * 2 + (totalCount / height) * 2 - 4;
            if (count == brown) {
                answer = new int[]{totalCount / height, height};
            }
        }
        return answer;
    }
}