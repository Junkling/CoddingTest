import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
//        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);


        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int nextInt = sc.nextInt();
            System.out.println(bs(nextInt));
        }
    }

    public static int bs(int key) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] > key) {
                right = mid - 1;
            } else if (a[mid] < key) {
                left = mid + 1;
            } else {
                return 1;
            }
        }
        return  0;
    }
}
