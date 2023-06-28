import java.util.Scanner;

public class Main {
    static int[] arr;
    static int answer = -1;
    static int count = 0;
    static int[] temp;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        temp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        sort(0, N - 1);
        System.out.print(answer);
    }

    public static void sort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(low, mid);
            sort(mid + 1, high);
            df(low, mid, high);
        }
    }

    public static void df(int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= high) {
            temp[index++] = arr[j++];
        }
        index = 0;
        i = low;
        while (i <= high) {
            count++;
            if (count == M) {
                answer = temp[index];
                break;
            }
            arr[i++] = temp[index++];
        }
    }
}
