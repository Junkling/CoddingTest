import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int end;
    static int answer;

    static class Now {
        int now, depth;

        public Now(int now, int depth) {
            this.now = now;
            this.depth = depth;
        }
    }

    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        end = sc.nextInt();
        visit = new boolean[100001];
        Queue<Now> q = new LinkedList<>();
        q.offer(new Now(start, 0));
        visit[start] = true;
        process(q);
        System.out.println(answer);
    }

    public static void process(Queue<Now> q) {
        while (!q.isEmpty()) {
            Now p = q.poll();
//            System.out.println("now=" + p.now + "depth=" + p.depth);
            if (p.now == end) {
                answer = p.depth;
                return;
            }
            Now next1 = new Now(p.now - 1, p.depth + 1);
            if (valid(next1)) {
                q.offer(next1);
                visit[next1.now] = true;
            }

            Now next2 = new Now(p.now * 2, p.depth + 1);
            if (valid(next2)){
                q.offer(next2);
                visit[next2.now] = true;
            }

            Now next3 = new Now(p.now + 1, p.depth + 1);
            if (valid(next3)) {
                q.offer(next3);
                visit[next3.now] = true;
            }
        }
    }

    public static boolean valid(Now now) {
        if (0 > now.now || now.now > 100000) return false;
        if (visit[now.now]) return false;
        return true;
    }
}
