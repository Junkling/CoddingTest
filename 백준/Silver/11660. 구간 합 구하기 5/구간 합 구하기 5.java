import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int roof = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= roof; i++) {
            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startCal = Integer.parseInt(st.nextToken());

            int endRow = Integer.parseInt(st.nextToken());
            int endCal = Integer.parseInt(st.nextToken());

            int sum = map[endRow][endCal] - map[endRow][startCal - 1] - map[startRow - 1][endCal] + map[startRow - 1][startCal - 1];
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }
}
