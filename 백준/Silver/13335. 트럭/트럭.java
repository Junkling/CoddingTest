import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int max = sc.nextInt();
        ArrayList<Integer> b = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(sc.nextInt());
        }
        int count = 0;
        int sum = 0;
        for (int i = 0; i < l; i++) {
            q2.offer(0);
        }
        while (!q2.isEmpty()) {
            count++;
            sum -= q2.poll();
            if (!q.isEmpty()) {
                if (sum + q.peek() <= max) {
                    sum += q.peek();
                    q2.offer(q.poll());
                }else {
                    q2.offer(0);
                }
            }
        }
        System.out.println(count);
    }
}
