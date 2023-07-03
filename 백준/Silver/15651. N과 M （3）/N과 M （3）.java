import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        sb = new StringBuilder();
        bt(0);
        System.out.println(sb);
    }

    static void bt(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]);
                if (i == M - 1) continue;
                sb.append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            bt(depth + 1);
        }
    }
}
