import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _17142 { //연구소

    public static void main(String args[]){ // 0:빈칸, 1:벽, 2:바이러스
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //배열 크기
        int M = sc.nextInt(); //바이러스
        int[][] matrix = new int[N][N];
        boolean[][] visit = new boolean[N][N];
        int min_count = -1;

        ArrayList<Integer[]> active_virus = new ArrayList<Integer[]>();

        test test1 = new test();

        Queue<Integer[]> q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int tmp = sc.nextInt();
                if(tmp == 1) visit[i][j] = true; //벽은 true
                else {
                    visit[i][j] = false;
                    matrix[i][j] = tmp;
                }

                if(tmp == 2){
                    active_virus.add(new Integer[]{i, j}); //virus list
//                    q.offer(new Integer[]{i, j}); //바이러스 위치
//                    visit[i][j] = true;
                    matrix[i][j] = -1;
                }
            }
        }


        //list 완전탐색
        for(int i = 0; i < active_virus.size()-2; i++) {
            int count = 0;
            q.offer(new Integer[]{active_virus.get(i)[0], active_virus.get(i)[1]});
            matrix[active_virus.get(i)[0]][active_virus.get(i)[1]] = 0;
            visit[active_virus.get(i)[0]][active_virus.get(i)[1]] = true;

            for (int j = i+1; j < active_virus.size()-1; j++) {
                q.offer(new Integer[]{active_virus.get(j)[0], active_virus.get(j)[1]});
                matrix[active_virus.get(j)[0]][active_virus.get(j)[1]] = 0;
                visit[active_virus.get(j)[0]][active_virus.get(j)[1]] = true;

                for(int k = j+1; k < active_virus.size(); k++){
                    q.offer(new Integer[]{active_virus.get(k)[0], active_virus.get(k)[1]});
                    matrix[active_virus.get(k)[0]][active_virus.get(k)[1]] = 0;
                    visit[active_virus.get(k)[0]][active_virus.get(k)[1]] = true;

                    while(!q.isEmpty()){ //Queue가 없을 때 까지
                        Integer[] tmp = q.poll();
                        int x = tmp[0];
                        int y = tmp[1];



                        //동서남북 확인
                        //동
                        if((y+1) != N && matrix[x][y+1] != 1 && !visit[x][y+1]){
                            visit[x][y+1] = true;
                            if(matrix[x][y+1] == -1 && (((y+2) != N && !visit[x][y+2])|| ((x+1) != N && !visit[x+1][y+1])|| ((x-1) != -1 && !visit[x-1][y+1]))) { //동, 남, 북 있나 확인
                                q.offer(new Integer[]{x, y+1});
                                matrix[x][y+1] = matrix[x][y] + 1;
                                if(count < matrix[x][y+1]) count = matrix[x][y+1];
                            }
                            else if(matrix[x][y+1] == 0){
                                q.offer(new Integer[]{x, y+1});
                                matrix[x][y+1] = matrix[x][y] + 1;
                                if(count < matrix[x][y+1]) count = matrix[x][y+1];
                            }
                        }
                        //서
                        if((y-1) != -1 && matrix[x][y-1] != 1 && !visit[x][y-1]){
                            visit[x][y-1] = true;
                            if(matrix[x][y-1] == -1 && (((y-2) != -1 && !visit[x][y-2])|| ((x+1) != N && !visit[x+1][y-1])|| ((x-1) != -1 && !visit[x-1][y-1]))) { //서, 남, 북 있나 확인
                                q.offer(new Integer[]{x, y - 1});
                                matrix[x][y - 1] = matrix[x][y] + 1;
                                if (count < matrix[x][y - 1]) count = matrix[x][y - 1];
                            }else if(matrix[x][y-1] == 0){
                                q.offer(new Integer[]{x, y - 1});
                                matrix[x][y - 1] = matrix[x][y] + 1;
                                if (count < matrix[x][y - 1]) count = matrix[x][y - 1];
                            }

                        }
                        //남
                        if((x+1) != N && matrix[x+1][y] != 1 && !visit[x+1][y]){
                            visit[x+1][y] = true;
                            if(matrix[x+1][y] == -1 && (((y+1) != N && !visit[x+1][y+1])|| ((y-1) != -1 && !visit[x+1][y-1])|| ((x+2) != N && !visit[x+2][y]))) { //동, 서, 남 있나 확인
                                q.offer(new Integer[]{x + 1, y});
                                matrix[x + 1][y] = matrix[x][y] + 1;
                                if (count < matrix[x + 1][y]) count = matrix[x + 1][y];
                            }else if(matrix[x+1][y] == 0){
                                q.offer(new Integer[]{x + 1, y});
                                matrix[x + 1][y] = matrix[x][y] + 1;
                                if (count < matrix[x + 1][y]) count = matrix[x + 1][y];
                            }

                        }
                        //북
                        if((x-1) != -1 && matrix[x-1][y] != 1 && !visit[x-1][y]){
                            visit[x-1][y] = true;
                            if(matrix[x-1][y] == -1 && (((y+1) != N && !visit[x-1][y+1]) || ((y-1) != -1 && !visit[x-1][y-1]) || ((x-2) != -1 && !visit[x-2][y]))) { //동, 서, 북 있나 확인
                                q.offer(new Integer[]{x - 1, y});
                                matrix[x - 1][y] = matrix[x][y] + 1;
                                if (count < matrix[x - 1][y]) count = matrix[x - 1][y];
                            }else if(matrix[x-1][y] == 0){
                                q.offer(new Integer[]{x-1, y});
                                matrix[x-1][y] = matrix[x][y] + 1;
                                if(count < matrix[x-1][y]) count = matrix[x-1][y];
                            }

                        }

                        System.out.println("i=" + i + ", j=" + j + ", k=" + k + ", count=" + count);
                        test1.printMatrix(N,N,matrix);
                    }
                }
            }
            if(min_count < 0 || min_count > count ) {
                if(count != 0) min_count = count;
            }
            System.out.println("count=" + count + ", min_count=" + min_count);



        }








        //0있는지 없는지 확인
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(matrix[i][j] == 0 && !visit[i][j])
                    min_count = -1;
            }
        }

        System.out.println(min_count);



    }
}
