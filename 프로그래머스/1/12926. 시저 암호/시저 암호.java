class Solution {
    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            builder.append(getMovedCharacter(c, n));
        }
        return builder.toString();
    }

    private char getMovedCharacter(char c, int n) {
        if (Character.isSpaceChar(c)) {
            return c;
        }
        char root = Character.isUpperCase(c) ? 'A' : 'a';
        return (char) ((c - root + n) % 26 + root);
    }
}