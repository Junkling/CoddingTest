import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int count = 0;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        int N = sc.nextInt();
        hanoi(1, 2, 3, N);
        System.out.println(count);
        System.out.println(sb);
    }

    static void hanoi(int from, int mid, int to, int N) {

        if (N == 1) {
            count++;
            sb.append(from + " " + to).append("\n");
            return;
        }

        hanoi(from, to, mid, N - 1);
        sb.append(from + " " + to).append("\n");
        count++;
        hanoi(mid, from, to, N - 1);
    }
}
