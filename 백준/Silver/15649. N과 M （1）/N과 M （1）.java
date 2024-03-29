import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < N; i++) {
            boolean[] visit= new boolean[N];
            visit[i] = true;
            String s = Integer.toString(arr[i]);
            bfs(s, visit, 1);
        }
    }

    static void bfs(String s, boolean[] visit, int depth) {
        if (depth == M) {
            System.out.println(s);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(visit[i]) continue;
            String add = " "+arr[i];
            visit[i] = true;
            bfs(s+add, visit, depth+1);
            visit[i] = false;
        }
    }
}