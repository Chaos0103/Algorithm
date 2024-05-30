import java.util.*;

class Solution {
    //1. set에 nums를 삽입
    //2. set의 크기와 nums.length/2의 크기를 비교
    //2-1. set의 크기가 크거나 같다면 nums.length 반환
    //2-2. set의 크기가 작다면 set의 크기 반환
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        return set.size() < nums.length / 2 ? set.size() : nums.length / 2;
    }
}