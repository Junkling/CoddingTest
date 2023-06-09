import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][] map;
    static int n;
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int row;
    static int cal;
    static int answer = 0;
    static class P{
        int r, c,depth;

        public P(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        row = Integer.parseInt(split[0]);
        cal = Integer.parseInt(split[1]);
        n = Integer.parseInt(split[2]);
        map = new char[row][cal];
        boolean[][] visit = new boolean[row][cal];
        Queue<P> q = new LinkedList<>();
        q.offer(new P(row - 1, 0, 1));
        visit[row - 1][0] = true;
        for (int i = 0; i < row; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < cal; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        bfs(q, visit);
        System.out.println(answer);

    }

    public static void bfs(Queue<P>q ,boolean[][] visit) {
        while (!q.isEmpty()) {
            P poll = q.poll();
            if(poll.depth==n&&poll.r==0&&poll.c==cal-1){answer++; break;}
            for (int i = 0; i < 4; i++) {
                P movedP = new P(poll.r + move[i][0], poll.c + move[i][1], poll.depth + 1);
                if(!valid(movedP)) continue;
                if(visit[movedP.r][movedP.c]) continue;
                if(map[movedP.r][movedP.c]=='T') continue;
                visit[movedP.r][movedP.c] = true;
                q.offer(movedP);
                bfs(q,visit);
                visit[movedP.r][movedP.c] = false;
            }
        }
    }

    public static boolean valid(P p) {
        if(p.r>row-1) return false;
        if(p.c>cal-1) return false;
        if(p.r<0||p.c<0) return false;
        return true;
    }
}
