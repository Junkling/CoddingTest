import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Position {
        int row, cal;

        public Position(int row, int cal) {
            this.row = row;
            this.cal = cal;
        }
    }

    static int R;
    static int C;
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static char[][] map;
    static char[][] allMap;
    static Queue<Position> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
            }
        }

        for (int i = 1; i < N; i++) {
            if (i % 2 == 0) {
                process();
            } else {
                allProcess();
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void allProcess() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'O';
                } else {
                    q.offer(new Position(i, j));
                }
            }
        }
    }

    public static void process() {
        while (!q.isEmpty()) {
            Position poll = q.poll();
            int r = poll.row;
            int c = poll.cal;
                map[r][c] = '.';
                for (int k = 0; k < 4; k++) {
                    int nRow = r + move[k][0];
                    int nCal = c + move[k][1];
                    if (!valid(nRow, nCal)) continue;
                    map[nRow][nCal] = '.';
            }
        }
    }

    public static boolean valid(int r, int c) {
        if (c > C - 1) return false;
        if (r > R - 1) return false;
        if (c < 0 || r < 0) return false;
        return true;
    }
}
