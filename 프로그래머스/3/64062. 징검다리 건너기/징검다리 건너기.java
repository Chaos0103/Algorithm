class Solution {
    //한 번 밟을 때마다 디딤돌의 숫자는 1씩 감소
    //디딤돌의 숫자가 0이 되면 더 이상 밟을 수 없음 -> 다음 디딤돌로 한번에 여러칸을 건너 뛸 수 있음
    //무조건 가장 가까운 디딤돌로만 건너뛸 수 있음
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200_000_000;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int stone : stones) {
                int diff = stone - mid;
                if (diff <= 0) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == k) {
                    break;
                }
            }

            if (count == k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}