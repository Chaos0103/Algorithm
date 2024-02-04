import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();

        Arrays.sort(arr);

        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]);
        }
        return builder.toString();
    }
}