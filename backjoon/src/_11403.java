import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _11403 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        int[][] result = new int[n][n];
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        for(int i = 0; i < n; i++ ){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        int p = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ;j ++){
                if(matrix[i][j] == 1){
//                    p = i;
//                    qx.offer(i);
                    qy.offer(j);

                    while (!qy.isEmpty()) {
//                        int x = qx.poll();
                        int y = qy.poll();
                        result[i][y] = 1;

                        for(int k = 0; k < n; k++){
                            if(matrix[y][k] == 1 && result[i][k] != 1){
                                qx.offer(y);
                                qy.offer(k);
                                result[i][k] = 1;
                            }
                        }


                    }

                }
            }
        }


        for(int i = 0;  i < n; i++){
            for(int j = 0; j <n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }



    }
}
