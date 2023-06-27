import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int answerA = A;
        int answerB = B;
        for (int i = 0; i < A; i++) {
            hm.put(sc.nextInt(), 1);
        }

        for (int i = 0; i < B; i++) {
            int x = sc.nextInt();
            if (hm.containsKey(x)) {
                answerA--;
                answerB--;
            }
        }
        System.out.println(answerA + answerB);
    }
}
