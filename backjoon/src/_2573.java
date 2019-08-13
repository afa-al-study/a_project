import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _2573 {
    static int[][] matrix;
    static int[][] prev;
    static boolean[][] visit;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int div_num = 0; // 나눠진 횟수
        int year = 0; // 몇 년 후,

        matrix = new int[row][col]; //입력 받은 2차원배열
        prev = new int[row][col]; // -1을 했을 때 0이 될 경우를 대비하여 확인을 위해 만든 2차원배열
        visit = new boolean[row][col]; // 방문 확인


        for(int i = 0; i < row; i++){ // 숫자 할당
            for(int j = 0; j<col; j++){
                int n = sc.nextInt();
                matrix[i][j] = n;
                prev[i][j] = n;
            }
        }
        _2573 func = new _2573();


        Arrays.fill(visit[0], true);
        Arrays.fill(visit[row-1], true);
        for(int i = 0; i < row; i++){ //visit 배열 초기화
                visit[i][0] = true;
                visit[i][col-1] = true;
        }
//        func.printMatrix2(row, col, visit);


        int check = -1;
        while(div_num < 2 && check != 0){
//            Loop1 : for(int i = 0; i < row; i++){ //첫 번째 숫자
//                for(int j = 0; j < col; j++){
//                    if(matrix[i][j] != 0){
//                        div_num++;
//                        first_row = i;
//                        first_col = j;
//                        visit[i][j] = true; //자기자신 visit
//                        func.dfs(first_row, first_col);
//                        break Loop1;
//                    }
//                }
//            }
            for(int i = 1; i < row-1; i++){ //visit 배열 초기화
                for(int j = 1; j < col-1; j++){
                    visit[i][j] = false;
                }
            }

            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(!visit[i][j] && matrix[i][j] != 0){
                        div_num++;
//                        System.out.println("false찾을때 마다 i = " + i + ", j = " + j);
                        visit[i][j] = true;
                        func.dfs(i, j);
                    }
                }
            }

            check = 0;
            for(int i = 0; i < row; i ++)
                for(int j = 0; j < col; j ++)
                    if(matrix[i][j]!= 0) check++;

            year++;

//            System.out.println("divide = " + div_num);


        }

        System.out.println(year);
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

    //이차행렬 프린트 함수
    public void printMatrix2(int x_num, int y_num, boolean[][] state){
        for(int i = 0; i < x_num; i++){
            for(int j = 0; j < y_num; j++){
                System.out.print(state[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public void dfs(int i, int j){
        //동, 남, 서, 북 순으로
        if(matrix[i][j+1] != 0 && !visit[i][j+1]){ //동
            visit[i][j+1] = true; //자기자신 visit
            prev[i][j+1]=matrix[i][j+1];

            dfs(i, j+1);
//            System.out.println("dfs동 : i = " + i + ", j = " + j);
        }
        if(matrix[i+1][j] != 0 && !visit[i+1][j]){ //남
            visit[i+1][j] = true;
            prev[i+1][j] = matrix[i+1][j];

            dfs(i+1, j);
//            System.out.println("dfs남 : i = " + i + ", j = " + j);
        }
        if(matrix[i][j-1] != 0 && !visit[i][j-1]){ //서
            visit[i][j-1] = true;
            prev[i][j-1]=matrix[i][j-1];

            dfs(i, j-1);
//            System.out.println("dfs서 : i = " + i + ", j = " + j);
        }
        if(matrix[i-1][j] != 0 && !visit[i-1][j]){ //북
            visit[i-1][j] = true;
            prev[i-1][j]=matrix[i-1][j];

            dfs(i-1, j);
//            System.out.println("dfs북 : i = " + i + ", j = " + j);
        }

//        System.out.println("돌아왔을때dfs함수 : i = " + i + ", j = " + j);
        //동, 남, 서, 북의 0의 개수대로
        if (matrix[i][j + 1] == 0 && matrix[i][j] > 0 && prev[i][j + 1] == 0) {
//            System.out.println("prev 동 : " + prev[i][j + 1]);
            matrix[i][j]--;
        }
        if (matrix[i + 1][j] == 0 && matrix[i][j] > 0 && prev[i + 1][j] == 0) {
//            System.out.println("prev 남 : " + prev[i + 1][j]);
            matrix[i][j]--;
        }
        if (matrix[i][j - 1] == 0 && matrix[i][j] > 0 && prev[i][j - 1] == 0) {
//            System.out.println("prev 서 : " + prev[i][j - 1]);
            matrix[i][j]--;
        }
        if (matrix[i - 1][j] == 0 && matrix[i][j] > 0 && prev[i - 1][j] == 0) {
//            System.out.println("prev 북 : " + prev[i - 1][j]);
            matrix[i][j]--;
        }

    }


}
