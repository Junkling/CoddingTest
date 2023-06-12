import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<String> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer command;

        for (int i = 0; i < n; i++) {
            command = new StringTokenizer(br.readLine(), " ");	// 문자열 분리
            switch (command.nextToken()) {
                case "push":
                    q.offer(command.nextToken());
                    break;
                case "pop":
                    String p = q.isEmpty() ? "-1" : q.poll();
                    sb.append(p).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    int e = q.isEmpty() ? 1 : 0;
                    sb.append(e).append('\n');
                    break;
                case "front":
                    String f = q.isEmpty() ? "-1" : q.peek();
                    sb.append(f).append('\n');
                    break;
                case "back":
                    String b = q.isEmpty() ? "-1" : q.peekLast();
                    sb.append(b).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
