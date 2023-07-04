import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visit;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makeTeam(0, 0);
        System.out.println(result);
    }

    static void makeTeam(int start, int depth) {
        if (depth == N / 2) {
            gap();
            return;
        }
        for (int i = start; i < N; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            makeTeam(i + 1, depth + 1);
            visit[i] = false;
        }
    }

    static void gap() {
        int team1 = 0;
        int team2 = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] ==true && visit[j]==true) {
                    team1 += map[i][j];
                    team1 += map[j][i];
                }
                else if (visit[i]==false && visit[j]==false) {
                    team2 += map[i][j];
                    team2 += map[j][i];
                }
            }
        }
        int abs = Math.abs(team1 - team2);
        if (abs == 0) {
            System.out.println(0);
            System.exit(0);
        }
        result = Math.min(result, abs);
    }

}
