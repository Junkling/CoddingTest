import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int cal = sc.nextInt();
        int moveR = sc.nextInt();
        int moveC = sc.nextInt();
        int[][] map = new int[row+moveR][cal+moveC];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cal; j++) {
                if (i > moveR - 1 && j > moveC - 1) {
                    map[i][j] = map[i][j] - map[i - moveR][j - moveC];
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
