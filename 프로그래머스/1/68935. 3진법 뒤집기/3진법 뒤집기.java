class Solution {
    public int solution(int n) {
        String temp = Integer.toString(n, 3);
        StringBuilder builder = new StringBuilder();
        builder.append(temp);
        builder.reverse();
        return Integer.parseInt(String.valueOf(builder), 3);
    }
}