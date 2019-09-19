import java.util.Scanner;

public class _9663 { //망한거
    static int[][] can_visit; //놓일 수 있으면 0, 놓일 수 없으면 1, 돌이 놓였으면 2
    //    static int[][] is_queen; //퀸 돌이 놓인 곳
    static int qn_cnt = 0; //놓인 말 개수
    static int N = 0; //주어진 말의 개수
    static int result = 0; //결과 개수

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        can_visit = new int[N][N];

        _9663 func = new _9663();


        for (int j = 0; j < N; j++) {
//            System.out.println("첫번째 말 : ( " + 0 + "," + j + ")");
            int x = 0;
            int y = j;
            func.dfs(x, y);


                for(int k = 0; k < N; k ++){
                    for(int l = 0; l < N; l++){

                        can_visit[k][l] = 0;
                    }
                }

            for (int k = 0; k < j; k++) { //첫번째 말이 넣어졋던 곳 다음 부터 matrix 초기화
                can_visit[0][k] = 1;
            }
            qn_cnt = 0;
        }


        System.out.println(result);
}


    public void dfs(int x, int y){
        if(qn_cnt != N){ //놓인 말의 개수가 넘어가면 실행X

//            System.out.println("dfs 시작 : (" + x + "," + y + ")");
            int p_x = x;
            int p_y = y;
            int can_assign = 1;

            //대각선 확인
            //왼위
            while((p_x-1) >= 0 && (p_y-1) >= 0 && can_assign == 1){
//                System.out.println("왼위");
                if(can_visit[p_x-1][p_y-1]==2) //돌이 있다
                    can_assign = 0;
                else{
//                    can_visit[p_x - 1][p_y - 1] = 1; // 못놓는 자리
                    p_x -= 1;
                    p_y -= 1;
                }
            }
            //초기화
            p_x = x;
            p_y = y;
            //오위
            while((p_x-1) >= 0 && (p_y+1) <= (N-1) && can_assign == 1){
//                System.out.println("오위");
                if(can_visit[p_x-1][p_y+1]==2)
                    can_assign = 0;
                else {
//                    can_visit[p_x - 1][p_y + 1] = 1;
                    p_x -= 1;
                    p_y += 1;
                }
            }
            //초기화
            p_x = x;
            p_y = y;
            //오아
            while((p_x+1) <= (N-1) && (p_y+1) <= (N-1) && can_assign == 1){
//                System.out.println("오아");
                if(can_visit[p_x+1][p_y+1] == 2)
                    can_assign = 0;
                else {
//                    can_visit[p_x + 1][p_y + 1] = 1;
                    p_x += 1;
                    p_y += 1;
                }
            }
            //초기화
            p_x = x;
            p_y = y;
            //왼아
            while((p_x+1) <= N-1 && (p_y-1) >= 0 && can_assign == 1){
//                System.out.println("왼아");
                if(can_visit[p_x+1][p_y-1] == 2)
                    can_assign = 0;
                else {
//                    can_visit[p_x + 1][p_y - 1] = 1;
                    p_x += 1;
                    p_y -= 1;
                }
            }

            //초기화
            p_x = x;
            p_y = y;
            //위아래 확인
            //위
            while(p_x-1 >= 0 && can_assign == 1){
//                System.out.println("위");
                if(can_visit[p_x-1][p_y] == 2)
                    can_assign = 0;
                else{
//                    can_visit[p_x-1][p_y] = 1;
                    p_x -= 1;
                }
            }
            //초기화
            p_x = x;
            p_y = y;
            //아래
            while(p_x+1 <= N-1 && can_assign == 1){
//                System.out.println("아래");
                if(can_visit[p_x+1][p_y] == 2)
                    can_assign = 0;
                else{
//                    can_visit[p_x+1][p_y] = 1;
                    p_x += 1;
                }
            }
            //초기화
            p_x = x;
            p_y = y;
            //오른쪽
            while(p_y+1 <= N-1 && can_assign == 1){
//                System.out.println("오른쪽");
                if(can_visit[p_x][p_y+1] == 2)
                    can_assign = 0;
                else{
//                    can_visit[p_x][p_y+1] = 1;
                    p_y += 1;
                }
            }
            //초기화
            p_x = x;
            p_y = y;
            //왼쪽
            while(p_y-1 >= 0 && can_assign == 1){
//                System.out.println("왼쪽");
                if(can_visit[p_x][p_y-1] == 2)
                    can_assign = 0;
                else{
//                    can_visit[p_x][p_y-1] = 1;
                    p_y -= 1;
                }
            }

            //대각선, 위아래 둘다 괜찮으면 qn_cnt++; //이때 말을 놓는거임
            //can_assign==1, qn_cnt++;
            if(can_assign == 1){
//                System.out.println("말을 놓는다 : (" + x + "," + y + ")" );
                can_visit[x][y] = 2;
                qn_cnt++;

//                System.out.println("can_vist matrix, qn_cnt = " + qn_cnt);
//                printMatrix(N, N, can_visit);

                if(qn_cnt == N){ //말의 개수
                    result += 1;
//                    System.out.println("result");
                    //다 놓으면 마지막 한개 빼기
                    qn_cnt--;
                    can_visit[x][y]=0;
                }else{
//                    System.out.println("넣을 수 있는 곳 탐색 시작값" + "x = " + x + ", y = " + y);
                    //돌면서 넣을 수 있는 곳 확인
                    for(int j = 0; j < N; j++){ // 다음 줄만 확인하면 됨.
                        if(x+1 <= N-1 && can_visit[x+1][j] == 0){
//                            System.out.println("넣을 수 있는 곳 " + "i = " + (x+1) + ", j = " + j);
//                            printMatrix(N, N, can_visit);
                            dfs(x+1, j);
                        }
                    }
                    //다음줄꺼 다 돈다음, 현재줄꺼 뺌
                    qn_cnt--;
                    can_visit[x][y]=0;

                }
            }

        }
    }

//    //이차행렬 프린트 함수
//    static public void printMatrix(int x_num, int y_num, int[][] state){
//        for(int i = 0; i < x_num; i++){
//            for(int j = 0; j < y_num; j++){
//                System.out.print(state[i][j] + " ");
//            }
//            System.out.println("");
//        }
//    }

}

