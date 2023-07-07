import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] map;

    static class P {
        int row, col;

        public P(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        StringTokenizer st ;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] s = st.nextToken().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
//        System.out.println(Arrays.deepToString(map));

        dfs(new P(0, 0), new P(N, N), 0);
        System.out.println(sb);

    }

    static void dfs(P start, P end, int depth) {
        if (start.row == end.row && start.col == end.col) {
            sb.append(map[start.row][start.col]);
            return;
        }
        //다 같은숫자면 숫자 넣고 리턴
        if (check(start, end)) {
            sb.append(map[start.row][start.col]);
            return;
        }
        //4분할 해서 다시 dfs
        sb.append('(');
        P p1S = new P(start.row, start.col);
        P p1E = new P((start.row + end.row) / 2, (start.col + end.col) / 2);
        dfs(p1S, p1E, 1);
        P p2S = new P(start.row, (start.col + end.col) / 2);
        P p2E = new P((start.row + end.row) / 2, end.col);
        dfs(p2S, p2E, 2);
        P p3S = new P((start.row + end.row) / 2, start.col);
        P p3E = new P(end.row, (start.col + end.col) / 2);
        dfs(p3S, p3E, 3);
        P p4S = new P((start.row + end.row) / 2, (start.col + end.col) / 2);
        P p4E = new P(end.row, end.col);
        dfs(p4S, p4E, 4);
        sb.append(')');
    }

    static boolean check(P start, P end) {
        for (int i = start.row; i < end.row; i++) {
            for (int j = start.col; j < end.col; j++) {
                if(map[i][j]!=map[start.row][start.col]) return false;
            }
        }
        return true;
    }
}
