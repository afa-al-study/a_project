import java.util.Scanner;

public class _2156 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[num+1]; // 1부터 n까지
        int[] dp = new int[num+1];

        for(int i = 1; i <= num; i++){
            array[i] = sc.nextInt();
        }

        dp[1] = array[1];
        if(num <= 2) {
            dp[2] = array[1] + array[2];
        }
        for(int i = 3; i <= num; i++){

            dp[i] = Math.max(Math.max(array[i-1] + array[i] + dp[i-3] , dp[i-2] + array[i]),  dp[i-1]);

        }


        System.out.println(dp[num]);

    }
}
