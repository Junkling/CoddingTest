import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int[][] map = new int[row][3];
        int[][] result = new int[row][3];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==0){
                    result[0][j] = map[0][j];
                    continue;
                }
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    if (result[i][j] == 0) {
                        result[i][j] = map[i][j] + map[i - 1][k];
                    }
                    result[i][j] = Math.min(result[i][j], map[i][j] + result[i - 1][k]);
                }
            }
        }

        int answer = result[row - 1][0];
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, result[row - 1][i]);
        }
        System.out.println(answer);

    }

}
