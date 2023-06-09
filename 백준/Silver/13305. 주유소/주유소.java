import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] km = new int[n - 1];
        long[] price = new long[n];
        for (int i = 0; i < n - 1; i++) {
            km[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            price[i] = Long.valueOf(sc.nextInt());
        }
        long prev = price[0];
        int sum = 0;
        int location = 0;
        while (location<n-1) {
            for (int i = 0; i < n-1; i++) {
                if(price[i]<=prev){
                    sum += price[i]*km[i];
                    prev = price[i];
                }else{
                    sum += prev*km[i];
                }
                location++;

            }
        }
        System.out.println(sum);
    }
}
