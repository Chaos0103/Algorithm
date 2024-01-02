class Solution {
    public int solution(String s) {
        int answer = 1000;
        int length = s.length();

        if (length == 1) {
            return 1;
        }

        for (int step = 1; step <= (length / 2); step++) {
            StringBuilder builder = new StringBuilder();
            String prev = s.substring(0, step);
            int count = 1;
            for (int i = step; i <= length; i += step) {
                String target;
                if (i + step >= length) {
                    target = s.substring(i);
                } else {
                    target = s.substring(i, i + step);
                }

                if (prev.equals(target)) {
                    count++;
                    continue;
                }

                if (count > 1) {
                    builder.append(count);
                }
                builder.append(prev);
                prev = target;
                count = 1;
            }

            if (count > 1) {
                builder.append(count);
            }
            builder.append(prev);

            answer = Math.min(answer, builder.length());
        }

        return answer;
    }
}