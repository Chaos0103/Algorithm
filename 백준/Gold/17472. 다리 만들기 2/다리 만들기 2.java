import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

class Path {
    private Point start;
    private Point end;
    private int startNumber;
    private int endNumber;

    public Path(Point start, Point end, int startNumber, int endNumber) {
        this.start = start;
        this.end = end;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return startNumber == path.startNumber && endNumber == path.endNumber && Objects.equals(start, path.start) && Objects.equals(end, path.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, startNumber, endNumber);
    }
}

public class Main {

    private static int n, m;
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static ArrayList<Path> paths = new ArrayList<>();
    private static ArrayList<Integer> select = new ArrayList<>();
    private static int result = Integer.MAX_VALUE;
    private static int islandNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][m];
        int count = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, visited, count);
                    count++;
                    islandNumber++;
                }
            }
        }

        findPath();

        for (int i = 1; i <= paths.size(); i++) {
            combination(0, paths.size(), i);
        }

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y, boolean[][] visited, int num) {
        map[x][y] = num;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (map[nx][ny] == 1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, visited, num);
            }
        }
    }

    private static void combination(int start, int pathNumber, int r) {
        if (r == 0) {
            shortestPath();
            return;
        }
        for (int i = start; i < pathNumber; i++) {
            select.add(i);
            combination(i + 1, pathNumber, r - 1);
            select.remove(select.size() - 1);
        }
    }

    private static void findPath() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    connect(i, j, map[i][j]);
                }
            }
        }
    }

    private static void connect(int x, int y, int num) {
        Point start = new Point(x, y);

        if (x - 1 >= 0 && map[x - 1][y] == 0) {
            int cnt = 0;
            int dx = x - 1, dy = y;
            while (map[dx][dy] == 0) {
                cnt++;
                dx--;
                if (dx < 0) {
                    cnt = 0;
                    break;
                }
            }

            if (cnt >= 2) {
                Path path = new Path(start, new Point(dx, dy), num, map[dx][dy]);
                Path conversion = new Path(new Point(dx, dy), start, map[dx][dy], num);

                if (!paths.contains(conversion)) {
                    paths.add(path);
                }
            }

        }

        if (y + 1 < m && map[x][y + 1] == 0) {
            int cnt = 0;
            int dx = x, dy = y + 1;
            while (map[dx][dy] == 0) {
                cnt++;
                dy++;

                if (dy >= m) {
                    cnt = 0;
                    break;
                }
            }

            if (cnt >= 2) {
                Path path = new Path(start, new Point(dx, dy), num, map[dx][dy]);
                Path conversion = new Path(new Point(dx, dy), start, map[dx][dy], num);

                if (!paths.contains(conversion)) {
                    paths.add(path);
                }
            }
        }

        if (x + 1 < n && map[x + 1][y] == 0) {
            int cnt = 0;
            int dx = x + 1, dy = y;
            while (map[dx][dy] == 0) {
                cnt++;
                dx++;

                if (dx >= n) {
                    cnt = 0;
                    break;
                }
            }

            if (cnt >= 2) {
                Path path = new Path(start, new Point(dx, dy), num, map[dx][dy]);
                Path conversion = new Path(new Point(dx, dy), start, map[dx][dy], num);

                if (!paths.contains(conversion)) {
                    paths.add(path);
                }
            }
        }

        if (y - 1 >= 0 && map[x][y - 1] == 0) {
            int cnt = 0;
            int dx = x, dy = y - 1;
            while (map[dx][dy] == 0) {
                cnt++;
                dy--;
                if (dy < 0) {
                    cnt = 0;
                    break;
                }
            }

            if (cnt >= 2) {
                Path path = new Path(start, new Point(dx, dy), num, map[dx][dy]);
                Path conversion = new Path(new Point(dx, dy), start, map[dx][dy], num);

                if (!paths.contains(conversion)) {
                    paths.add(path);
                }
            }
        }
    }

    private static void shortestPath() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= islandNumber + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < select.size(); i++) {
            int start = paths.get(select.get(i)).getStartNumber();
            int end = paths.get(select.get(i)).getEndNumber();
            list.get(start).add(end);
            list.get(end).add(start);
        }

        boolean[] visited = new boolean[islandNumber + 2];
        DFS(list, 2, visited);

        for (int i = 2; i < visited.length; i++) {
            if (!visited[i]) {
                return;
            }
        }

        int total = 0;
        for (Integer integer : select) {
            int startX = paths.get(integer).getStart().x;
            int startY = paths.get(integer).getStart().y;
            int endX = paths.get(integer).getEnd().x;
            int endY = paths.get(integer).getEnd().y;

            if (startX == endX) {
                total += (endY - startY - 1);
            } else if (startY == endY) {
                total += (endX - startX - 1);
            }
        }

        result = Math.min(result, total);
    }

    private static void DFS(ArrayList<ArrayList<Integer>> list, int start, boolean[] visited) {
        visited[start] = true;

        for (int i : list.get(start)) {
            if (!visited[i]) {
                DFS(list, i, visited);
            }
        }
    }
}