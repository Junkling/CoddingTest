import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int result1 = 0;
    static int result2 = 0;
    static int result3 = 0;
    static boolean[][] visit;

    static StringBuilder sb = new StringBuilder();

    static class P {
        int r, c;

        public P(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(new P(0, 0), new P(N, N), N);
        sb.append(result1).append('\n').append(result2).append('\n').append(result3);
        System.out.println(sb);
    }

    static void search(P start, P end, int N) {
        int n = map[start.r][start.c];
        if (N==1) {
            if (n == -1) result1++;
            if (n == 0) result2++;
            if (n == 1) result3++;
            return;
        }
        if (check(start, end , n)) {
            if (n == -1) result1++;
            if (n == 0) result2++;
            if (n == 1) result3++;
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                search(new P((start.r + (N/3 * i)), (start.c + (N/3 * j))), new P((start.r + (N/3 * (i + 1))), (start.c + (N/3 * (j + 1)))),N/3);
            }
        }
    }

    static boolean check(P start, P end, int n) {
        for (int i = start.r; i < end.r; i++) {
            for (int j = start.c; j < end.c; j++) {
                if (map[i][j] != n) return false;
            }
        }
        return true;
    }
}
