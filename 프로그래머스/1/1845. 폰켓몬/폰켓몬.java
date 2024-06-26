import java.util.*;

class Solution {
    //총 N마리중 N/2마리 가져갈 수 있음
    //같은 종류의 폰켓몬은 같은 번호
    //가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아 갯수를 반환
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
    
        int half = nums.length / 2;
        return set.size() < half ? set.size() : half;
    }
}