import java.util.*;

class Combination {

    private int n;
    private int r;
    private int[] now; // 현재 조합
    private ArrayList<ArrayList<Node>> result; // 모든 조합

    public ArrayList<ArrayList<Node>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Node>>();
    }

    public void combination(ArrayList<Node> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Node> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}
class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {

    public static int n, m;
    public static int[][] graph;
    public static ArrayList<Node> blank = new ArrayList<>();
    public static ArrayList<Node> wall = new ArrayList<>();
    public static ArrayList<Node> virus = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = sc.nextInt();
                if (num == 0) {
                    blank.add(new Node(i, j));
                } else if (num == 1) {
                    wall.add(new Node(i, j));
                } else {
                    virus.add(new Node(i, j));
                }
            }
        }

        Combination combination = new Combination(blank.size(), 3);
        combination.combination(blank, 0, 0, 0);
        ArrayList<ArrayList<Node>> result = combination.getResult();

        int maxValue = 0;
        for (ArrayList<Node> newWall : result) {
            graph = new int[8][8];
            for (Node pos : newWall) {
                graph[pos.getX()][pos.getY()] = 1;
            }
            for (Node pos : wall) {
                graph[pos.getX()][pos.getY()] = 1;
            }

            for (Node node : virus) {
                dfs(node.getX(), node.getY());
            }

            int count = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (graph[x][y] == 0) {
                        count++;
                    }
                }
            }
            maxValue = Math.max(maxValue, count);
        }

        System.out.println(maxValue);
    }

    private static void dfs(int x, int y) {
        if (x < 0 || n <= x || y < 0 || m <= y) {
            return;
        }
        if (graph[x][y] == 0) {
            graph[x][y] = 2;
            dfs(x + 1, y);
            dfs(x - 1, y);
            dfs(x, y + 1);
            dfs(x, y - 1);
        }
    }
}