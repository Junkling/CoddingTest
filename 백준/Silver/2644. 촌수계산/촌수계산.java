import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int result = -1;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine());
        visit = new boolean[total+1];
        int[] question = new int[2];
        String[] s = scanner.nextLine().split(" ");
        for (int i = 0; i < 2; i++) {
            question[i] = Integer.parseInt(s[i]);
        }
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= total; i++) {
            map.add(new ArrayList<>());
        }

        int line = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < line; i++) {
            String[] s1 = scanner.nextLine().split(" ");
            int parent = Integer.parseInt(s1[0]);
            int child = Integer.parseInt(s1[1]);
            map.get(parent).add(child);
            map.get(child).add(parent);
        }
        dfs(map, question[0], question[1], 0);
        System.out.println(result);
    }

    static void dfs(List<List<Integer>> map, int start, int end, int count) {
//        System.out.println("start = " + start + " | end = " + end+ " | count = "+count);
        if(start == end){
            result = count;
            return;
        }
        visit[start] = true;
        for (int i =0; i<map.size(); i++) {
            if(i!=start) continue;
            for (int j = 0; j < map.get(i).size(); j++) {
                if (visit[map.get(i).get(j)]) continue;
                dfs(map, map.get(i).get(j), end, count + 1);
            }
        }
    }
}
