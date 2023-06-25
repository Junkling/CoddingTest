import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] arr1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        Arrays.sort(arr1);

        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            bs(sc.nextInt(), sb);
            sb.append(" ");
            if(i==M-1) break;
        }
        System.out.println(sb);
    }

    public static void bs(int x, StringBuilder sb) {
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            int y = arr1[mid];
            if (x < y) {
                right = mid - 1;
                continue;
            }
            if (x > y) {
                left = mid + 1;
                continue;
            }
            sb.append("1");
            return;
        }
        sb.append("0");
    }
}
