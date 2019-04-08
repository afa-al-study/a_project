
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1697 {
    final static boolean LOG_ENABLE = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //술래
        int k = sc.nextInt();
        int step = 0;

        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visit = new boolean[100001];
        Arrays.fill(visit, false);
        visit[n] = true;
        queue.offer(n);



        int q_lv = 0;

        while(n != k){

            if(step == 0){
                n = queue.poll();
                if(LOG_ENABLE){
                    System.out.println("<n> = " + (n));
                }

                if((n+1) != k && (n-1) != k && (2*n) != k) {
                    if ((n + 1) <= 100000 && !visit[n + 1]) {
                        queue.offer(n + 1);
                        visit[n + 1] = true;
                        if(LOG_ENABLE){
                            System.out.println("n+1 = " + (n+1));
                        }
                    }

                    if ((n - 1) >= 0 && !visit[n - 1]) {
                        queue.offer(n - 1);
                        visit[n - 1] = true;
                        if(LOG_ENABLE){
                            System.out.println("n-1 = " + (n-1));
                        }
                    }

                    if ((n * 2) <= 100000 && !visit[n * 2]) {
                        queue.offer(n * 2);
                        visit[n * 2] = true;
                        if(LOG_ENABLE){
                            System.out.println("n*2 = " + (n*2));
                        }
                    }

                    q_lv = queue.size();
                    step++;

                }
                else{
                    step++;
                    n = k;
                }
            }
            else {
                for(int i = 0; i < q_lv; i++) {
                    n = queue.poll();
                    if(LOG_ENABLE){
                        System.out.println("<n> = " + (n));
                    }

                    if((n+1) != k && (n-1) != k && (2*n) != k) {
                        if ((n + 1) <= 100000 && !visit[n + 1]) {
                            queue.offer(n + 1);
                            visit[n + 1] = true;
                            if(LOG_ENABLE){
                                System.out.println("n+1 = " + (n+1));
                            }
                        }

                        if ((n - 1) >= 0 && !visit[n - 1]) {
                            queue.offer(n - 1);
                            visit[n - 1] = true;
                            if(LOG_ENABLE){
                                System.out.println("n-1 = " + (n-1));
                            }
                        }

                        if ((n * 2) <= 100000 && !visit[n * 2]) {
                            queue.offer(n * 2);
                            visit[n * 2] = true;
                            if(LOG_ENABLE){
                                System.out.println("n*2 = " + (n*2));
                            }
                        }

                        if(LOG_ENABLE){
                            System.out.println("");
                        }


                    }
                    else {
                        i = q_lv;
                        n = k;
                    }
                }

                    step++;
                    q_lv = queue.size();

            }

            if(LOG_ENABLE){
                System.out.println("step = " + step);
                System.out.print("queue = {");
                for(int i = 0; i < queue.size(); i ++) {
                    System.out.print( ((LinkedList<Integer>) queue).get(i) + " ,");
                }
                System.out.print(" }");
                System.out.println("");
                System.out.println("");


            }

        }


        System.out.print(step);
    }

}