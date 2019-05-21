import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//모가 틀렸으까
public class _11724 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); //정점
        int e = sc.nextInt(); //간선

        int[][] matrix = new int[v+1][v+1];
        int[] v_state = new int[v+1];

        for(int i = 0; i < e; i++){
            int k = sc.nextInt();
            int l = sc.nextInt();
            //방향성 제거
            matrix[k][l] = 1;
            matrix[l][k] = 1;
        }
        int cnt = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= v; i++){
            for(int j = 1; j <= v; j++){
                if(matrix[i][j] == 1){
                    q.offer(i);
//                    q.offer(j); // 이어진 정점
//                    matrix[i][j] = 0;
//                    matrix[j][i] = 0;
                    v_state[i] = 1;
//                    v_state[j] = 1;
                    while(!q.isEmpty()){
                        int p = q.poll();

                        for(int k = 1; k <= v; k++){
                            if(matrix[p][k] == 1){
                                matrix[p][k] = 0;
                                matrix[k][p] = 0;
                                if(v_state[k] == 0) {
                                    q.offer(k);
                                    v_state[k] = 1;

                                }
                            }
                        }
                    }
                    cnt++;
                }

            }

        }

        for(int i = 1; i <= v; i++){
            if(v_state[i] == 0) cnt++;
        }
        System.out.println(cnt);

    }

}
