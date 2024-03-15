import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pwd = br.readLine();
        if (pwd.startsWith("0")) {
            System.out.println(0);
            return;
        }

        if (pwd.contains("00")) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[pwd.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        char prev = pwd.charAt(0);
        for (int i = 2; i <= pwd.length(); i++) {
            if (Integer.parseInt(pwd.substring(i - 1, i)) == 0) {
                if (prev > '2') {
                    System.out.println(0);
                    return;
                }
                dp[i] = dp[i - 2];
            } else {
                int now = Integer.parseInt(prev + pwd.substring(i - 1, i));
                dp[i] = 10 < now && now < 27 ? (dp[i - 1] + dp[i - 2]) % MOD : dp[i - 1];
            }
            prev = pwd.charAt(i - 1);
        }
        System.out.println(dp[pwd.length()]);//35
    }
}