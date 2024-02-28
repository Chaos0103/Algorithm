import java.util.HashMap;
import java.util.Map;

class Solution {

    private int count;

    private void comb(int[] arr, boolean[] isVisited, int start, int depth, int r) {
        if (depth == r) {
            int n = 1;
            for (int i = 0; i < arr.length; i++) {
                if (isVisited[i]) {
                    n *= arr[i] + 1;
                }
            }
            count += (n - 1);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                comb(arr, isVisited, i + 1, depth + 1, r);
                isVisited[i] = false;
            }
        }
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();
        for (String[] data : clothes) {
            int count = clothesMap.getOrDefault(data[1], 0);
            clothesMap.put(data[1], count + 1);
        }

        count = 0;
        int[] arr = clothesMap.values().stream()
            .mapToInt(Integer::intValue)
            .toArray();

        comb(arr, new boolean[arr.length], 0, 0, arr.length);

        return count;
    }
}