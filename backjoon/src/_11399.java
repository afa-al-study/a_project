import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _11399 { //그리디 알고리즘_ATM

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //사람 수
        ArrayList<Integer> p_times = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            p_times.add(tmp);
        }

        Collections.sort(p_times);

        int sum = 0;
        int tmp = 0;
        for(int k : p_times){
//            System.out.println("sum = " + sum + " / " + "k = " + k);
            tmp = tmp + k;
            sum += tmp;
        }

        System.out.println(sum);
    }
}
