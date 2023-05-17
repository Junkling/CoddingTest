import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[] visit;
    static int count = 0;
    static ArrayList<Queue<Integer>> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int point = sc.nextInt();
        int line = sc.nextInt();
        visit = new boolean[point + 1];

        ArrayList<Queue<Integer>> list1 = new ArrayList<>();

        for (int i = 0; i <= point; i++) {
            list1.add(new LinkedList<>() {
            });
        }
        for (int i = 0; i < line; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            list1.get(i1).offer(i2);
            list1.get(i2).offer(i1);
        }
        list = list1;

        dfs(1, list1);
        System.out.println(count);
    }

    static void dfs(int start, ArrayList<Queue<Integer>> list) {
        visit[start] = true;
        Queue<Integer> now = list.get(start);
        while (!now.isEmpty()){
            Integer next = now.poll();
            if(visit[next]) continue;
            count++;
            dfs(next,list);
        }

    }

}
