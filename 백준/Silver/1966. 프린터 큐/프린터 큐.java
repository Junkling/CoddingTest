import java.util.*;

public class Main {
    static class P {
        int x, index;
        public P(int x, int index) {
            this.x = x;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Queue<P> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int j = 0; j < N; j++) {
                int x = sc.nextInt();
                q.offer(new P(x, j));
                pq.offer(x);
            }
            process(pq, q, M);
        }
    }

    public static void process(PriorityQueue<Integer> pq, Queue<P> q, int M) {
        int count = 0;
        while (!q.isEmpty()) {
            Integer Max = pq.peek();
            P poll = q.poll();
            if (Max != poll.x) {
                q.offer(poll);
            } else {
                count++;
                pq.poll();
                if (poll.index == M) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }
}
