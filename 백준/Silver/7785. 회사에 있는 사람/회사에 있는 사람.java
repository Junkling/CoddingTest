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
        Set<String> hm = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken(" ");
            String s = st.nextToken();
            if (s.equals("enter")) {
                hm.add(name);
                continue;
            }
            if(s.equals("leave"))
            hm.remove(name);
        }
        Object[] arr = hm.toArray();
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i <arr.length; i++) {
            Object s = arr[i];
            sb.append(s);
            if(i==hm.size()-1) break;
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
