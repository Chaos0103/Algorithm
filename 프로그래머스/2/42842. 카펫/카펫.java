class Solution {
    public int[] solution(int brown, int yellow) {
        for (int h = 1; h <= yellow; h++) {
            if (yellow % h > 0) {
                continue;
            }
            
            int w = yellow / h;
            int b = (w + h) * 2 + 4;
            if (b == brown) {
                return new int[]{w + 2, h + 2};
            }
        }
    
        return null;
    }
}