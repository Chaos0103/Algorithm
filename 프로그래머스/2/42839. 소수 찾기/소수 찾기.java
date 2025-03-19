import java.util.*;

class Solution {
    
    private final Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        for (int len = 1; len <= numbers.length(); len++) {
            comb(numbers, new boolean[numbers.length()], len, 0, "");    
        }
        
        return set.size();
    }
    
    private void comb(String numbers, boolean[] isUsed, int len, int depth, String result) {
        if (len == depth) {
            int num = Integer.parseInt(result);
            if (isPrime(num)) {
                set.add(num);
            }
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                comb(numbers, isUsed, len, depth + 1, result + numbers.substring(i, i + 1));
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
}