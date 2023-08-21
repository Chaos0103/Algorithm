import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        //총 N마리의 폰켓몬 중에서 N/2마리를 가져가도 좋음
        //같은 종류의 폰켓몬은 같은 번호
        //최대한 다양한 종류의 폰켓몬을 가지길 원함
        int size = nums.length / 2;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }

        if (countMap.size() >= size) {
            return size;
        }

        return countMap.size();
    }
}