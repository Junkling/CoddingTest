import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static class P {
        int r, c, depth;

        public P(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }

    static int[][] map;

    static int count = 0;
    static int x = 0;

    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int cal;
    static int row;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cal = sc.nextInt();
        row = sc.nextInt();
        map = new int[row][cal];

        Queue<P> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cal; j++) {
                int nextInt = sc.nextInt();
                map[i][j] = nextInt;
                if (nextInt == 1) {
                    P p = new P(i, j, 0);
                    q.offer(p);
                } else if (nextInt == 0) {
                    x++;
                }
            }
        }
        bfs(q);

        int result = x == 0 ? count : -1;
        System.out.println(result);

    }

    public static void bfs(Queue<P> q) {
        while (!q.isEmpty()) {
            P p = q.poll();
            count = p.depth;
            for (int i = 0; i < 4; i++) {
                P nP = new P(p.r + move[i][0], p.c + move[i][1], p.depth + 1);
                if (!valid(nP)) continue;
                x--;
                map[nP.r][nP.c] = 1;
                q.offer(nP);
            }
        }
    }

    public static boolean valid(P p) {
        if (p.c < 0 || p.c >= cal) return false;
        if (p.r < 0 || p.r >= row) return false;
        if (map[p.r][p.c] != 0) return false;
        return true;
    }

}
