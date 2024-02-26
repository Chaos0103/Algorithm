class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        for (String skillTree : skill_trees) {
            int index = 0;
            boolean flag = true;
            for (int i = 0; i < skillTree.length(); i++) {
                String c = skillTree.substring(i, i + 1);
                if (skill.contains(c) && !skill.substring(index, index + 1).equals(c)) {
                    flag = false;
                    break;
                } else if (skill.contains(c) && skill.substring(index, index + 1).equals(c)) {
                    index++;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}