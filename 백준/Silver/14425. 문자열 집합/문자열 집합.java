import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<String>>arr = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            arr.add(new ArrayList<String>());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int c = s.charAt(0) - 97;
            arr.get(c).add(s);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int c = s.charAt(0) - 97;
            ArrayList<String> list = arr.get(c);
            for (int j = 0; j < list.size(); j++) {
                if (s.equals(list.get(j))) {
                    answer++;
                    break;
                }
            }
        }
        sb.append(answer);
        System.out.println(sb);
    }
}
