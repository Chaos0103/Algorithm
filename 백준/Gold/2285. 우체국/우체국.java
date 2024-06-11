import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static class Node implements Comparable<Node> {
        public int distance;
        public int people;

        public Node(int distance, int people) {
            this.distance = distance;
            this.people = people;
        }

        @Override
        public int compareTo(Node o) {
            if (distance == o.distance) {
                return people - o.people;
            }
            return distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Node> nodes = new ArrayList<>();
        long totalPeople = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            Node node = new Node(distance, people);
            nodes.add(node);
            totalPeople += people;
        }

        Collections.sort(nodes);

        totalPeople++;
        long people = 0;
        for (Node node : nodes) {
            people += node.people;
            if (totalPeople / 2 <= people) {
                System.out.println(node.distance);
                break;
            }
        }
    }
}