import java.util.Scanner;

public class Main {
    static int[] arr;
    static int M;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < N; i++) {
            String s = Integer.toString(arr[i]);
            bfs(i, 1, s);
        }
    }

    static void bfs(int start, int depth, String s) {
        if (depth == M) {
            System.out.println(s);
            return;
        }
        if (start == N) {
            return;
        }
        for (int i = start+1; i < N; i++) {
            bfs(i, depth+1, s + " " + arr[i]);
        }
    }
}
