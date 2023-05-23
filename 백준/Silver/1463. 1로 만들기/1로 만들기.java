import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Num{
        int now, depth;

        public Num(int now, int depth) {
            this.now = now;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Num> q = new LinkedList<>();
        q.offer(new Num(n, 0));
        while (!q.isEmpty()) {
            Num poll = q.poll();
            if(poll.now>n) continue;
            if(poll.now==1){
                System.out.println(poll.depth);
                break;
            }
            if (poll.now % 2 == 0) {
                q.offer(new Num(poll.now / 2, poll.depth + 1));
            }
            if (poll.now % 3 == 0) {
                q.offer(new Num(poll.now / 3, poll.depth + 1));
            }
            q.offer(new Num(poll.now - 1, poll.depth + 1));
        }
    }

}
