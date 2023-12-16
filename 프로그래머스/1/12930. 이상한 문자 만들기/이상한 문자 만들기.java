class Solution {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();

        boolean isUpper = true;
        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                builder.append(c);
                isUpper = true;
            } else {
                if (isUpper) {
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }
                isUpper = !isUpper;
            }
        }

        return builder.toString();
    }
}