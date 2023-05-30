import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] arr = new int[s.length() + 1];
        int roof = Integer.parseInt(sc.nextLine());
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            char c = s.charAt(i - 1);
            arr[i] = c - 97;
        }
        for (int i = 0; i < roof; i++) {
            String[] q = sc.nextLine().split(" ");
            char c1 = q[0].toCharArray()[0];
            int start = Integer.parseInt(q[1]) + 1;
            int end = Integer.parseInt(q[2]) + 1;
            int count = 0;
            for (int j = start; j <= end; j++) {
                if (arr[j] == c1 - 97) {
                    count++;
                }
            }
//            System.out.println(Arrays.toString(arr));

            System.out.println(count);
        }
    }
}
