import java.util.*;

class Solution {
    static ArrayList<String> list;
    static boolean[][] visit;
    static int x;
    static int y;
    
    class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String dirs) {
        visit = new boolean[11][11];

        int answer = 0;
        list = new ArrayList<>();
        x = 5;
        y = 5;

        for (int i = 0; i < dirs.length(); i++) {
            Location nowL = new Location(x, y);
            visit[x][y] = true;
            char ch = dirs.charAt(i);
            if (ch == 'U' && y < 10) {
                y++;
            }
            else if (ch == 'D' && y > 0) {
                y--;
            }
            else if (ch == 'R' && x < 10) {
                x++;
            }
            else if (ch == 'L' && x > 0) {
                x--;
            }else {
                continue;
            }
            String str1 ;
            String str2 ;
            str1 = ""+nowL.x + nowL.y + x + y;
            str2 = ""+x + y + nowL.x + nowL.y;

            if (check(str1, nowL)) {
                answer++;
            }

            list.add(str1);
            list.add(str2);
        }
        return answer;
    }

    boolean check(String str1 , Location now) {
        if (list.contains(str1)&&visit[now.x][now.y] && visit[x][y]) {
                return false;
        } else {
            return true;
        }
    }
}