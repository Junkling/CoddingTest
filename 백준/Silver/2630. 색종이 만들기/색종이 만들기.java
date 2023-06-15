import java.util.Scanner;

public class Main {
    static int[][] map;
    static int w = 0;
    static int b = 0;
    static class P {
        int row, cal;

        public P(int row, int cal) {
            this.row = row;
            this.cal = cal;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];

        P start = new P(0, 0);
        P end = new P(n, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dfs(start, end);
        System.out.println(w);
        System.out.println(b);
    }

    public static void dfs(P start, P end) {
        if(start.cal>= end.cal||start.row>=end.row) return;
        int s = map[start.row][start.cal];
        boolean aSame = true;
        for (int i = start.row; i < end.row; i++) {
            for (int j = start.cal; j < end.cal; j++) {
                if (map[i][j] != s) {
                    aSame = false;
                    break;
                }
            }
        }
        if (aSame) {
            if (s == 1) {
                b++;
            } else {
                w++;
            }
            return;
        }

            P n1S = new P(start.row, start.cal);
            P n1E = new P((end.row + start.row) / 2, (end.cal + start.cal) / 2);
            dfs(n1S, n1E);
            P n2S = new P(start.row, (end.cal + start.cal) / 2);
            P n2E = new P((end.row + start.row) / 2, end.cal);
            dfs(n2S, n2E);
            P n3S = new P((end.row + start.row) / 2, start.cal);
            P n3E = new P(end.row, (end.cal + start.cal) / 2);
            dfs(n3S, n3E);
            P n4S = new P((end.row + start.row) / 2, (end.cal + start.cal) / 2);
            P n4E = new P(end.row, end.cal);
            dfs(n4S, n4E);

    }
}
