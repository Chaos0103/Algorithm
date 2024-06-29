import java.util.*;

class Solution {
    
    private static final Set<Integer> set = new HashSet<>();
    
    private void comb(String num, boolean[] isUsed, String ans, int depth, int length) {
        if (depth == length) {
            int temp = Integer.parseInt(ans);
            if (isPrime(temp)) {
                set.add(temp);    
            }
            return;
        }
        
        for (int i = 0; i < num.length(); i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                comb(num, isUsed, ans + num.substring(i, i + 1), depth + 1, length);
                isUsed[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(String numbers) {
        for (int i = 1; i <= numbers.length(); i++) {
            comb(numbers, new boolean[numbers.length()], "", 0, i);
        }
        System.out.println(set);
        return set.size();
    }
}