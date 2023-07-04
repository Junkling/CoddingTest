import java.util.Scanner;

public class Main {
    static int[] arr;
    static int[] math = new int[4];
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            math[i] = sc.nextInt();
        }
        dfs(arr[0], 1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }

    static void dfs(int n, int index) {
        if (index == N) {
            max = Math.max(max, n);
            min = Math.min(min, n);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (math[i] > 0) {
                math[i]--;
                switch (i) {
                    case 0: dfs(n + arr[index], index + 1); break;
                    case 1: dfs(n - arr[index], index + 1); break;
                    case 2: dfs(n * arr[index], index + 1); break;
                    case 3:
                        if (n < 0) {
                            int i1 = Math.abs(n) / arr[index];
                            dfs(i1 * (-1), index + 1);
                        }else {
                            dfs(n / arr[index], index + 1);
                        }
                        break;
                }
                math[i]++;
            }
        }
    }
}
