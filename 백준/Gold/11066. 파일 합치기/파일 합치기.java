import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int question = sc.nextInt();
        for (int i = 0; i < question; i++) {
            int n = sc.nextInt();
            int[] page = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];
            int[] sum = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                page[j] = sc.nextInt();
                sum[j] = sum[j - 1] + page[j];
            }
            for (int k = 1; k <= n; k++) {
                for (int from = 1; from + k <= n; from++) {
                    int to = from + k;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int d = from; d < to; d++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][d] + dp[d + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }
            System.out.println(dp[1][n]);

        }
    }
}
