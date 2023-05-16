import java.util.*;

public class Main {
    static boolean[] visit;
    static int rank = 1;

    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int point = sc.nextInt();
        int line = sc.nextInt();
        int start = sc.nextInt();
        visit = new boolean[point + 1];
        result = new int[point + 1];

        ArrayList<PriorityQueue<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= point; i++) {
            list.add(new PriorityQueue<>());
        }
        for (int i = 0; i < line; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            list.get(i1).offer(i2);
            list.get(i2).offer(i1);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            if (visit[poll]) continue;
            visit[poll] = true;
            result[poll] = rank;
            rank++;
            PriorityQueue<Integer> integers = list.get(poll);
            while (!integers.isEmpty()) {
                Integer poll1 = integers.poll();
                if (visit[poll1]) continue;
                q.offer(poll1);
            }
        }
        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
