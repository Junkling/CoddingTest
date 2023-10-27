import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] split = skill.split("");
        for (String str : skill_trees) {
            Queue<String> q = new LinkedList<>();
            for (int i = 0; i < str.length(); i++) {
                String s = String.valueOf(str.charAt(i));
                if (skill.contains(s)) {
                    q.offer(s);
                }
            }
            for (int j = 0; j < split.length; j++) {
                if (q.isEmpty()) {
                    answer++;
                    break;
                }
                if (q.peek().equals(split[j])) {
                    q.poll();
                } else {
                    break;
                }
                if (q.isEmpty()) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}