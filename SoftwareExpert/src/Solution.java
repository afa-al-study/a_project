import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{

    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream(&quot;res/input.txt&quot;));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int i = 1; i <= T; i++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
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


            mailList.add(new Integer[]{mail_timeList.get(0), mail_timeList.get(0)});
            mail_timeList.remove(0);
            cnt++;

            while (mail_timeList.size() != 0 || (mailList.size() != 0 && mailList.get(0)[1] + B >= cnt)) {

                //들어온 시간보다 현재시간이 작거나 같을 동안 while문 돌아라

                if (mailList.size() != 0) { // mailList가 비어있지 않으면
                    cnt++;

                    int add_time = 0;
                    int init_time = 0;

                    //증가 한 후 확인 해야 함
                    if (mailList.size() == A) { // A개 이상일 때,
                        double half = 0;
                        if(mailList.size()%2 == 0)
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

                                double half = 0;
                                if(mailList.size()%2 == 0)
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

                }

                if (mail_timeList.size() != 0 && cnt == mail_timeList.get(0)) {
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