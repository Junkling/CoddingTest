import java.util.*;

public class Main {
    //
//    static class P {
//        int row, cal;
//
//        public P(int row, int cal) {
//            this.row = row;
//            this.cal = cal;
//        }
//    }
//
//
//
//    static Queue<P> q = new LinkedList<>();
    static int[][] map = new int[9][9];
    static int zero = 0;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int nextInt = sc.nextInt();
                if (nextInt == 0) {
                    zero++;
//                    q.offer(new P(i, j));
                }
                map[i][j] = nextInt;
            }
        }
        sudoqu2(0, 0);
//        System.out.println(sb);

    }


//    static void checkOnly(P p) {
//        for (int i = 1; i <= 9; i++) {
//            if (!check(p,i)) continue;
//            map[p.row][p.cal] = i;
//            zero--;
//            return;
//        }
//        q.offer(p);
//    }

    //
//    private static boolean check(P p, int value) {
//
//        for (int i = 0; i < 9; i++) {
//            if (map[p.row][i] == value) return false;
//        }
//        for (int i = 0; i < 9; i++) {
//            if (map[i][p.cal] == value) return false;
//        }
//
//        int x = (p.row / 3) * 3;
//        int y = (p.cal / 3) * 3;
//
//        for (int i = x; i < x + 3; i++) {
//            for (int j = y; j < y + 3; j++) {
//                if (map[i][j] == value) return false;
//            }
//        }
//        return true;
//    }
    private static boolean check2(int row, int cal, int value) {

        for (int i = 0; i < 9; i++) {
            if (map[row][i] == value) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (map[i][cal] == value) return false;
        }

        int x = (row / 3) * 3;
        int y = (cal / 3) * 3;

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (map[i][j] == value) return false;
            }
        }
        return true;
    }

    //    static void sudoqu() {
//        if(zero==0)return;
//        while (!q.isEmpty()) {
//            P poll = q.poll();
//            checkOnly(poll);
//        }
//    }
    static void sudoqu2(int row, int cal) {
//        if (zero == 0) return;
        if (cal == 9) {
            sudoqu2(row + 1, 0);
            return;
        }
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }


        if (map[row][cal] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (!check2(row, cal, i)) continue;
                map[row][cal] = i;
                zero--;
                sudoqu2(row, cal + 1);
            }
            map[row][cal] = 0;
            return;
        }

        sudoqu2(row, cal + 1);
    }
}
