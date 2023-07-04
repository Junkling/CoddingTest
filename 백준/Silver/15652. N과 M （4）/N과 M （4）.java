import java.util.Scanner;

public class Main {
    static int[] arr;
    static int N;
    static int M;

    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        sb = new StringBuilder();
        dfs(1, 0);
        System.out.println(sb);

    }

    static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]);
                if (i == M - 1) {
                    sb.append('\n');
                    continue;
                }
                sb.append(' ');
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
