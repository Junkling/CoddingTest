import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static List<List<P>> list = new ArrayList<>();
    static int start;
    static int[] answer;

    static class P implements Comparable<P> {
        int point, w;

        public P(int point, int w) {
            this.point = point;
            this.w = w;
        }

        @Override
        public int compareTo(P p) {
            if (p.w < w) {
                return 1;
            } else if (p.w > w) {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int point = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        answer = new int[point + 1];

        for (int i = 0; i <= point; i++) {
            answer[i] = Integer.MAX_VALUE;
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(startPoint).add(new P(endPoint, w));
        }
        PriorityQueue<P> q = new PriorityQueue<P>();
        boolean check[] = new boolean[point + 1];
        answer[start] = 0;
        q.offer(new P(start, 0));
        while (!q.isEmpty()) {
            P p = q.poll();
            if(check[p.point]) continue;
            check[p.point] = true;
            for (P p1 : list.get(p.point)) {
                if(check[p1.point]) continue;
                if(answer[p1.point]<=answer[p.point]+p1.w)continue;
                answer[p1.point] = answer[p.point] + p1.w;
                q.offer(new P(p1.point, answer[p1.point]));
            }
        }
        for (int i = 1; i <= point; i++) {
            if (answer[i] == Integer.MAX_VALUE) {
                sb.append("INF").append('\n');
                continue;
            }
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);
    }
}
