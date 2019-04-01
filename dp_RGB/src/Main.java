
import java.util.*;

public class Main{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Integer[][] matrix = new Integer[3][num+1];

        for (int i = 1; i <= num; i++) {
            int r = sc.nextInt(); //R
            int g = sc.nextInt(); //G
            int b = sc.nextInt(); //B

            if(i == 1){
                for(int j = 0; j < 3; j++) {
                    matrix[j][0] = 0;
                }
            }

            //i번째에 빨간색을 선택했을 때, min값
            matrix[0][i] = Math.min(matrix[1][i - 1], matrix[2][i - 1]) + r; //현재 빨간색을 칠하려면 이전의 최소값 더하기 현재 빨간색 값
            matrix[1][i] = Math.min(matrix[0][i - 1], matrix[2][i - 1]) + g;
            matrix[2][i] = Math.min(matrix[0][i - 1], matrix[1][i - 1]) + b;

        }

        System.out.println(Math.min(matrix[0][num], Math.min(matrix[1][num], matrix[2][num])));
    }

}
