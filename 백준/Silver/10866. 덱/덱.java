import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<String> q = new LinkedList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push_front":
                    q.addFirst(st.nextToken());
                    break;
                case "push_back":
                    q.addLast(st.nextToken());
                    break;
                case "pop_front":
                    String f = q.isEmpty() ? "-1" : q.pollFirst();
                    sb.append(f).append('\n');
                    break;
                case "pop_back":
                    String b = q.isEmpty() ? "-1" : q.pollLast();
                    sb.append(b).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    String e = q.isEmpty() ? "1" : "0";
                    sb.append(e).append('\n');
                    break;
                case "front":
                    String f2 = q.isEmpty() ? "-1" : q.peekFirst();
                    sb.append(f2).append('\n');
                    break;
                case "back":
                    String b2 = q.isEmpty() ? "-1" : q.peekLast();
                    sb.append(b2).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
