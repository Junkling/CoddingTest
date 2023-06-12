import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        Queue<Integer> answer = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int l = 0;
        while (list.size() != 0) {
            l = (l + (k - 1)) % (list.size());
            answer.offer(list.get(l));
            list.remove(l);
        }
        String result = "<";
        while (!answer.isEmpty()) {
            result += answer.poll();
            String s = answer.isEmpty() ? ">" : ", ";
            result += s;
        }
        System.out.println(result);

    }
}
