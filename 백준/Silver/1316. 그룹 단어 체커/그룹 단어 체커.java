import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean isGroupWord(String target) {
        boolean[] isChecked = new boolean[26];
        char prev = target.charAt(0);
        isChecked[prev - 'a'] = true;

        char[] arr = target.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            if (prev == arr[i]) {
                continue;
            }
            if (isChecked[arr[i] - 'a']) {
                return false;
            }
            prev = arr[i];
            isChecked[arr[i] - 'a'] = true;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            result += isGroupWord(word) ? 1 : 0;
        }
        System.out.println(result);
    }
}