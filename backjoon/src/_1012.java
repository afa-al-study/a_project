import javafx.util.Pair;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class _1012 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int [][] state;
    static int col;
    static int row;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        //위, 오른쪽, 아래, 왼쪽


        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < tc; i++){ //test case 개수 만큼 반복
            col = sc.nextInt();   //가로
            row = sc.nextInt();  //세로
            int cab_num = sc.nextInt(); //배추 개수
            state = new int[row][col]; //0으로 초기화

//            Queue<Integer> qx = new LinkedList<>();
//            Queue<Integer> qy = new LinkedList<>();
            int times = 0;


            for(int j = 0; j < cab_num; j++){
                int k = sc.nextInt();
                int l = sc.nextInt();

                state[l][k] = 1;

            }


            _1012 func = new _1012();

            for(int k = 0; k < row; k++){
                for(int l = 0; l < col; l++){
                    if(state[k][l] == 1){
                        times++;
                        func.bfs(k, l);
                    }
                }
            }


            //qx,qy에는 1인 좌표가 들어있음
//
//            Queue<Integer> qx_ = new LinkedList<>();
//            Queue<Integer> qy_ = new LinkedList<>();

            result.add(times);

        }

        for (Integer num : result) {
            System.out.println(num);
        }

    }

    public void bfs(int xs, int ys){
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        state[xs][ys] = 0;
        qx.offer(xs);
        qy.offer(ys);

        while(!qx.isEmpty() && !qy.isEmpty()){
            int x = qx.poll();
            int y = qy.poll();

            for(int i = 0; i < dx.length; i++){
                int x_ = x + dx[i];
                int y_ = y + dy[i];
                if(!(x_ < 0 || y_ < 0 || x_ > row-1 || y_ > col-1)) {
                    if (state[x_][y_] == 1) {
                        state[x_][y_] = 0;

                        qx.offer(x_);
                        qy.offer(y_);
                    }
                }
            }
        }
    }
}

//시간초과
//            for(int j = 0; j < row; j++){
//                for(int k = 0; k < col; k++){
//                    if(state[j][k] == 1){
//                        times++;
//                        qx.offer(j);
//                        qy.offer(k);
//
//                        while(!qx.isEmpty() && !qy.isEmpty()){
//                            int x = qx.poll();
//                            int y = qy.poll();
//                            state[x][y] = 0;
//
//                            for(int v = 0; v < dx.length; v++) {
//                                int x_ = x + dx[v];
//                                int y_ = y + dy[v];
//
//                                if(!(x_ < 0 || y_ < 0 || x_ > row-1 || y_ > col-1)){
//                                    if(state[x_][y_] == 1){
//                                        qx.offer(x_);
//                                        qy.offer(y_);
//                                    }
//
//                                }
//                            }
//
//
//                        }
//
//                    }
//                }
//            }