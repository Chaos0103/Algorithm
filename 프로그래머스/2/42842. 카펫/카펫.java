class Solution {
    private int getBrown(int width, int height) {
        return (width * 2) + (height * 2) - 4;
    }

    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        for (int height = 3; height < total / 2; height++) {
            if (total % height != 0) {
                continue;
            }
            int width = total / height;
            int brownCount = getBrown(width, height);
            if (brownCount == brown) {
                return new int[]{width, height};
            }
        }
        return new int[]{};
    }
}