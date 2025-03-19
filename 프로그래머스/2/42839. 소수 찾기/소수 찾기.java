import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        for (int len = 1; len <= numbers.length(); len++) {
            comb(numbers, new boolean[numbers.length()], len, 0, new StringBuilder(), set);
        }

        return set.size();
    }

    private void comb(String numbers, boolean[] isUsed, int len, int depth, StringBuilder sb, Set<Integer> set) {
        if (len == depth) {
            int num = Integer.parseInt(sb.toString());
            if (isPrime(num)) {
                set.add(num);
            }
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                sb.append(numbers.charAt(i));
                comb(numbers, isUsed, len, depth + 1, sb, set);
                sb.deleteCharAt(sb.length() - 1);
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