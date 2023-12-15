import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        long[] arr = new long[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int result = 0;
        for (int k = 0; k < length; k++) {
            long find = arr[k];
            int i = 0;
            int j = length - 1;
            while (i < j) {
                if (arr[i] + arr[j] == find) {
                    // 1100 는 서로 다른 두 수 의 합 이어야 함 을
                    if (i != k && j != k) {
                        result++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (arr[i] + arr[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
            System.out.println(result);
    }
}
