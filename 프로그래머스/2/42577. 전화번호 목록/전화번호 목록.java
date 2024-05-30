import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        
        Set<String> set = new HashSet<>();
        for (String phoneNumber : phoneBook) {
            for (int i = 1; i < phoneNumber.length(); i++) {
                if (set.contains(phoneNumber.substring(0, i))) {
                    return false;
                }
            }
            set.add(phoneNumber);
        }
        
        return true;
    }
}