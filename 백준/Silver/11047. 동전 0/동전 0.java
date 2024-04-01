import java.util.Scanner;

public class Main {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        arr = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > k) continue;
            index = i;
        }
        int answer = 0;
        while (k>0&& index>=0) {
            answer += k / arr[index];
            k %= arr[index];
            index--;
        }
        System.out.println(answer);
    }
}
