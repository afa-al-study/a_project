import java.util.ArrayList;
import java.util.Scanner;

public class _1932 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0; //배열 총 길이

        for(int i = 1; i <= n; i++){
            total = total + i;
        }
        int[] array = new int[total];
        int[] dp = new int[total];
//        int[] first = new int[n];
//        int[] last = new int[n];
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> last = new ArrayList<>();
        int k = 0; //번지수
        int l = 0; // +1, +2, +3 ...


//        for(int i = 0; i < total; i++){
//            array[i] = sc.nextInt();
//            if(i == k){
//                first[l] = i; //lv의 첫번째가 몇번째인지
//                last[l] = i+l;
//                l++;
//                k = k + l;
//            }
//        }

        for(int i = 0; i < total; i++){
            array[i] = sc.nextInt();
            if(i == k){
                first.add(i); //lv의 첫번째가 몇번째인지
                last.add(i+l);
                l++;
                k = k + l;
            }
        }

        dp[0] = array[0];
        for(int i = 1; i < total; i++){ //lv1부터(루트 다음부터)
            if(first.contains(i)){
                dp[i] = dp[first.get(first.indexOf(i)-1)] + array[i];
            }else if(last.contains(i)){
                dp[i] = dp[last.get(last.indexOf(i)-1)] + array[i];
            }else{
                int lv = i;
                while(!first.contains(lv)){
                    lv--;
                }
                lv = first.indexOf(lv);
                dp[i] = Math.max(dp[i-(lv+1)]+array[i], dp[i-(lv)] + array[i]) ;
            }
        }

        int max = 0;
        int tmp = 0;
        for(int i = first.get(n-1); i < last.get(n-1); i++ ){ //마지막 전이랑 마지막까지만 비교하면 되므로 <= 아님
            tmp = Math.max(dp[i], dp[i+1]);
            if(tmp > max){
                max = tmp;
            }
        }

        System.out.println(max);

    }
}
