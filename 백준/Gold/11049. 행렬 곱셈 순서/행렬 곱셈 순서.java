import java.util.Scanner;

public class Main {

    static int[][] dp;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N][N];
        map = new int[N][2];
        for (int i = 0; i < N; i++) {
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j + i < N; j++) {
                for (int k = j; k < j + i; k++) {
                    int x = dp[j][k] + dp[k + 1][j + i] + map[j][0] * map[k][1] * map[j + i][1];
                    dp[j][j + i] = Math.min(dp[j][j + i], x);
                }
            }
        }
        System.out.println(dp[0][N - 1]);
    }
}
