class Solution {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();

        int index = 0;
        for (char c : s.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                builder.append(c);
                index = 0;
                continue;
            }

            if (index % 2 == 0) {
                builder.append(Character.toUpperCase(c));
            } else {
                builder.append(Character.toLowerCase(c));
            }
            index++;
        }
        
        return builder.toString();
    }
}