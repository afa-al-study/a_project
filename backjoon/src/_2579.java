import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2579 {


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        int[] arys = new int[n+1];



        for(int i = 1; i <= n; i++){
            arys[i] = sc.nextInt();
        }

        dp[1] = arys[1];
        if(n>=2) dp[2] = arys[1] + arys[2];

        for(int i = 3; i <= n; i++){
//                dp[i] = Math.max(dp[i - 3] + dp[i - 1] + arys[i], arys[i] + dp[i - 2]); //dp[i-1]이 아니라 arys[i-1] -> dp[i-3]까지 계산된 것에 새로운 점수를 더하는 것이기 때문
            dp[i] = Math.max(dp[i-3] + arys[i-1] + arys[i], arys[i] + dp[i-2]);
        }

        System.out.println(dp[n]);



    }


}
