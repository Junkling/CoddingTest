
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

        int sum = arr[0];
        int answer = sum;
        for (int i = 1; i < length; i++) {
            if (arr[i] <= sum+arr[i]) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            answer = Math.max(answer, sum);
        }
//        System.out.println("result = "+Arrays.toString(result));
        System.out.println(answer);
    }
}
