import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        
        Set<String> set = new HashSet<>();
        for (String number : phoneBook) {
            for (int i = 0; i < number.length(); i++) {
                if (set.contains(number.substring(0, i))) {
                    return false;
                }
            }
            
            set.add(number);
        }
        
        return true;
    }
}