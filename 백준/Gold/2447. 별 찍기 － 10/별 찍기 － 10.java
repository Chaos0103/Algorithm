import java.io.*;

public class Main {

    private static String[][] data;

    private static void star(int x, int y, int size) {
        if (size == 1) {
            data[x][y] = "*";
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    star(x + i * size / 3, y + j * size / 3, size / 3);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        data = new String[n][n];

        star(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(data[i][j] != null ? data[i][j] : " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}