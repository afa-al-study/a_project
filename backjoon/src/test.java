public class test {

    //이차행렬 프린트 함수
    public void printMatrix(int x_num, int y_num, int[][] state){
        for(int i = 0; i < x_num; i++){
            for(int j = 0; j < y_num; j++){
                System.out.print(state[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //일차행렬 프린트 함수
    public void printMatrix2(int x_num, int[] state){
        for(int i = 0; i < x_num; i++){
            System.out.print(state[i] + " ");
        }
    }

    public static void main(String args[]){



    }
}
