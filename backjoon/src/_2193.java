import java.util.Scanner;

public class _2193 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        long[] dp = new long[91]; //long타입으로 해주지 않으면 범위 초과ㅠ,ㅠ
        dp[1] = 1;
        dp[2] = 1;


        for(int i = 3; i < num + 1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[num]);
    }

}

//시간초과코드
//public static void main(String args[]){
//    Scanner sc = new Scanner(System.in);
//    int num = sc.nextInt();
//
//    int[] dp = new int[num];
//    dp[0] = 1;
//
//    int times = 1;
//
//
//    while(dp[0] == 1) {
//        dp[num-1] += 1;
//        for(int k = num; k > 1; k--) {
//            if(dp[num-1] == 2 || dp[k-1] == 2){
//                dp[k - 1] = 0;
//                dp[k - 2] += 1;
//            }
//        }
//
//        if(dp[0] == 1) { //안해주면 2, 0, 0 일때도 times++함
//            times++;
//            for (int j = 0; j < num - 1; j++) {
//                if (dp[j] == 1 && dp[j + 1] == 1) {
//                    times--;
//                    break;
//                }
//            }
//        }
//
//    }
//
//    System.out.println(times);
//
//}
