import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i <= 50000; i++) {
            if (n == 1) {
                System.out.println(-1);
                break;
            }
            if (n % 5 == 0) {
                System.out.println(i + n / 5);
                break;
            }
            n -= 2;
        }
    }
}