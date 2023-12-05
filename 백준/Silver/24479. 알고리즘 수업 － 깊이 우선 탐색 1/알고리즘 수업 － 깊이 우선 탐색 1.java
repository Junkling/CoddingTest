import java.util.*;

public class Main {
    static boolean[] visit;
    static int depth =1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] firstLine = new int[s.length];

        for (int i=0; i<s.length; i++) {
            firstLine[i] = Integer.parseInt(s[i]);
        }
        List<List<Integer>> map = new ArrayList<>();
        int[] result = new int[firstLine[0]];
        visit = new boolean[firstLine[0]];
        for (int i = 0; i < firstLine[0]; i++) {
            map.add(new ArrayList<>());
        }

        for(int i=0; i<firstLine[1]; i++){
            String[] s1 = scanner.nextLine().split(" ");
            Integer sPoint = Integer.parseInt(s1[0]);
            Integer ePoint = Integer.parseInt(s1[1]);
            map.get(sPoint - 1).add(ePoint - 1);
            map.get(ePoint - 1).add(sPoint - 1);
            }
//        System.out.println(Arrays.deepToString(map));

        for (int i = 0; i < firstLine[0]; i++) {
            Collections.sort(map.get(i));
        }
        dfs(firstLine[2]-1, map, result);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static void dfs(int start, List<List<Integer>> map, int[] result) {
        result[start] = depth;
        visit[start] = true;
        for (int i = 0; i < map.get(start).size(); i++) {
                if(visit[map.get(start).get(i)]) continue;
                depth++;
                dfs(map.get(start).get(i), map, result);
            }
        }
    }
