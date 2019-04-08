import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1697 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //술래
        int k = sc.nextInt();
        int step = 0;

        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visit = new boolean[100000];
        Arrays.fill(visit, false);
        visit[n] = true;


//        if(n == 0){
//            n++;
//            step++;
//            visit[0] = true;
//            queue.offer(n);
//        }
//        if( n == 1){
//            n = 2;
//            step++;
//            queue.offer(n);
//        }

        while(n != k){

            if(step == 0){
                if((n+1) != k && (n-1) != k && (n*2) != k) {
                    if((n+1) != k && !visit[n+1]) {
                        //+1
                        queue.offer(n + 1);
                        visit[n + 1] = true;
                    }
                    if(n-1 >= 0) {
                        //-1
                        if ((n - 1) != k && !visit[n - 1]) {
                            //+1
                            queue.offer(n - 1);
                            visit[n - 1] = true;
                        }
                    }
                    if((2*n) != k && !visit[2*n]) {
                        //+1
                        queue.offer(n * 2);
                        visit[n + 1] = true;
                    }
                }else{
                    n = k;
                }
                step++;

            }
            else {
                step++;

                for (int i = 0; i < Math.pow(3, step); i++) {
                        n = queue.poll();
                        if((n+1) != k && (n-1) != k && (n*2) != k) {
                            if((n+1) != k && !visit[n+1]) {
                                //+1
                                queue.offer(n + 1);
                                visit[n + 1] = true;
                            }

                            //-1
                            if((n-1) != k && !visit[n-1]) {
                                //+1
                                queue.offer(n - 1);
                                visit[n - 1] = true;
                            }
                            if((2 * n) != k && !visit[2*n]) {
                                //+1
                                queue.offer(n * 2);
                                visit[n + 1] = true;
                            }
                        }else{
                            i = (int) Math.pow(3, step-1);
                            n = k;
                        }

                    }

            }

        }

        System.out.print(step);
    }


}