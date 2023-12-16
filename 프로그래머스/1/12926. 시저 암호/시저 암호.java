class Solution {
    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                builder.append(arr[i]);
                continue;
            }

            if ('a' <= arr[i] && arr[i] <= 'z') {
                char ch = (char) (((arr[i] - 'a' + n) % 26) + 'a');
                builder.append(ch);
            }

            if ('A' <= arr[i] && arr[i] <= 'Z') {
                char ch = (char) (((arr[i] - 'A' + n) % 26) + 'A');
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}