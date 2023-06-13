import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Integer> result = new LinkedList<>();
        Deque<Integer> q1 = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q1.offer(i);
            q2.offer(i);
        }

        for (int i = 0; i < m; i++) {
            result.offer(sc.nextInt());
        }


        int Min = 0;

        while (!result.isEmpty()) {
            int answer1 = 0;
            int answer2 = 0;

            Integer poll = result.poll();
            while (poll != q1.peek()) {
                q1.offerFirst(q1.pollLast());
                answer1++;
            }
            while (poll != q2.peek()) {
                q2.offerLast(q2.pollFirst());
                answer2++;
            }
            q1.poll();
            q2.poll();
            Min += (Math.min(answer1, answer2));
        }
        System.out.println(Min);
    }
}
