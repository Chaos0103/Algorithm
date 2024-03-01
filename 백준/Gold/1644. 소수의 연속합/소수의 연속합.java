import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    private static int[] getPrimeNumbers(int n) {
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i]) {
                int j = 2;
                while (i * j <= n) {
                    arr[i * j] = false;
                    j += 1;
                }
            }
        }

        return IntStream.rangeClosed(2, n)
            .filter(i -> arr[i])
            .toArray();
    }

    private static int getCount(int[] primeNumbers, int target) {
        int result = 0;
        int intervalSum = 0;
        int end = 0;

        for (int primeNumber : primeNumbers) {
            while (intervalSum < target && end < primeNumbers.length) {
                intervalSum += primeNumbers[end];
                end++;
            }
            if (intervalSum == target) {
                result++;
            }
            intervalSum -= primeNumber;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] primeNumbers = getPrimeNumbers(n);

        int count = getCount(primeNumbers, n);

        System.out.println(count);
    }
}