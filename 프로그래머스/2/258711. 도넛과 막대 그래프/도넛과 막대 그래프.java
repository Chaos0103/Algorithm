import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    //도넛 모양 그래프: n개의 정점과 n개의 간선 -> 사이클 형성
    //막대 모양 그래프: n개의 정점과 n-1개의 간선 -> 일자로 이동
    //8자 모양 그래프: 2n+1개의 정점과 2n+2개의 간선
    private static final List<List<Integer>> graphs = new ArrayList<>();

    private int findNodeCount(int[][] edges) {
        int value = 0;
        for (int[] edge : edges) {
            for (int node : edge) {
                value = Math.max(value, node);
            }
        }
        return value;
    }

    public int[] solution(int[][] edges) {
        int nodeCount = findNodeCount(edges);

        for (int i = 0; i <= nodeCount; i++) {
            graphs.add(new ArrayList<>());
        }

        int[] inDegree = new int[nodeCount + 1];
        for (int[] edge : edges) {
            graphs.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        int add = 0;
        for (int i = 1; i <= nodeCount; i++) {
            if (inDegree[i] == 0 && graphs.get(i).size() >= 2) {
                add = i;
            }
        }

        int[] answer = new int[]{add, 0, 0, 0};

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[nodeCount + 1];
        for (int start : graphs.get(add)) {
            int node = 1;
            int line = 0;
            isVisited[start] = true;
            q.offer(start);
            while (!q.isEmpty()) {
                int now = q.poll();
                line += graphs.get(now).size();
                for (int i = 0; i < graphs.get(now).size(); i++) {
                    int next = graphs.get(now).get(i);
                    if (!isVisited[next]) {
                        isVisited[next] = true;
                        node++;
                        q.offer(next);
                    }
                }
            }
            if (node == line) {
                answer[1]++;
            } else if (node - 1 == line) {
                answer[2]++;
            } else if (node + 1 == line) {
                answer[3]++;
            }
        }

        return answer;
    }
}