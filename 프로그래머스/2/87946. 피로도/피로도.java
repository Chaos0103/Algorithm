import java.util.*;

class Solution {
    
    private static final ArrayList<ArrayList<Integer>> comb = new ArrayList<>();
    
    private static void dfs(int[] arr, boolean[] isVisited, int depth) {
        if (depth == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int elem : arr) {
                temp.add(elem);
            }
            comb.add(temp);
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                arr[depth] = i;
                dfs(arr, isVisited, depth + 1);
                isVisited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        dfs(new int[dungeons.length], new boolean[dungeons.length], 0);
        
        int result = 0;
        for (List<Integer> arr : comb) {
            int temp = k;
            int count = 0;
            for (int index : arr) {
                if (temp < dungeons[index][0]) {
                    break;
                }
                
                temp -= dungeons[index][1];
                count++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}