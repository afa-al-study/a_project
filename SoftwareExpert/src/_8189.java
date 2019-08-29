import java.util.ArrayList;
import java.util.Scanner;

public class _8189 { // 편지를 먼저 받고, 초를 세고 비운다.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); //테스트 케이스

        for(int i = 1; i <= tc; i++) { //테스트 케이스 돌림
            int N = sc.nextInt(); // 편지 개수
            int A = sc.nextInt(); // 편지 A개 이상일 때, 비우는 것
            int B = sc.nextInt(); // 시간 B 이상일 때, 절반 비워야함.
            ArrayList<Integer> mail_timeList = new ArrayList<Integer>();
            for (int j = 0; j < N; j++) {
                mail_timeList.add(sc.nextInt());
            }

            int cnt = 0; //시간 count

            ArrayList<Integer[]> mailList = new ArrayList<Integer[]>(); // { 들어온 시간 + 지난 시간, 들어온 시간 }
            ArrayList<Integer> result = new ArrayList<Integer>(); // 결과 리스트

//            for(int j = 0; j < mail_timeList.size(); j++){
//                int in_time = sc.nextInt(); //편지 받는 시간
//                if(mailList.isEmpty()) {
//                    mailList.add(new Integer[]{in_time, in_time});
//                }else {

            mailList.add(new Integer[]{mail_timeList.get(0), mail_timeList.get(0)});
//            cnt++;
            cnt = mail_timeList.get(0);
            mail_timeList.remove(0);


            while (!mail_timeList.isEmpty() || (!mailList.isEmpty() && mailList.get(0)[1] + B >= cnt)) {
                //들어온 시간보다 현재시간이 작거나 같을 동안 while문 돌아라

                if (!mailList.isEmpty()) { // mailList가 비어있지 않으면
                    cnt++;

                    int add_time = 0;
                    int init_time = 0;

                    //증가 한 후 확인 해야 함
                    if (mailList.size() == A) { // A개 이상일 때,
                        double half;
                        if(mailList.size() % 2 == 0 )
                            half = mailList.size() / 2; //올림 //반올림 Math.round(size);
                        else
                            half = (mailList.size()+1) / 2;
                        int out_time = mailList.get(0)[0];
                        for (int l = 0; l < half; l++) {
                            result.add(out_time);
                            mailList.remove(0);
                        }
                        for (int m = 0; m < mailList.size(); m++) { //remove로 줄어든 list 계속 현재시간 count해주기,mailList 전체 시간 증가
                            add_time = mailList.get(m)[0];
                            init_time = mailList.get(m)[1];
                            mailList.set(m, new Integer[]{add_time + 1, init_time});
                        }

                    } else {
                        for (int k = 0; k < mailList.size(); k++) { //mailList 전체 시간 증가
                            add_time = mailList.get(k)[0];
                            init_time = mailList.get(k)[1];
                            mailList.set(k, new Integer[]{add_time + 1, init_time});
                            if (cnt == mailList.get(0)[1] + B) {//시간 초과

                                double half;
                                if(mailList.size() % 2 == 0 )
                                    half = mailList.size() / 2; //올림 //반올림 Math.round(size);
                                else
                                    half = (mailList.size()+1) / 2;

                                int out_time = mailList.get(0)[0];
                                for (int l = 0; l < half; l++) {
                                    result.add(out_time);
                                    mailList.remove(0);
                                }
                                for (int m = 0; m < mailList.size(); m++) {
                                    add_time = mailList.get(m)[0];
                                    init_time = mailList.get(m)[1];
                                    mailList.set(m, new Integer[]{add_time + 1, init_time});
                                }
                                break;
                            }
                        }

                    }

                }else{ //mail_timeList가 비어있지 않을 때,
                    cnt++;
                }

                if (!mail_timeList.isEmpty() && cnt == mail_timeList.get(0)) {
                    mailList.add(new Integer[]{mail_timeList.get(0), mail_timeList.get(0)});
                    mail_timeList.remove(0);
                }
            }

            System.out.print("#" + i);
            //ArrayList for문 돌리기
            for (int aResult : result) System.out.print(" " + aResult);
            System.out.println();
        }

    }
}
