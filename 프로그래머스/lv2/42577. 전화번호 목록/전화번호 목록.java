import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
       
        HashSet<String> store = new HashSet<>();

        for (String phone : phone_book) {
            for (int i = 1; i <= phone.length(); i++) {
                String sub = phone.substring(0, i);
                //수정
                if (store.contains(sub)) {
                    return false;
                }
            }
            store.add(phone);
        }
        return true;
    }
}