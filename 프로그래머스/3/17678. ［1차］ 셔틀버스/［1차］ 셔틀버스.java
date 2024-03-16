import java.util.*;

class Solution {
    private int strToInt(String time) {
        String[] data = time.split(":");
        return Integer.parseInt(data[0]) * 60 + Integer.parseInt(data[1]);
    }
    
    private String intToStr(int time) {
        int hour = time / 60;
        int minute = time % 60;
        return String.format("%02d:%02d", hour, minute);
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);
        
        int index = 0;
        int busTime = strToInt("09:00");
        for(int count = 0; count < n; count++) {            
            for(int crew = 0; crew < m; crew++) {
                //크루 모두 탑승
                if (index == timetable.length) {
                    if (count < n - 1) {
                        int time = strToInt("09:00") + ((n - 1) * t);
                        return intToStr(time);
                    }
                    return intToStr(busTime);
                }
                
                int crewTime = strToInt(timetable[index]);
                if (crewTime > busTime) {
                    if (count == n - 1) {
                        int time = strToInt("09:00") + ((n - 1) * t);
                        return intToStr(time);
                    }
                    break;
                }
                index++;
            }
            busTime += t;
        }
        
        if (index == 0) {
            return intToStr(busTime - t);
        }
        
        int prevCrew = strToInt(timetable[index - 1]);
        int min = Math.min(prevCrew - 1, busTime - t);
        
        return intToStr(min);
    }
}