
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (sum < 0) {
                sum = arr[i];
            }else{
                sum += arr[i];
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
