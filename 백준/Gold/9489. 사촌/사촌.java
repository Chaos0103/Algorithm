import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Node {
        public int parent;
        public List<Integer> children;

        public Node(int parent) {
            this.parent = parent;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (n == 0 && k == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            int targetIndex = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == k) {
                    targetIndex = i;
                }
            }

            int[] parent = createParent(arr);
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (parent[i] != parent[targetIndex] && parent[i] != -1 && parent[parent[i]] == parent[parent[targetIndex]]) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    private static int findGrandParent(Map<Integer, Node> tree, int k) {
        Node node = tree.get(k);
        int parent = -1;
        for (int i = 0; i < 2; i++) {
            parent = node.parent;
            if (parent == 0) {
                return -1;
            }
            node = tree.get(parent);
        }
        return parent;
    }

    private static void initTree(int[] arr, Map<Integer, Node> tree) {
        tree.put(arr[0], new Node(0));
        int parentIndex = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 < arr[i]) {
                parentIndex++;
            }
            Node node = tree.get(arr[parentIndex]);
            node.children.add(arr[i]);
            tree.put(arr[i], new Node(arr[parentIndex]));
        }
    }

    private static int[] createParent(int[] arr) {
        int[] parent = new int[arr.length];
        parent[0] = -1;
        int parentIndex = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 < arr[i]) {
                parentIndex++;
            }
            parent[i] = parentIndex;
        }
        return parent;
    }
}