import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static String line = "-";

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String st;
        while ((st = br.readLine())!=null) {
            clear();
            int N = Integer.parseInt(st);
            logic(N, 0);
//            sb.append(line);
//            sb.append('\n');
            System.out.println(line);
        }
//        System.out.println(sb);
    }

    static void clear() {
        line = "-";
    }

    static void logic(int x, int count) {
        if (x == count) return;
        int length = line.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(" ");
        }
        line = line + sb + line;
        count++;
        logic(x, count);
    }
}