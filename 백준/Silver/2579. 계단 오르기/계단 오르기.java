import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stairs = sc.nextInt();
        int[] arr = new int[300];
        int[] score = new int[300];
        for (int i = 0; i < stairs; i++) {
            arr[i] = sc.nextInt();
        }

        score[0] = arr[0];
        score[1] = arr[0] + arr[1];
        score[2] = Math.max(arr[0], arr[1]) + arr[2];

        for (int i = 3; i < stairs; i++) {
            score[i]=Math.max(score[i - 3]+arr[i-1], score[i - 2]) + arr[i];
        }

        System.out.println(score[stairs-1]);

    }
}
