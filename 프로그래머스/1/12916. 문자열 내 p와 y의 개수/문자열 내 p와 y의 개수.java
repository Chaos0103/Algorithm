class Solution {
    boolean solution(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'p') {
                count++;
            } 
            
            if (c == 'y') {
                count--;    
            }
        }

        return count == 0;
    }
}