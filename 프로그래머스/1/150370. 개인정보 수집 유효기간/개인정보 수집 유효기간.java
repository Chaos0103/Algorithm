import java.util.*;

class Solution {
    //오늘 날짜로 파기해야할 개인정보 번호들을 반환
    //모든 달은 28일까지 존재
    private static final Map<String, Integer> map = new HashMap<>();
    
    private void initMap(String[] terms) {
        for (String term : terms) {
            String[] arr = term.split(" ");
            map.put(arr[0], Integer.parseInt(arr[1]) * 28);
        }
    }
    
    private int toDays(String str) {
        String[] arr = str.split("\\.");
        int y = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int d = Integer.parseInt(arr[2]);
        return y * 12 * 28 + m * 28 + d;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        initMap(terms);
        
        int target = toDays(today);
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            int d = toDays(arr[0]) + map.get(arr[1]);
            if (target >= d) {
                list.add(i + 1);
            }
        }
        
        return list.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}