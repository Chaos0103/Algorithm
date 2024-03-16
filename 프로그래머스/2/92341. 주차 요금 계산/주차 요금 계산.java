import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private int timeToMinutes(String time) {
        String[] data = time.split(":");
        return (Integer.parseInt(data[0]) * 60) + Integer.parseInt(data[1]);
    }
    
    private Map<String, Integer> calulateParkTime(String[] records) {
        Map<String, Integer> result = new HashMap<>();
        
        Map<String, Integer> park = new HashMap<>();
        for (String record : records) {
            String[] data = record.split(" ");
            int minutes = timeToMinutes(data[0]);
            String carNum = data[1];
            String cmd = data[2];
            if (cmd.equals("IN")) {
                park.put(carNum, minutes);
            } else {
                int inTime = park.get(carNum);
                int time = result.getOrDefault(carNum, 0);
                result.put(carNum, time + (minutes - inTime));
                park.remove(carNum);
            }
        }
        
        if (!park.isEmpty()) {
            int endTime = timeToMinutes("23:59");
            for (String carNum : park.keySet()) {
                int inTime = park.get(carNum);
                int time = result.getOrDefault(carNum, 0);
                result.put(carNum, time + (endTime - inTime));                
            }
        }
        
        return result;
    }
    
    private int[] calculateFee(Map<String, Integer> parkTimes, int[] fees) {
        List<String> carNums = parkTimes.keySet().stream()
            .sorted()
            .collect(Collectors.toList());
        
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int minute = fees[2];
        int fee = fees[3];
        
        int[] result = new int[carNums.size()];
        for(int i = 0; i < carNums.size(); i++) {
            String carNum = carNums.get(i);
            int minutes = parkTimes.get(carNum);
            
            result[i] = defaultFee;
            if (minutes <= defaultTime) {
                continue;
            }
            
            int overMinutes = minutes - defaultTime;
            overMinutes /= minute;            
            if ((minutes - defaultTime) % minute > 0) {
                overMinutes += 1;
            }
            
            result[i] += overMinutes * fee;
        }
        
        return result;
    }
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkTimes = calulateParkTime(records);
        return calculateFee(parkTimes, fees);
    }
}