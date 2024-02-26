import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private static class Edge implements Comparable<Edge> {
        public int distance;
        public int nodeA;
        public int nodeB;

        public Edge(int distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }

    public int[] parent = new int[100];
    public ArrayList<Edge> edges = new ArrayList<>();

    private int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    private void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public int solution(int n, int[][] costs) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] cost : costs) {
            edges.add(new Edge(cost[2], cost[0], cost[1]));
        }

        Collections.sort(edges);

        int result = 0;
        for (Edge edge : edges) {
            int cost = edge.distance;
            int a = edge.nodeA;
            int b = edge.nodeB;
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }
        
        return result;
    }
}