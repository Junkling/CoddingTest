import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] result = new long[n + 1][10];


        for (int i = 0; i < n; i++) {
            if (i == 0) {
                for (int k = 0; k < 10; k++) {
                    if (k == 0) {
                        continue;
                    }
                    result[0][k] = 1L;
                }
                continue;
            }
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    result[i][j] = result[i - 1][j + 1]%1000000000;
                    continue;
                }
                if (j == 9) {
                    result[i][j] = result[i - 1][j - 1]%1000000000;
                    continue;
                }
                result[i][j] = (result[i-1][j - 1] + result[i-1][j + 1]) % 1000000000;
            }
        }
        long answer = 0l;
        for (int i = 0; i < 10; i++) {
            answer =(answer + result[n - 1][i])%1000000000;
//            System.out.println("result[" + i + "] = " + result[n-1][i]);
        }
        System.out.println(answer);
    }
}
