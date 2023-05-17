import java.util.*;

public class Main {
    static boolean[] visit;
    static int count=1;
    static int[] rank;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int point = sc.nextInt();
        int line = sc.nextInt();
        int start = sc.nextInt();
        rank = new int[point + 1];
        visit = new boolean[point + 1];

        ArrayList<PriorityQueue<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= point; i++) {
            list.add(new PriorityQueue<>(Comparator.reverseOrder()));
        }
        for (int i = 0; i < line; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            list.get(i1).offer(i2);
            list.get(i2).offer(i1);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            Integer now = q.poll();
            rank[now] = count;
            count++;
            PriorityQueue<Integer> qQ = list.get(now);
            while (!qQ.isEmpty()) {
                Integer next = qQ.poll();
                if (visit[next]) continue;
                q.offer(next);
                visit[next] = true;
            }
        }

        for (int i = 1; i < rank.length; i++) {
            System.out.println(rank[i]);
        }


    }
}
