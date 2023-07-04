import java.util.Scanner;

public class Main {
    static int N;
    static int[] q;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        q = new int[N];
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int depth) {
        if (depth == N) {
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            q[depth] = i;
            if (!check(depth)) continue;
            dfs(depth + 1);
        }

    }

    static boolean check(int depth) {
        for (int i = 0; i < depth; i++) {
            if(q[depth]==q[i]) return false;
            if(Math.abs(depth-i)==Math.abs(q[depth]-q[i])) return false;
        }
        return true;
    }
}
