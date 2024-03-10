import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        
        Set<String> set = new HashSet<>();
        for (String phone : phoneBook) {
            for (int i = 0; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }   
            }
            set.add(phone);
        }
        
        return true;
    }
}