import java.util.ArrayList;
import java.util.Scanner;


public class _17140_sec {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(); //행
        int c = sc.nextInt(); //열
        int wnt_num = sc.nextInt(); //원하는 숫자
        int count = 0; //연산 횟수

        int r_num = 3;
        int c_num = 3;

        //test package
//        _17140_sec func = new _17140_sec();

        int[][] matrix = new int[100][100]; //0~99까지 100개

        for(int i = 0; i < 3; i++){ //초기 matrix값 입력 받기
            for(int j = 0; j <3; j++ ){
                matrix[i][j] = sc.nextInt();
            }
        }


        while(matrix[r-1][c-1] != wnt_num) {
            //r연산, 행>=열
            if(r_num >= c_num){
                int tmp_c_num = c_num;
                //개수 저장
                for(int i = 0; i < r_num; i++){//행연산
                    int[] saveNumber = new int[101]; // 나온 갯수(0~99)
                    ArrayList<Integer[]> saveList = new ArrayList<Integer[]>();//순서대로 숫자 저장한 것 //정렬된 리스트

                    for(int j = 0; j < tmp_c_num; j++){
                        if(matrix[i][j] != 0) {
                            saveNumber[matrix[i][j]] += 1;
                        }
                        matrix[i][j] = 0; //0으로 초기화
                    }

                    for(int k = 0; k < saveNumber.length; k++){ //정렬
                        if(saveNumber[k] != 0){
                            if(!saveList.isEmpty()) {
                                for(int l = 0; l < saveList.size(); l++){
                                    if(saveList.get(l)[1] > saveNumber[k]) {//나온 개수가 saveNumber가 작은 경우
                                        if(l==0)
                                            saveList.add(0, new Integer[]{k, saveNumber[k]});
                                        else
                                            saveList.add(l, new Integer[]{k, saveNumber[k]});
                                        break;
                                    }
                                    else if(l == saveList.size()-1){ //나온 갯수가 saveNumber가 많은데 마지막일 경우
                                        saveList.add(new Integer[]{k, saveNumber[k]});
                                        break;
                                    }
                                }
                            }else{
                                saveList.add(new Integer[]{k, saveNumber[k]});
                            }
                        }
                    }

                    int sec_j = 0;
                    for(int j = 0; j < saveList.size()*2; j=j+2){
                        if(j==98){
                            matrix[i][j] = saveList.get(sec_j)[0];
                            matrix[i][j+1] = saveList.get(sec_j)[1];
                            break;
                        }else{
                            matrix[i][j] = saveList.get(sec_j)[0];
                            matrix[i][j+1] = saveList.get(sec_j)[1];
                        }
                        sec_j++;
                    }

                    if(i == 0){
                        c_num = saveList.size()*2;
                    }else if(c_num < saveList.size()*2){
                        c_num = saveList.size()*2;
                    }

                    saveList.clear();
                }
            }
            else{//c연산 행<열
                //개수 저장
                int tmp_r_num = r_num;

                for(int i = 0; i < c_num; i++){//열 연산
                    int[] saveNumber = new int[101]; // 나온 갯수(0~99)
                    ArrayList<Integer[]> saveList = new ArrayList<Integer[]>();//순서대로 숫자 저장한 것 //정렬된 리스트

                    for(int j = 0; j < tmp_r_num; j++){
                        if(matrix[j][i] != 0) {
                            saveNumber[matrix[j][i]] += 1;
                        }
                        matrix[j][i] = 0; //0으로 초기화
                    }

                    for(int k = 0; k < saveNumber.length; k++){ //정렬
                        if(saveNumber[k] != 0){
                            if(!saveList.isEmpty()) {
                                for(int l = 0; l < saveList.size(); l++){
                                    if(saveList.get(l)[1] > saveNumber[k]) {//나온 갯수가 List첫번째 숫자 갯수 보다 작은 경우
                                        if(l==0)
                                            saveList.add(0, new Integer[]{k, saveNumber[k]});
                                        else
                                            saveList.add(l, new Integer[]{k, saveNumber[k]});
                                        break;
                                    }
                                    else if(l == saveList.size()-1){ //나온 갯수가 saveNumber가 많은데 마지막일 경우
                                        saveList.add(new Integer[]{k, saveNumber[k]});
                                        break;
                                    }
                                }
                            }else{
                                saveList.add(new Integer[]{k, saveNumber[k]});
                            }
                        }
                    }

                    int sec_i = 0;
                    for(int j = 0; j < saveList.size()*2; j=j+2){
                        if(j==98) {
                            matrix[j][i] = saveList.get(sec_i)[0];
                            matrix[j + 1][i] = saveList.get(sec_i)[1];
                            break;
                        }else {
                            matrix[j][i] = saveList.get(sec_i)[0];
                            matrix[j + 1][i] = saveList.get(sec_i)[1];
                        }
                        sec_i++;
                    }

                    if(i == 0){
                        r_num = saveList.size()*2;
                    }else if(r_num < saveList.size()*2){
                        r_num = saveList.size()*2;
                    }

                    saveList.clear();
                }
            }

//            System.out.println("matrix 프린트 : count = " + count + ", r_num = " + r_num + ", c_num = " + c_num);
//            func.printMatrix(r_num, c_num, matrix);

            count++; //연산 후 count
            if(count > 100){ //연산이 100 이상이라면
                count = -1;
                break;
            }
        }

        //결과
        System.out.println(count);

    }


//    //이차행렬 프린트 함수
//    public void printMatrix(int x_num, int y_num, int[][] state){
//        for(int i = 0; i < x_num; i++){
//            for(int j = 0; j < y_num; j++){
//                System.out.print(state[i][j] + " ");
//            }
//            System.out.println("");
//        }
//    }
}
