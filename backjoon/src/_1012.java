import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1012 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        //위, 오른쪽, 아래, 왼쪽
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < tc; i++){ //test case 개수 만큼 반복
            int col = sc.nextInt();   //가로
            int row = sc.nextInt();  //세로
            int cab_num = sc.nextInt(); //배추 개수
            int[][] state = new int[row][col]; //0으로 초기화
            int[][] visit = new int[row][col];

            Queue<Integer> qx = new LinkedList<>();
            Queue<Integer> qy = new LinkedList<>();
            int times = 0;

            for(int j = 0; j < cab_num; j++){
                int k = sc.nextInt();
                int l = sc.nextInt();

                state[l][k] = 1;
                qx.offer(l);
                qy.offer(k);
            }

            //qx,qy에는 1인 좌표가 들어있음

            Queue<Integer> qx_ = new LinkedList<>();
            Queue<Integer> qy_ = new LinkedList<>();

            while(!qx.isEmpty() && !qy.isEmpty()){
                    int k = qx.poll();
                    int l = qy.poll();

                    if(state[k][l] != 0) {
                        times++;

                        qx_.offer(k);
                        qy_.offer(l);
                        while(!qx_.isEmpty() && !qy_.isEmpty()){
                            int x = qx_.poll();
                            int y = qy_.poll();
                            state[x][y] = 0;

                            for(int v = 0; v < dx.length; v++) {
                                int x_ = x + dx[v];
                                int y_ = y + dy[v];

                                if(!(x_ < 0 || y_ < 0 || x_ > row-1 || y_ > col-1)){
                                    if(state[x_][y_] == 1){
                                        qx_.offer(x_);
                                        qy_.offer(y_);
                                    }

                                }
                            }


                        }
                    }

            }

            result.add(times);

        }

        for (Integer num : result) {
            System.out.println(num);
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