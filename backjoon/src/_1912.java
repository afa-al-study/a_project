import java.util.Scanner;

public class _1912 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[num];
        int[] dp = new int[num];

        int max = 0;
        int tmp = 0;

        for(int i = 0; i< num; i++){
            array[i] = sc.nextInt();
        }

        max = array[0];
        for(int i = 0; i < num; i++){
            if(array[i] >= 0){ //양수
                    tmp += array[i];
            }else{//현재 값이 음수 일때,
                if(tmp != 0 ){
                    if (max < tmp) {
                        max = tmp;
                        tmp = 0;
                    }
                }else if(max < array[i]){
                    max = array[i];
                }

            }

        }

        if(tmp != 0 && max < tmp){
            max = tmp;
        }

        System.out.print(max);
    }
}
