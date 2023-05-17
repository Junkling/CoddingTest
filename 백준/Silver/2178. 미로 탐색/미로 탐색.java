
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[][] visit;
    static int[][] road;
    static int maxRow;
    static int maxCol;

    static class Position {
        int row, col, depth;

        public Position(int row, int col,int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] fL = sc.nextLine().split(" ");
        maxRow = Integer.parseInt(fL[0]);
        maxCol = Integer.parseInt(fL[1]);
        visit = new boolean[maxRow][maxCol];
        road = new int[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            String[] split = sc.nextLine().split("");
            for (int j = 0; j < split.length; j++) {
                String s = split[j];
                if (s.equals("0")) continue;
                road[i][j] = 1;
            }
        }
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(0, 0,1));
        bfs(q);
    }

    static void bfs(Queue<Position> q) {
        while (!q.isEmpty()) {
            Position now = q.poll();
            if(visit[now.row][now.col]) continue;
            visit[now.row][now.col] = true;
            if (now.row == maxRow - 1 && now.col == maxCol - 1) {
                System.out.println(now.depth);
                break;
            }
            int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] m : move) {
                Position next = new Position(now.row + m[0], now.col + m[1], now.depth+1);
                if (!valid(next)) continue;
                if (road[next.row][next.col] == 0) continue;
                if (visit[next.row][next.col]) continue;
                q.offer(next);
            }
        }
    }

    private static boolean valid(Position next) {
        if (next.col >= maxCol || next.col < 0) return false;
        if (next.row >= maxRow || next.row < 0) return false;
        return true;
    }

}
