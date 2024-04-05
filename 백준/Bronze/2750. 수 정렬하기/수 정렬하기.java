import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(0, n-1);

        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }
    }

    static void quickSort(int start, int end) {
        if(start>= end) return;
        int mid = start + (end - start) / 2;
        int midValue = arr[mid];

        int left = start;
        int right = end;

        while (left <= right) {
            while (arr[left] < midValue) {
                left++;
            }
            while (arr[right] > midValue) {
                right--;
            }
            if (left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }
        quickSort(start, right);
        quickSort(left, end);

    }

    static void swap(int left, int right) {
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }
}
