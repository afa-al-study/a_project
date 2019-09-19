import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2468 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        boolean[][] visit = new boolean[n][n];

        int before_count = -1;
        int count = 0;
        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ; j++){
                int tmp = sc.nextInt();
                if(max <= tmp)
                    max = tmp;
                matrix[i][j] = tmp;
                visit[i][j] = false;
            }
        }

        int end_safe = 0;
        while(end_safe <= max) {
            if(before_count < count)
                before_count = count;
            count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j] <= end_safe)
                        matrix[i][j] = 0;
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n ; j++){

                    if(matrix[i][j] != 0 && !visit[i][j]){
                        Queue<Integer> qx = new LinkedList<>();
                        Queue<Integer> qy = new LinkedList<>();
                        visit[i][j] = true;
                        qx.offer(i);
                        qy.offer(j);

                        while(!qx.isEmpty() && !qy.isEmpty()) {
                            int x_ = qx.poll();
                            int y_ = qy.poll();

                            //위
                            if ((x_ - 1) != -1 && matrix[x_ - 1][y_] != 0 && !visit[x_ - 1][y_]){
                                visit[x_-1][y_] = true;
                                qx.offer(x_-1);
                                qy.offer(y_);
                            }
                            //아래
                            if((x_+1) != n && matrix[x_+1][y_] != 0 && !visit[x_+1][y_]){
                                visit[x_+1][y_] = true;
                                qx.offer(x_+1);
                                qy.offer(y_);
                            }
                            //오른
                            if((y_+1) != n && matrix[x_][y_+1] != 0 && !visit[x_][y_+1]){
                                visit[x_][y_+1] = true;
                                qx.offer(x_);
                                qy.offer(y_+1);
                            }
                            //왼
                            if((y_-1) != -1 && matrix[x_][y_-1] != 0 && !visit[x_][y_-1]){
                                visit[x_][y_-1] = true;
                                qx.offer(x_);
                                qy.offer(y_-1);
                            }
                        }
                        count++;
                    }


                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n ; j++)
                    if(matrix[i][j] != 0 && visit[i][j])
                        visit[i][j] = false;
            }
            end_safe++;
        }


        System.out.println(before_count);
    }
}
