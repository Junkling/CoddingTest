import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            hip(sc.nextInt());
        }
        System.out.println(sb);
    }

    static void hip(int n) {
        if(n==0){
            print();
            return;
        }
        q.offer(n);
    }

    static void print() {
        if (q.isEmpty()) {
            sb.append(0).append('\n');
            return;
        }
        sb.append(q.poll()).append('\n');
    }
}
