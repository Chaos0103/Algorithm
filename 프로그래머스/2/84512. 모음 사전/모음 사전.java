import java.util.*;

class Solution {
    
    private static final Set<String> set = new HashSet<>();
    
    private void dfs(char[] arr, String ans, int depth) {
        if (depth == arr.length) {
            set.add(ans);
            return;
        }
        
        set.add(ans);
        for (int i = 0; i < arr.length; i++) {
            dfs(arr, ans + arr[i], depth + 1);
        }
    }
    
    public int solution(String word) {
        char[] arr = "AEIOU".toCharArray();
        
        dfs(arr, "", 0);
        
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        
        return list.indexOf(word);
    }
}