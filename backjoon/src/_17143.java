import java.util.ArrayList;
import java.util.Scanner;

public class _17143 { //낚시왕 문제

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(); //행
        int C = sc.nextInt(); //열
        int shark_num = sc.nextInt(); //상어 수
//        int[][][][][] s_info = new int[R+1][C+1][1000][5][10001]; //1부터 시작하는건 +1
//        ArrayList<Integer[]> s_info = new ArrayList<>();
        Shark[][] matrix = new Shark[R+2][C+2]; //0으로 벽세워줌
        ArrayList<Shark> sharkList = new ArrayList<>();

        for(int i = 0; i < shark_num; i++){ //shark 넣어주기
            int r = sc.nextInt(); //행
            int c = sc.nextInt(); //열
            int s = sc.nextInt(); //속도
            int d = sc.nextInt(); //방향
            int z = sc.nextInt(); //크기

            Shark shark = new Shark();
            shark.setShark(s, d, z);
            matrix[r][c] = shark;
        }
    }

    public static class Shark{
//        int row;
//        int col;
        int s;
        int d;
        int z;

        public void setShark(int s, int d, int z){
            this.s = s;
            this.d = d;
            this.z = z;
        }

//        public void setRow(int r){
//            this.row = r;
//        }
//        public int returnRow(){
//            return row;
//        }
//        public void setCol(int c){
//            this.col = c;
//        }
//        public int returnCol(){
//            return col;
//        }
//        public void setSpeed(int s){
//            this.speed = s;
//        }
        public int returnSpeed(){
            return s;
        }
//        public void setDir(int d){
//            this.d = d;
//        }
        public int returnDir(){
            return d;
        }
//        public void setZ(int z){
//            this.z = z;
//        }
        public int returnZ(){
            return z;
        }
    }
}
