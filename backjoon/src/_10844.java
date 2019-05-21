
import java.util.Scanner;

public class _10844 {

    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[][] dp = new int[n+1][11]; // 0~10

        for(int i = 0; i <= 10; i++){
            dp[1][i] = 1;
        }
        dp[1][10] = 0;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= 9; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j+1] % 1000000000;
                }else if(j == 9){
                    dp[i][j] = dp[i-1][j-1]% 1000000000;
                }else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])% 1000000000;
                }
            }
        }
        _10844 a = new _10844();
        a.printMatrix(n, 11, dp);

        long k = 0;
        for(int i = 1; i <= 9; i++){
            k += dp[n][i];
        }
       System.out.println(k% 1000000000);

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

/*메모리 초과
 Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();

        if(n==1){
            cnt = 9;
        }else {
            for (int i = 1; i <= 9; i++) {
                q.offer(i);
                for (int j = 1; j < n; j++) {
                    int l = (int) (Math.pow(2, j));

                    for (int k = 0; k < l/2; k++) {//한번에 -1, +1 두번 실행하니 l/2
                        if (q.isEmpty()) {
                            break;
                        }
                            int y = q.poll();
                            if (j == (n - 1)) {
                                if (y - 1 >= 0) {
                                    cnt++;
                                }
                                if (y + 1 < 10) {
                                    cnt++;
                                }
                            } else {
                                if (y - 1 >= 0) {
                                    q.offer(y - 1);
                                }
                                if (y + 1 < 10) {
                                    q.offer(y + 1);
                                }
                            }
                        }
                    }

            }
        }

        System.out.println(cnt%1000000000);
 */

