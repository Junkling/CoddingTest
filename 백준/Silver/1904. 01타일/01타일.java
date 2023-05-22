import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int roof = 0;
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        while (roof < input) {
            if (roof == 0) {
                answer = 1;
                q.offer(answer);
                roof++;
                continue;
            }
            if (roof == 1) {
                answer = 2;
                q.offer(answer);
                roof++;
                continue;
            }
            int poll = q.poll();
            int peek = q.peek();
            answer = (poll + peek)%15746;
            q.offer(answer);
            roof++;
        }
        System.out.println(answer);
    }

}
