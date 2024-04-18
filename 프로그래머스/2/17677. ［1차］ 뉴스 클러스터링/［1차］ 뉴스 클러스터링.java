import java.util.*;

class Solution {
    //J(A, B): 두 집합의 교집합 크기 / 두 집합의 합집합 크기
    //A, B 모두 공집합인 경우 J(A, B) = 1
    //대소문자 구분하지 않는다.
    //2글자씩 끊을 때 특수문자가 포함되어 있다면 제외시킨다.
    private Map<String, Integer> toMultiSet(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2).toLowerCase();
            if (!Character.isAlphabetic(sub.charAt(0)) || !Character.isAlphabetic(sub.charAt(1))) {
                continue;
            }
            int count = map.getOrDefault(sub, 0);
            map.put(sub, count + 1);
        }
        return map;
    }
    
    public int solution(String str1, String str2) {
        Map<String, Integer> mapA = toMultiSet(str1);
        Map<String, Integer> mapB = toMultiSet(str2);
        
        if (mapA.size() == 0 && mapB.size() == 0) {
            return 65536;
        }
        
        Set<String> keySet = new HashSet<>();
        keySet.addAll(mapA.keySet());
        keySet.addAll(mapB.keySet());
        
        int same = 0;
        int union = 0;
        for (String key : keySet) {
            System.out.println(key);
            int aCount = mapA.getOrDefault(key, 0);
            int bCount = mapB.getOrDefault(key, 0);
            if (aCount > 0 && bCount > 0) {
                same += Math.min(aCount, bCount);
            }
            union += Math.max(aCount, bCount);
        }
        System.out.println(same);
        double result = (double) same / union;
        return (int) (result * 65536);
    }
}