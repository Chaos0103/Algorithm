import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pwd = br.readLine();

        //시작이 0인 경우 해석 불가
        if (pwd.startsWith("0")) {
            System.out.println(0);
            return;
        }

        //DP 테이블 초기화
        int[] dp = new int[pwd.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= pwd.length(); i++) {
            //이전 숫자랑 현재 숫자로 두자리 수 만들기
            int now = Integer.parseInt(pwd.substring(i - 2, i));
            if (now == 10 || now == 20) {
                dp[i] = dp[i - 2];
            } else if (now % 10 == 0) {
                dp[pwd.length()] = 0;
                break;
            } else {
                dp[i] = 10 < now && now < 27 ? (dp[i - 1] + dp[i - 2]) % MOD : dp[i - 1];
            }
        }

        System.out.println(dp[pwd.length()]);
    }
}