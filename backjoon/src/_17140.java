import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class _17140 { //이차원 배열과 연산

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();
        int row = 3;
        int col = 3;

        _17140 m_func = new _17140();

        int[][] state = new int[101][101];
        //A[r][c] = k일때

        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 3; j++){
                state[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;

        while(!(state[r][c] == k) || cnt > 100){//같을 때 까지
            //행 증가
            if(row >= col){
                for(int i = 1; i <= row; i++) {//행 개수만큼 돌리면서
                    int n = 1;
                    int[] n_cnt = new int[101];
                    ArrayList<Integer[]> n_sort = new ArrayList<>();

                    while (state[i][n] != 0) {//열 끝까지 돌리기
                        n_cnt[state[i][n]] += 1; //해당 숫자 개수 올리기
                        n++;
                    }

                    //l대신 queue같은걸 이용해서 99개까지안도는 방법 찾아보기

                    for(int l = 1; l <= 99; l++){
                        if(n_cnt[l] > 0){ // 숫자 개수가 1개 이상일 때
                            if(n_sort.isEmpty()) { // 처음 add할 때
                                n_sort.add(new Integer[]{l, n_cnt[l]}); //숫자와 개수
                            }else{
                                for(int m = 0; m < n_sort.size(); m++){
                                    if(n_sort.get(m)[1] > n_cnt[l]){ //현재 갯수가 add된 갯수보다 작으면
                                        n_sort.add(m, new Integer[]{l, n_cnt[l]});
                                        break;
                                    }
                                    else if(n_sort.get(m)[1] == n_cnt[1]){ //개수가 같을 때
                                        if(n_sort.get(m)[0] > l){ // 숫자가 작으면 앞에 추가
                                            n_sort.add(m, new Integer[]{l, n_cnt[l]});
                                        }
                                    }
                                    else{
                                        n_sort.add(new Integer[]{l, n_cnt[l]}); //마지막에 플러스

                                    }
                                }
                            }
                        }
                    }

                    int q = 1;
                    for(int l = 1; l <= n_sort.size(); l++){
                        if(q == 100){
                            break;
                        }else {
                            state[i][q] = n_sort.get(l - 1)[0];
                            state[i][q + 1] = n_sort.get(l - 1)[1];
                            q = q+2;
                        }
                    }

                }
            }
            else{ //열 증가


            }




            cnt++; //한번 증가
        }

        m_func.printMatrix(100, 100, state);
        if(cnt > 100){
            System.out.println(-1);

        }else {
            System.out.println(cnt);
        }


    }

    //이차행렬 프린트 함수
    public void printMatrix(int x_num, int y_num, int[][] state){
        for(int i = 0; i < x_num; i++){
            for(int j = 0; j < y_num; j++){
                System.out.print(state[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
