import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[] visit = new boolean[101];
    static int[] map = new int[101];
    static int end = 100;
    static int answer = 0;
    static class P{
        int now, depth;

        public P(int now, int depth) {
            this.now = now;
            this.depth = depth;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int up = sc.nextInt();
        int down = sc.nextInt();
        for (int i = 1; i < map.length; i++) {
            map[i] = i;
        }
        for (int i = 0; i < up + down; i++) {
            int nextInt = sc.nextInt();
            map[nextInt] = sc.nextInt();
        }
        Queue<P> q = new LinkedList<>();
        q.offer(new P(map[1], 0));
        bfs(q);
        System.out.println(answer);

    }

    public static void bfs(Queue<P> q) {
        while (!q.isEmpty()) {
            P poll = q.poll();
            visit[poll.now] = true;
            if (poll.now == end) {
                answer = poll.depth;
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int moved = poll.now + i;
                if(!valid(moved)) continue;
                q.offer(new P(map[moved], poll.depth + 1));
            }
        }
    }

    public static boolean valid(Integer integer) {
        if(1>integer||integer>end) return false;
        if(visit[integer]) return false;
        return true;
    }
}
