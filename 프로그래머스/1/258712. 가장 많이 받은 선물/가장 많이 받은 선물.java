import java.util.*;

class Solution {
    //두 사람이 선물은 주고 받은 기록이 있을때: 선물 보낸 횟수가 적은 사람이 많은 사람에게 보냄
    //두 사람이 선물은 주고 받은 횟수가 같을때: 선물 지수가 작은 사람이 큰 사람에게 보냄
    //선물 지수 = 보낸 선물 수 - 받은 선물 수
    //선물 지수도 같으면 선물을 주고 받지 않음
    //result: 선물을 가장 많이 받을 친구가 받는 선물의 수
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            indexMap.put(friends[i], i);
        }

        int[][] arr = new int[friends.length][friends.length];
        int[] scores = new int[friends.length];
        for (String gift : gifts) {
            String[] names = gift.split(" ");
            int give = indexMap.get(names[0]);
            int take = indexMap.get(names[1]);
            arr[give][take]++;
            scores[give]++;
            scores[take]--;
        }

        int answer = 0;
        for (int i = 0; i < friends.length; i++) {
            int count = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j) {
                    continue;
                }

                if (arr[i][j] > arr[j][i]) {
                    count++;
                } else if (arr[i][j] == arr[j][i] && scores[i] > scores[j]) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}