import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            char[] arr = br.readLine().toCharArray();
            StringBuilder sb = new StringBuilder();

            int leftIndex = -1;
            for (int i = arr.length - 1; i > 0; i--) {
                if (arr[i] > arr[i - 1]) {
                    leftIndex = i - 1;
                    break;
                }
            }

            if (leftIndex < 0) {
                for (char c : arr) {
                    sb.append(c);
                }
                System.out.println(sb);
                continue;
            }

            int rightIndex = -1;
            for (int i = arr.length - 1; i > leftIndex; i--) {
                if (arr[leftIndex] < arr[i]) {
                    rightIndex = i;
                    break;
                }
            }

            //swap
            char temp = arr[leftIndex];
            arr[leftIndex] = arr[rightIndex];
            arr[rightIndex] = temp;

            char[] copy = new char[arr.length - leftIndex - 1];
            for (int i = leftIndex + 1; i < arr.length; i++) {
                copy[i - leftIndex - 1] = arr[i];
            }
            Arrays.sort(copy);
            for (int i = 0; i < arr.length; i++) {
                if (i > leftIndex) {
                    break;
                }
                sb.append(arr[i]);
            }
            sb.append(copy);
            System.out.println(sb);
        }
    }
}