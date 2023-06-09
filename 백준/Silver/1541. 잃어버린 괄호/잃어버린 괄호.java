import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        int x = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                list.add(x);
                x++;
            }
            if (c == '+') x++;
        }
        String[] split = s.split("[-,+]");

//        System.out.println(list.toString());

        int answer = Integer.MAX_VALUE;
        int sum = 0;
            for (int i = 0; i < split.length; i++) {
                int parseInt = Integer.parseInt(split[i]);
                if(list.size()==0){
                    sum += parseInt;
                }else{
                if (i >= list.get(0)) {
                    sum -= parseInt;
                    continue;
                }
                sum += parseInt;
                }
            }
            answer = Math.min(answer, sum);
        System.out.println(answer);
    }
}
