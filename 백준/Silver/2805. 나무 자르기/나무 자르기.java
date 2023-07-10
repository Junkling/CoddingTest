import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int max = 0;
    static int min = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            int nextInt = sc.nextInt();
            arr[i] = nextInt;
            max = Math.max(nextInt, max);
        }

        int mid = 0;
        while (min < max) {
            mid = (max + min) / 2;
            long result = 0;
            for (int i = 0; i < N; i++) {
                long x = arr[i] - mid;
                if (x <= 0) continue;
                result += x;
            }
            if (result < M) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
        System.out.println(min - 1);
    }
}
