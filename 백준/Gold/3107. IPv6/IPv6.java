import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder builder = new StringBuilder();

        int count = 8;
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            if (ch == ':') {
                count--;
            }
        }
        if (arr[0] == ':') {
            builder.append("0000");
        }

        StringTokenizer hex = new StringTokenizer(str, ":", true);

        boolean flag = false;
        while (hex.hasMoreTokens()) {
            String token = hex.nextToken();
            if (!token.equals(":")) {
                int num = Integer.parseInt(token, 16);
                builder.append(String.format("%04x", num));
                flag = false;
                continue;
            }

            if (flag) {
                builder.append("0000:".repeat(count));
                flag = false;
                continue;
            }

            flag = true;
            builder.append(token);
        }

        if (arr[arr.length - 1] == ':') {
            builder.append("0000");
        }

        System.out.println(builder);
    }
}