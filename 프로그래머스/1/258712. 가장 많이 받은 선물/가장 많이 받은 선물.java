import java.util.*;

class Solution {
    //목적: 다음 달에 누가 선물을 많이 받을지 예측
    //1. 서로 선물을 주고받은 기록이 존재: 더 많은 선물을 준 사람이 다음달에 선물을 하나 받음
    //2. 서로 주고받지 않거나, 주고받은 수가 같음: 선물 지수가 더 큰 사람이 다음달에 선물을 하나 받음
    //[선물지수]: 준 선물의 수 - 받은 선물의 수
    //3. 선물 지수도 같다면 선물을 주고받지 않음
    private static final Map<String, Integer> GIFT_POINT = new HashMap<>();
    
    private void calculateGiftPoint(String[] friends, String[] gifts) {
        for (String friend : friends) {
            int give = 0;
            int take = 0;
            for (String gift : gifts) {
                String[] arr = gift.split(" ");
                if (arr[0].equals(friend)) {
                    give++;
                }
                if (arr[1].equals(friend)) {
                    take++;
                }
            }
            GIFT_POINT.put(friend, give - take);
        }
    }
    
    public int solution(String[] friends, String[] gifts) {
        calculateGiftPoint(friends, gifts);
        
        Map<String, Integer> result = new HashMap<>();
        for (String friend : friends) {
            result.put(friend, 0);
        }
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String strA = friends[i] + " " + friends[j];
                String strB = friends[j] + " " + friends[i];
                int a = 0;
                int b = 0;
                for (String gift : gifts) {
                    if (gift.equals(strA)) {
                        a++;
                    }
                    if (gift.equals(strB)) {
                        b++;
                    }
                }
                String name = null;
                if (a < b) {
                    name = friends[j];
                } else if (a > b) {
                    name = friends[i];
                } else {
                    int ap = GIFT_POINT.get(friends[i]);
                    int bp = GIFT_POINT.get(friends[j]);
                    if (ap < bp) {
                        name = friends[j];
                    } else if (ap > bp) {
                        name = friends[i];
                    } else {
                        continue;
                    }
                }
                result.put(name, result.get(name) + 1);
            }
        }
        
        int answer = 0;
        for (int value : result.values()) {
            answer = Math.max(answer, value);
        }
        System.out.println(GIFT_POINT);
        return answer;
    }
}