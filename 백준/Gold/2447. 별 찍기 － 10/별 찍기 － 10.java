import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new char[N][N];
        fac(0, 0, N, true);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            if(i==N-1) continue;
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void fac(int x, int y, int n, boolean write) {
        if (!write) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }
        int z = n / 3;
        int count = 0;
        for (int i = x; i < x + n; i += z) {
            for (int j = y; j < y + n; j += z) {
                count++;
                if (count == 5) {
                    fac(i, j, z, false);
                    continue;
                }
                fac(i, j, z, true);
            }
        }
    }
}
