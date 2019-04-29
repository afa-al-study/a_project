import java.util.Scanner;

public class _1912 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[num];
        int[] dp = new int[num];

        int max = 0;

        for(int i = 0; i< num; i++){
            array[i] = sc.nextInt();
        }


        dp[0] = array[0];
        max = array[0];
         for(int i = 1; i < num; i++){
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);

            max = Math.max(dp[i], max);
        }

        System.out.print(max);
    }
}
