import java.util.*;

class Solution {
    //목표: 미로를 탈출하기 위한 경로를 반환
    //(x, y) -> (r, c)
    //총 이동 거리 = k
    //같은 좌표를 두 번 이상 방문해도 됨
    //문자열이 사전 순으로 가장 빠른 경로로 탈출
    //d, l, r, u

    private static final int[][] d = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    private static final String s = "dlru";

    private int calc(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int[] p = new int[]{x, y};
        int[] e = new int[]{r, c};

        if (k - calc(p, e) < 0 || (k - calc(p, e)) % 2 == 1) {
            return "impossible";
        }

        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            for (int i = 0; i < 4; i++) {
                int[] next = new int[]{p[0] + d[i][0], p[1] + d[i][1]};

                if (!(0 < next[0] && next[0] <= n && 0 < next[1] && next[1] <= m)) {
                    continue;
                }
                
                if (calc(next, e) <= k) {
                    p = next;
                    sb.append(s.charAt(i));
                    break;
                }
            }
            k--;
        }

        return sb.toString();
    }
}