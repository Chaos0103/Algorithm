import java.util.*;

class Solution {
    
    private static final ArrayList<ArrayList<Integer>> PREM_RESULT = new ArrayList<>();
    private static final int[] DISCOUNT_RATE = {9, 8, 7, 6};
    
    //할인율 경우의 수 반환
    private void prem(int[] out, int depth, int r) {
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < out.length; i++) {
                temp.add(out[i]);
            }
            PREM_RESULT.add(temp);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            out[depth] = DISCOUNT_RATE[i];
            prem(out, depth + 1, r);
        }
    }
    
    //유저별 구매 내역 계산
    private int calculatePayment(int[] user, int[] emoticons, ArrayList<Integer> discountRates) {
        int userRate = user[0];
        int userPrice = user[1];
        
        int totalPrice = 0;
        for(int i = 0; i < emoticons.length; i++) {
            //유저 기준 할인 비율보다 낮은 경우 건너뜀
            if (100 - discountRates.get(i) * 10 < userRate) {
                continue;
            }
            totalPrice += emoticons[i] / 10 * discountRates.get(i);
        }
        
        //가격보다 이모티콘 구매 가격이 크거나 같으면 플러스 가입
        //아니면 총 가격 반환
        return userPrice <= totalPrice ? 1 : totalPrice;
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        //할인율 경우의 수 구함
        prem(new int[emoticons.length], 0, emoticons.length);
        
        
        for(int i = 0; i < PREM_RESULT.size(); i++) {
            int[] result = new int[2];
            //이모티콘 할인 가격 계산
            ArrayList<Integer> discountRates = PREM_RESULT.get(i);
            
            //유저별 구매 내역 계산
            for (int j = 0; j < users.length; j++) {
                int[] user = users[j];
                
                int calculateResult = calculatePayment(user, emoticons, discountRates);
                
                if (calculateResult == 1) {
                    result[0]++;
                } else {
                    result[1] += calculateResult;
                }
            }
            
            if (answer[0] < result[0]) {
                answer = result;
            } else if (answer[0] == result[0] && answer[1] < result[1]) {
                answer = result;
            }
        }
        
        return answer;
    }
}