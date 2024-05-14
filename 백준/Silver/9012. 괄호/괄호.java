import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            char[] targets = br.readLine().toCharArray();

            int count = 0;
            for (char target : targets) {
                if (target == '(') {
                    count++;
                } else {
                    count--;
                    if (count < 0) {
                        break;
                    }
                }
            }

            if (count != 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}