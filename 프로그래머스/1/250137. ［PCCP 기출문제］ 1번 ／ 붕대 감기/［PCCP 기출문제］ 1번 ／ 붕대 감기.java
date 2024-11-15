class Solution {
    //T초동안 붕대를 감는다. 1초마다 x만큼 체력을 회복
    //t초동안 붕대 감는걸 성공하면 y만큼 추가로 회복
    //최대 체력보다 커지는 것은 불가능
    //몬스터에게 공격당하면 붕대감기를 할 수 없고, 체력이 줄어듬
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        answer -= attacks[0][1];

        for (int i = 1; i < attacks.length; i++) {
            int term = attacks[i][0] - attacks[i - 1][0] - 1;
            answer += (term * bandage[1]);
            if (term / bandage[0] > 0) {
                answer += (term / bandage[0] * bandage[2]);
            }
            answer = Math.min(answer, health);
            
            answer -= attacks[i][1];
            if (answer <= 0) {
                return -1;
            }
        }


        
        return answer;
    }
}