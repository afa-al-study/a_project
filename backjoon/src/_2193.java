import javafx.util.Pair;

import java.util.Scanner;

public class _2193 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] dp = new int[num];
        dp[0] = 1;

        int times = 1;


        while(dp[0] == 1) {
            dp[num-1] += 1;
               for(int k = num; k > 1; k--) {
                   if(dp[num-1] == 2 || dp[k-1] == 2){
                       dp[k - 1] = 0;
                       dp[k - 2] += 1;
               }
           }

           if(dp[0] == 1) { //안해주면 2, 0, 0 일때도 times++함
               times++;
               for (int j = 0; j < num - 1; j++) {
                   if (dp[j] == 1 && dp[j + 1] == 1) {
                       times--;
                       break;
                   }
               }
           }

        }

        System.out.println(times);

    }
}
