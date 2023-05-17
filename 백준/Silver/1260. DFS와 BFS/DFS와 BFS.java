import java.util.*;

public class Main {
    static boolean[] visitD;
    static boolean[] visitB;
    static ArrayList<ArrayList<Integer>> map;
    static String answerD = "";
    static String answerB = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int point = sc.nextInt();
        int line = sc.nextInt();
        int start = sc.nextInt();
        visitD = new boolean[point + 1];
        visitB = new boolean[point + 1];
        answerB += start;
        answerD += start;
        visitB[start] = true;
        visitD[start] = true;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= point; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < line; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            list.get(i1).add(i2);
            list.get(i2).add(i1);
        }
        for (int i = 1; i <= point; i++) {
            Collections.sort(list.get(i));
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        map = list;

        bfs(q);
        dfs(start);
        System.out.println(answerD);
        System.out.println(answerB);
    }

    static void bfs(Queue<Integer> q) {
        while (!q.isEmpty()) {
            Integer now = q.poll();
            ArrayList<Integer> arrayList = map.get(now);
            for (int i = 0; i < arrayList.size(); i++) {
                Integer next = arrayList.get(i);
                if (visitB[next]) continue;
                visitB[next] = true;
                answerB += " "+next;
                q.offer(next);
            }
        }

    }

    static void dfs(int now) {
        ArrayList<Integer> arrayList = map.get(now);
        for (int i = 0; i < arrayList.size(); i++) {
            Integer next = arrayList.get(i);
            if(visitD[next]) continue;
            visitD[next] = true;
            answerD += " "+next;
            dfs(next);
        }
    }
}
