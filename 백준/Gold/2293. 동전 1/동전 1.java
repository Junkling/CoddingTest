import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int  sum = sc.nextInt();
        int[] coins = new int[n];
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
            for (int j = coins[i]; j <= sum; j++) {
                if(j<coins[i]) continue;

                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[sum]);

    }

}
