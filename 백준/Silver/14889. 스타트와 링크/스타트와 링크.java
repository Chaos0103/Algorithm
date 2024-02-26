import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    //팀 구성 조합을 저장할 리스트
    private static final List<Set<Integer>> comb = new ArrayList<>();

    //팀 구성 조합을 생성하는 메서드
    //arr: 팀 번호가 담긴 배열
    //isVisited: 팀 번호 방문(사용) 여부를 확인하기 위한 배열
    //start: 팀 구성 조합을 시작할 인덱스
    //depth: 현재 조합된 팀 구성원 수
    private static void comb(int[] arr, boolean[] isVisited, int start, int depth) {
        //팀원 구성이 완료된 경우
        if (depth == arr.length / 2) {
            //팀 구성 리스트 생성
            Set<Integer> temp = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                if (isVisited[i]) {
                    temp.add(i);
                }
            }
            //팀 구성 조합 리스트에 추가
            comb.add(temp);
            return;
        }

        //다음 팀원 탐색
        for (int i = start; i < arr.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                comb(arr, isVisited, i + 1, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    //팀 구성원 능력치 차이를 구하는 메서드
    private static int getDiffTeamPerformance(Set<Integer> data, int[][] performances) {
        int startTeam = 0;
        int linkTeam = 0;
        for (int i = 0; i < performances.length; i++) {
            for (int j = 0; j < performances[i].length; j++) {
                if (data.contains(i) && data.contains(j)) {
                    startTeam += performances[i][j];
                } else if (!data.contains(i) && !data.contains(j)) {
                    linkTeam += performances[i][j];
                }
            }
        }
        return Math.abs(startTeam - linkTeam);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] performances = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                performances[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] arr = IntStream.range(0, n).toArray();
        comb(arr, new boolean[n], 0, 0);

        int result = Integer.MAX_VALUE;
        for (Set<Integer> data : comb) {
            int diff = getDiffTeamPerformance(data, performances);
            result = Math.min(result, diff);
        }

        System.out.println(result);
    }
}