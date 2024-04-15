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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> neverHear = new HashSet<>();
        List<String> neverHearSeen = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            neverHear.add(str);
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (neverHear.contains(str)) {
                neverHearSeen.add(str);
            }
        }
        Collections.sort(neverHearSeen);

        sb.append(neverHearSeen.size());

        for (String s : neverHearSeen) {
            sb.append("\n");
            sb.append(s);
        }
        System.out.println(sb);
    }
}
