import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    //    static int[][] map;
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;
    static boolean[][] useVisit;
    static int[][] map;

    static class P {
        int row, cal, depth;
        boolean use;

        public P(int row, int cal, int depth, boolean use) {
            this.row = row;
            this.cal = cal;
            this.depth = depth;
            this.use = use;
        }
    }

    static int answer = -1;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        visit = new boolean[N][M];
        useVisit = new boolean[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] s = sc.nextLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);

            }
        }
        Queue<P> q = new LinkedList<>();
        q.offer(new P(0, 0, 1, false));
        visit[0][0] = true;
        bfs(q);
        System.out.println(answer);
    }

    public static void bfs(Queue<P> q) {
        while (!q.isEmpty()) {
            P p = q.poll();
            if (p.row == N - 1 && p.cal == M - 1) {
                answer = p.depth;
                return;
            }
            for (int i = 0; i < 4; i++) {
                if (!valid(p.row + move[i][0], p.cal + move[i][1], p.use)) continue;
                if (map[p.row + move[i][0]][p.cal + move[i][1]] == 1 && p.use) continue;

                if (map[p.row + move[i][0]][p.cal + move[i][1]] == 1 && !p.use) {
                    P moved = new P(p.row + move[i][0], p.cal + move[i][1], p.depth + 1, true);
                    useVisit[moved.row][moved.cal] = true;
                    q.offer(moved);
                    continue;
                }
                P moved2 = new P(p.row + move[i][0], p.cal + move[i][1], p.depth + 1, p.use);
                if (p.use) {
                    useVisit[moved2.row][moved2.cal] = true;
                } else {
                    visit[moved2.row][moved2.cal] = true;
                }
                q.offer(moved2);
            }
        }
    }

    public static boolean valid(int r, int c, boolean use) {
        if (0 > r || r >= N) return false;
        if (0 > c || c >= M) return false;
        if (use) {
            if (useVisit[r][c]) return false;
        } else {
            if (visit[r][c]) return false;
        }
        return true;
    }
}
