import javafx.util.Pair;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _9095 {
//    static int[][][][] dp;
    int[] total_num = new int[12];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

//        dp = new int[11][11][11][11]; // num은 숫자, 그 뒤는 1의 개수, 2의개수, 3의개수, n이 최대 11이기 때문에 1이 11이상 나올 일이 없음

        for(int i = 0; i < num; i++){
            q.offer(sc.nextInt());
        }

        _9095 func = new _9095();
        while(!q.isEmpty()) {
            func.dfs(q.poll());
        }

    }

    public void dfs(int n){
        int total = 1;

        for(int i = 0; i < 12; i++){//1은 11개까지만
            for(int j = 0; j < 6; j++){ // 2는 5개 이상 나오지 않음
                for(int k = 0; k < 4; k++){ //3은 3개 이상
                    if(i + (j*2) + (k*3) == n && n != 0){
                        for(int l = 1; l <= i+j+k; l++){
                            total *= l;
                        }

                        if(i > 1){
                            for(int l = 1; l <= i; l++){
                                total /= l;
                            }
                        }

                        if(j > 1){
                            for(int l = 1; l <= j; l++){
                                total /= l;
                            }
                        }
                        if(k > 1){
                            for(int l = 1; l <= k; l++){
                                total /= l;
                            }
                        }

                        total_num[n] += total;
                    }
                    total = 1;
                }
            }
        }

        System.out.println(total_num[n]);
    }

}
