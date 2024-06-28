import java.util.*;

class Solution {
    private static class Process {
        public int index;
        public int priority;
        
        public Process (int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Process(i, priorities[i]));
        }
        
        Arrays.sort(priorities);
        
        int count = 0;
        int index = priorities.length - 1;
        while (!q.isEmpty()) {
            Process p = q.poll();
            if (p.priority == priorities[index]) {
                count++;
                index--;
                if (p.index == location) {
                    break;
                }
            } else {
                q.add(p);
            }
        }
        
        return count;
    }
}