import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int n = sc.nextInt();
        int[] sum = new int[length+1];
        for (int i = 1; i < length+1; i++) {
            if(i==1){
                sum[i] = sc.nextInt();
                continue;
            }
            sum[i] = sum[i-1] + sc.nextInt();
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i+n < length+1; i++) {
            answer = Math.max(answer, sum[i + n] - sum[i]);
        }
        System.out.println(answer);
    }
}
