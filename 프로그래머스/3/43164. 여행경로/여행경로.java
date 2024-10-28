import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<String> list;
    private boolean[] isVisited;

    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        isVisited = new boolean[tickets.length];

        dfs(tickets, "ICN", "ICN", 0);

        //가능한 경로를 다 찾아서 정렬
        list.sort(null);

        return list.get(0).split(" ");
    }

    private void dfs(String[][] tickets, String from, String path, int depth) {
        if (depth == tickets.length) {
            list.add(path); //"ICN JFK HND IAD"로 저장
            return;
        }

        for (int i = 0; i < isVisited.length; i++) {
            //티켓을 사용하지 않음 && 출발지가 일치
            if (!isVisited[i] && from.equals(tickets[i][0])) {
                isVisited[i] = true; //티켓 사용 처리
                //티켓 도착지를 출발지로 변경, 경로에 도착지 추가
                dfs(tickets, tickets[i][1], path + " " + tickets[i][1], depth + 1);
                isVisited[i] = false; //티켓 미사용처리
            }
        }
    }
}