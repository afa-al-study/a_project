import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2178 {
    public static int[][] matrix; //행렬

    public static void main(String[] args) {

        //오른(0,1) 아래(1,0), 왼(0,-1), 위(-1, 0)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[][] visited = new boolean[n+1][m+1]; //위,아래,오른,왼
        for(int i = 0;  i < visited.length; i ++) {
            Arrays.fill(visited[i], false);
        }
        //초기값
        int x = 1;
        int y = 1;

        matrix = new int[n+1][m+1];

        //0번째 행 0으로 초기화
        Arrays.fill(matrix[0], 0);

        for(int i = 0; i <=n; i++){ //0번째 열 초기화
            matrix[i][0] = 0;
        }

        for(int i = 1; i <= n; i++){
            String a = sc.next();
            for(int j = 1; j <= m; j++){
                matrix[i][j] = Integer.valueOf(a.substring(j-1,j));
            }
        }

        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();

        qx.offer(x);
        qy.offer(y);
        visited[x][y] = true; //초기 값 방문

        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();

            for(int i = 0; i < dx.length; i++){ // 오른쪽, 아래, 왼쪽, 위 순서
                int x_ = dx[i] + x;
                int y_ = dy[i] + y;

                if(x_ != 0 && y_ != 0 && x_<= n && y_ <= m) {
                    if (matrix[x_][y_] == 1 && !visited[x_][y_]) {
                        qx.add(x_);
                        qy.add(y_);
                        visited[x_][y_] = true;
                        matrix[x_][y_] = matrix[x][y] + 1;
                    }
                }
            }
        }

        System.out.print(matrix[n][m]);
    }

}
