import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private static class Node {
        public int index;
        public int x;
        public int y;

        public Node left;
        public Node right;

        public Node(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }

    private void pre(Node node, ArrayList<Integer> visited) {
        if (node == null) {
            return;
        }

        visited.add(node.index);
        pre(node.left, visited);
        pre(node.right, visited);
    }

    private void post(Node node, ArrayList<Integer> visited) {
        if (node == null) {
            return;
        }

        post(node.left, visited);
        post(node.right, visited);
        visited.add(node.index);
    }

    private void insert(Node root, Node node) {
        if (root.x > node.x) {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }

    private Node constructor(Node[] nodes) {
        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }

        return root;
    }

    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            Node node = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
            nodes[i] = node;
        }

        Arrays.sort(nodes, (a, b) -> (b.y - a.y));

        Node root = constructor(nodes);

        ArrayList<Integer> pre = new ArrayList<>();
        pre(root, pre);

        ArrayList<Integer> post = new ArrayList<>();
        post(root, post);

        int[][] result = new int[2][nodes.length];
        result[0] = pre.stream().mapToInt(Integer::intValue).toArray();
        result[1] = post.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}