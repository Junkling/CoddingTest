import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] map1;
    static int[][] map2;
    static int[][] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        map1 = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map1[i][j] = sc.nextInt();
            }
        }
        int L = sc.nextInt();
        int K = sc.nextInt();
        map2 = new int[L][K];
        answer = new int[N][K];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < K; j++) {
                map2[i][j] = sc.nextInt();
            }
        }
        search(0, 0);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                sb.append(answer[i][j]);
                if(j==K-1) continue;
                sb.append(' ');
            }
            if(i==N-1) continue;
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void search(int row, int col) {
        if(row==answer.length){
            search(0, col + 1);
            return;
        }
        if (col == answer[0].length) return;
        for (int i = 0; i < map2.length; i++) {
            answer[row][col] += map1[row][i] * map2[i][col];
        }
        search(row + 1, col);
    }
}
