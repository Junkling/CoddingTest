import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int length = s.length();
        HashSet<String> hs = new HashSet<>();
        for (int i = 1; i <= length; i++) {
            int index = 0;
            while (index + i <= length) {
                String ss = s.substring(index, index + i);
                hs.add(ss);
                index++;
            }
        }
        System.out.println(hs.size());
    }
}
