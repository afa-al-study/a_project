import java.util.Scanner;

public class _11047 { //그리디 알고리즘_동전 0

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int need_coin = 0; //필요한 코인
        int coin_num = sc.nextInt(); //코인 개수
        int total = sc.nextInt();   // 총 값
        int[] coins = new int[coin_num];
        int k = 0;
        for(int i = 0; i < coin_num; i++){
            coins[i] = sc.nextInt();
            if(total/coins[i] == 0 && k == 0){
                k = i-1; //자릿수 만큼
            }
        }

        //반복
        //0일 때까지 찾고 그 전 자리수
        //total이 0이면 끝
        if(k == 0)
            k = coin_num-1;

        while(total != 0){
            int tmp = total / coins[k]; // coins[k]가 필요한 만큼 나옴
            need_coin += tmp; //코인 개수 += 현재 동전 필요한 개수
            total = total - tmp * coins[k];

            if(total == 0){
                break;
            }
            for(int i = k-1; i >= 0; i--){
                if(total/coins[i] != 0){ //coins[k] 보다 작은 동전으로 나눴을 때 몫이 나오는 제일 큰 동전
                    k = i;
                    break;
                }
            }

        }

        System.out.println(need_coin);
    }
}
