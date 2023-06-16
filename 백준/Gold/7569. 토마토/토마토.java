import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class P {
        int h, r, c, depth;


        public P(int h, int r, int c, int depth) {
            this.h = h;
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }

    static int[][] move;
    static int[][][] map;
    static int m;
    static int n;
    static int h;
    static int count;
    static int zeros = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        move = new int[][]{{0,1, 0}, {0,0, 1}, {0,-1, 0}, {0,0, -1}, {1, 0,0}, {-1, 0,0}};

        map = new int[h][n][m];
        Queue<P> q = new LinkedList<>();
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int nextInt = sc.nextInt();
                    map[k][i][j] = nextInt;
                    if (nextInt == 1) {
                        q.offer(new P(k,i, j, 0));
                    }
                    if (nextInt == 0) {
                        zeros++;
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            P p = q.poll();
            count = p.depth;
            for (int i = 0; i < 6; i++) {
                P nP = new P(p.h + move[i][0], p.r + move[i][1], p.c + move[i][2], p.depth + 1);
                if (!valid(nP)) continue;
                map[nP.h][nP.r][nP.c] = 1;
                zeros--;
                q.offer(nP);
            }
        }
        boolean f = true;

        int answer = 0;
        answer = zeros == 0 ? count : -1;
        System.out.println(answer);
    }

    public static boolean valid(P p) {
        if (p.r < 0 || p.r >= n) return false;
        if (p.c < 0 || p.c >= m) return false;
        if(p.h<0||p.h>=h) return false;
        if (map[p.h][p.r][p.c] != 0) return false;
        return true;
    }
}
