import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _7576 {

    public int result(int x_num, int y_num, int[][] state){
        for(int i = 0; i < x_num; i++){
            for(int j = 0; j < y_num; j++){
//                System.out.print(state[i][j] + " ");
                if(state[i][j] == 0){
                    return -1;
                }
            }
        }
        return 0;
    }

    public void printMatrix(int x_num, int y_num, int[][] state){
        for(int i = 0; i < x_num; i++){
            for(int j = 0; j < y_num; j++){
                System.out.print(state[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int y_num = sc.nextInt();
        int x_num  = sc.nextInt();

        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();

        int[] dx = {-1, 0, 1, 0}; //위 오른쪽 아래 왼쪽
        int[] dy = {0, 1, 0, -1};
        int[][] visit = new int[x_num][y_num];
//        for(int i = 0; i < x_num; i++){
//            Arrays.fill(visit[i], false);
//        }
        int[][] matrix = new int[x_num][y_num];
        for(int i = 0; i < x_num; i++){
            for(int j = 0; j < y_num; j++){
                int k = sc.nextInt();
                matrix[i][j] = k;
                visit[i][j] = k;
                if(k == 1){
                    qx.offer(i);
                    qy.offer(j);
                }
            }
        }

        _7576 func = new _7576();

        int x = 0;
        int y = 0;
        //bfs
        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();

            for(int i = 0; i < dx.length; i++){
                //위 오른쪽 아래 왼쪽
                int x_ = x + dx[i];
                int y_ = y + dy[i];
                if(x_ == x_num){
                    x_ = x_num-1;
                }
                if(y_ == y_num){
                    y_ = y_num-1;
                }

                if(x_ < 0){
                    x_ = x;
                }
                if(y_ < 0 ){
                    y_ = y;
                }
                if(matrix[x_][y_] == 0){
                    qx.offer(x_);
                    qy.offer(y_);
                    matrix[x_][y_] = 1;
                    visit[x_][y_] = visit[x][y] + 1;
                }

                System.out.println("matrix 행렬 " + i + "번째");
                func.printMatrix(x_num, y_num, matrix);
                System.out.println("visit 행렬 " + i + "번째");
                func.printMatrix(x_num, y_num, visit);


            }

        }

        if(func.result(x_num, y_num, matrix) == 0){
            System.out.println(visit[x][y]-1);
        }else{
            System.out.println(-1);
        }


    }
}
