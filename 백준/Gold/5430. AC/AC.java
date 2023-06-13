import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer fun;
        StringTokenizer length;
        StringTokenizer nums;
        for (int i = 0; i < n; i++) {
            fun = new StringTokenizer(br.readLine());
            length = new StringTokenizer(br.readLine());
            nums = new StringTokenizer(br.readLine());


            int x = Integer.parseInt(length.nextToken());

            String f = fun.nextToken();
            String s = nums.nextToken();
            String[] split = s.substring(1, s.length() - 1).split(",");
            boolean r = false;
            boolean error = false;
            Deque<String> q = new LinkedList<>();
            Queue<Character> function = new LinkedList<>();
            for (int k = 0; k < f.length(); k++) {
                function.offer(f.charAt(k));
            }
            for (int j = 0; j < x; j++) {
                q.offer(split[j]);
            }

            while (!function.isEmpty()) {
                Character poll = function.poll();
                switch (poll) {
                    case 'R':
                        if (r) {
                            r = false;
                            continue;
                        }
                        if (!r) {
                            r = true;
                            continue;
                        }
                        break;
                    case 'D':
                        if (q.isEmpty()) {
                            error = true;
                            continue;
                        } else {
                            if (r) {
                                q.pollLast();
                                continue;
                            }
                            if (!r) {
                                q.pollFirst();
                                continue;
                            }
                        }
                        break;
                }
            }
            if (error) {
                sb.append("error").append('\n');
            } else {
                sb.append("[");
                while (!q.isEmpty()) {
                    if (r) {
                        sb.append(q.pollLast());
                    } else {
                        sb.append(q.pollFirst());
                    }
                    if (!q.isEmpty()) {
                        sb.append(",");
                    }
                }
                if(!error) sb.append("]").append('\n');
            }
        }
        System.out.println(sb);
    }
}
