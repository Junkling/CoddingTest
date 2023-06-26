import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            hm.put(s, 1);
        }
        int count = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(!hm.containsKey(s)) continue;
            list.add(s);
            count++;
        }
        Collections.sort(list);
        sb.append(count).append('\n');
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i==list.size()-1)continue;
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
