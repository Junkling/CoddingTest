import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, (x, y) -> {
           if(x[1]==y[1])return Integer.compare(x[0], y[0]);
           return Integer.compare(x[1], y[1]);
        });
        int answer1 = 0;
        int now1 = 0;
        for (int i = 0; i < n; i++) {
            if (now1 <= arr[i][0]) {
                now1 = arr[i][1];
                answer1++;
            }
        }
        
        System.out.println(answer1);

    }
}
