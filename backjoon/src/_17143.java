import java.util.ArrayList;
import java.util.Scanner;

public class _17143 { //낚시왕 문제

    public static void main(String args[]){
//        _17143 func = new _17143();

        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(); //행
        int C = sc.nextInt(); //열
        int shark_num = sc.nextInt(); //상어 수
//        int[][][][][] s_info = new int[R+1][C+1][1000][5][10001]; //1부터 시작하는건 +1
//        ArrayList<Integer[]> s_info = new ArrayList<>();
        Shark[][] matrix = new Shark[R+2][C+2]; //0으로 벽세워줌 //수조 1~R+1, 1~C+1까지

        ArrayList<Shark> sharkList = new ArrayList<>();

        for(int i = 0; i < shark_num; i++){ //shark 넣어주기
            int r = sc.nextInt(); //행
            int c = sc.nextInt(); //열
            int s = sc.nextInt(); //속도
            int d = sc.nextInt(); //방향
            int z = sc.nextInt(); //크기

            Shark shark = new Shark();
            shark.setShark(r, c, s, d, z);
            matrix[r][c] = shark;
            sharkList.add(shark);
        }
        int cnt = 0; //상어 크기 합

        //낚시
        //사람이 움직일 때 i+1
        for(int i = 1; i <=C; i++){
            //R+1이거나 0일때는 벽
            //C+1이거나 0일때는 벽
            //i와 가까운 상어 포획

            Shark[][] matrix2 = new Shark[R+2][C+2]; //0으로 벽세워줌 //수조 1~R+1, 1~C+1까지

//            System.out.println("");
//            System.out.println(i + "번째 잡기 전");
//            func.printMatrix(R+2, C+2, matrix);

            for(int j = 1; j <= R; j++){ //땅과 가까운 상어 포획
                if(matrix[j][i] != null){
//                    System.out.println(i + "번째 잡은 상어 크기 = " + matrix[j][i].getZ());

                    cnt += matrix[j][i].getZ();
                    sharkList.remove(matrix[j][i]); //list에서 상어삭제
                    matrix[j][i].setShark(0, 0, 0,0,0); //삭제
                    break;
                }
            }

//            System.out.println("");
//            System.out.println(i + "번째 잡은 후");
//            func.printMatrix(R+2, C+2, matrix);


            //상어 이동
            for(int j = 0; j < sharkList.size(); j++){
                Shark shark;
                shark = sharkList.get(j);
                //dir가 위, 아래 인지
                //좌우,  col -, +
                int r = shark.getRow();
                int c = shark.getCol();
                int s = shark.getSpeed();
                int d = shark.getDir();
                int z = shark.getZ();

                if(shark.getCol() == C && shark.getDir() == 3){ //현재 맨 오른쪽인데 방향이 오른쪽일 때
                    shark.setDir(4);
                }
                if(shark.getCol() == 1 && shark.getDir() == 4){
                    shark.setDir(3);
                }
                if(shark.getRow() == 1 && shark.getDir() == 1){
                    shark.setDir(2);
                }
                if(shark.getRow() == R && shark.getDir() == 2){
                    shark.setDir(1);
                }

                if(shark.getDir()==1){ //위 //1,2는 row만 변경
                    r = shark.getRow() - shark.getSpeed();
                    if(r <= 0){
                        if(shark.getSpeed()-(shark.getRow()-1) > (R-1)){ //Speed-Row-1한 것이 row-1보다 클 때

                            if((((shark.getSpeed()-(shark.getRow()-1))/(R-1))%2) == 0){ //짝수면 반대 방향
                                r = 1 + ((shark.getSpeed() - (shark.getRow()-1))%(R-1));
                                shark.setDir(2);
                            }else{
                                r = R - ((shark.getSpeed() - (shark.getRow()-1))%(R-1));
                                shark.setDir(1);
                            }
                        }
                        else {
                            r = 1 + (shark.getSpeed() - (shark.getRow()-1));
                            shark.setDir(2); //한번만 방향전환 했기 때문에
                        }
                    }
                    shark.setRow(r); //row 바꾸기
                }
                else if(shark.getDir()==2){ //아래
                    r = shark.getRow() + shark.getSpeed();
                    if(r > R){
                        if(shark.getSpeed()-(R-shark.getRow()) > R-1){

                            //짝수였을 때
                            if(((shark.getSpeed()-(R-shark.getRow()))/(R-1))%2 == 0){//반대
                                r = R - ((shark.getSpeed()-(R-shark.getRow()))%(R-1));
                                shark.setDir(1);

                            }else{  //홀수였을 때
                                r = 1+ ((shark.getSpeed()-(R-shark.getRow()))%(R-1));
                                shark.setDir(2);

                            }
                        }else{
                            r = R -(shark.getSpeed()-(R-shark.getRow()));
                            shark.setDir(1);
                        }
                    }
                    shark.setRow(r);
                }
                else if(shark.getDir() == 3){ //오른쪽 //3,4는 column만 변경

                    c = shark.getCol() + shark.getSpeed();
                    if(c > C){
                        if(shark.getSpeed()-(C-shark.getCol()) > C-1){

                                //짝수였을 때
                            if(((shark.getSpeed()-(C-shark.getCol()))/(C-1))%2 == 0){//반대
                                c = C - ((shark.getSpeed()-(C-shark.getCol()))%(C-1));
                                shark.setDir(4);


                            }else{  //홀수였을 때
                                c = 1+ ((shark.getSpeed()-(C-shark.getCol()))%(C-1));

                                shark.setDir(3);

                            }
                        }else{
                            c = C -(shark.getSpeed()-(C-shark.getCol()));
                            shark.setDir(4);
                        }
                    }
                    shark.setCol(c);

                }
                else if(shark.getDir() == 4) { //왼쪽

                    c = shark.getCol() - shark.getSpeed();
                    if(c <= 0){
                        if(shark.getSpeed()-(shark.getCol()-1) > (C-1)){ //Speed-Column-1한 것이 column-1보다 클 때

                            if((((shark.getSpeed()-(shark.getCol()-1))/(C-1))%2) == 0){ //짝수면 반대 방향
                                c = 1 + ((shark.getSpeed() - (shark.getCol()-1))%(C-1));
                                shark.setDir(3);
                            }else{
                                c = C- ((shark.getSpeed() - (shark.getCol()-1))%(C-1));
                                shark.setDir(4);
                            }

                        }
                        else {
                            c = 1 + (shark.getSpeed() - (shark.getCol()-1));
                            shark.setDir(3); //한번만 방향전환 했기 때문에
                        }
                    }
                    shark.setCol(c); //column 바꾸기

                }


                //움직였는데 이미 상어가 있다? Z비교 후 큰걸로 대체
                if(matrix2[r][c] != null){
                    if(j!=sharkList.size()-1 ) { //마지막 List요소일 때는 j-1해줄 필요 없음
                        j = j - 1;
                    }
                    if(matrix2[r][c].getZ() < shark.getZ()){ //현재 상어의 크기가 클 때
                        sharkList.remove(matrix2[r][c]); //list에서 상어삭제
                        matrix2[r][c] = shark; //변경
                    }else{ //있는 상어가 더 클 때
                        sharkList.remove(shark);
                    }

                }
                else{
                    matrix2[r][c] = shark; //변경
                }

            }//상어 변경 모두 완료
//
//            System.out.println("");
//            System.out.println(i + "번째 이동 후 matrix2");
//            func.printMatrix(R+2, C+2, matrix2);


            for(int j = 1; j <= R; j++){ //배열 깊은 복사
                for(int k = 1; k <= C; k++){
                    matrix[j][k] = matrix2[j][k];

                }
            }

//            System.out.println("");
//            System.out.println(i + "번째 이동 후 matrix1 위에하고 같아야함");
//            func.printMatrix(R+2, C+2, matrix);
        }

        System.out.println(cnt);
    }



    //이차행렬 프린트 함수
    public void printMatrix(int x_num, int y_num, Shark[][] state){
        for(int i = 0; i < x_num; i++){
            for(int j = 0; j < y_num; j++){
                if(state[i][j] != null) {
                    System.out.print("{" + state[i][j].getRow() + "," + state[i][j].getCol() + "," + state[i][j].getSpeed() + "," + state[i][j].getDir() + "," +
                            state[i][j].getZ() + "}");
 //                   System.out.print(state[i][j].getZ() + " ");
                }else{
                    System.out.print(0 + " ");

                }
            }
            System.out.println("");
        }
    }

    public static class Shark{
        int r;
        int c;
        int s;
        int d;
        int z;

        public void setShark(int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }


        public void setRow(int r){
            this.r = r;
        }
        public int getRow(){
            return r;
        }
        public void setCol(int c){
            this.c = c;
        }
        public int getCol(){
            return c;
        }
        public void setSpeed(int s){
            this.s = s;
        }
        public int getSpeed(){
            return s;
        }
        public void setDir(int d){
            this.d = d;
        }
        public int getDir(){
            return d;
        }
        public void setZ(int z){
            this.z = z;
        }
        public int getZ(){
            return z;
        }
    }
}
