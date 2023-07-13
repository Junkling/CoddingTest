import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int C;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int min = 1;
        int max = arr[N - 1] - arr[0] + 1;
        while (min < max) {
            int mid = (max + min) / 2;
            if (install(mid) >= C) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        System.out.println(min - 1);
    }

    public static int install(int n) {
        int count = 1;
        int now = arr[0];
        for (int i = 1; i < N; i++) {
            int x = arr[i];
            if(x-now<n) continue;
            count++;
            now = x;
        }
        return count;
    }
}
