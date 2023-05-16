import java.util.*;

public class Main {
    static boolean[] visit;
    static int[] rank;
    static int depth = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int point = sc.nextInt();
        int line = sc.nextInt();
        int start = sc.nextInt();
        visit = new boolean[point + 1];
        rank = new int[point + 1];

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
            Collections.sort(list.get(i), Collections.reverseOrder());
        }

        dfs(list, start);
        for (int i = 1; i < rank.length; i++) {
            System.out.println(rank[i]);
        }

    }

    static void dfs(ArrayList<ArrayList<Integer>> list, int start) {
        visit[start] = true;
        rank[start] = depth;
        ArrayList<Integer> arrayList = list.get(start);
        for (Integer integer : arrayList) {
            if (visit[integer]) continue;
            depth++;
            dfs(list, integer);
        }
    }
}

