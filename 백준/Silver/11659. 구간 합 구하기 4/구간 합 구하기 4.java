import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int n = sc.nextInt();
        int[] sum = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt()-1;
            int end = sc.nextInt();
            System.out.println(sum[end] - sum[start]);
        }
    }
}
