import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        arr = new int[K];
        N = sc.nextInt();
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        long max = arr[K - 1];
        long min = 1;
        long mid = 0;
        while (min <= max) {
            long result = 0;
            mid = (max + min) / 2;
            for (int i = 0; i < arr.length; i++) {
                result += arr[i] / mid;
            }
            if (result < N) {
                max = mid-1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(max);
    }
}
