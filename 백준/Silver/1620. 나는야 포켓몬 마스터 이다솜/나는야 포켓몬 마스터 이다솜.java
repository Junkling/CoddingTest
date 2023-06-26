import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> hm1 = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            hm1.put(i + 1, s);
            hm2.put(s, i + 1);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (hm2.containsKey(s)) {
                sb.append(hm2.get(s));
            }else {
                sb.append(hm1.get(Integer.parseInt(s)));
            }
            if (i == N - 1)continue;
                sb.append('\n');
        }
        System.out.println(sb);
    }
}
