import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wines = new int[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            wines[i] = sc.nextInt();
        }
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[0] = wines[0];
            }else if (i == 1) {
                result[1] = wines[1] + wines[0];
            } else if (i == 2) {
                result[2] = Math.max(result[1],Math.max(wines[2] + wines[1], wines[2] + wines[0]));
            }else {
                result[i] = Math.max(result[i-1],Math.max((wines[i]+wines[i-1]+result[i-3]),(wines[i]+result[i-2])));
            }
            answer = Math.max(answer, result[i]);
        }
        System.out.println(answer);

    }
}
