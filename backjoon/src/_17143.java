import java.util.ArrayList;
import java.util.Scanner;

//생각한 것, matrix에 넣지말고 for문 돌때 마다 matrix새로 생성해서 하는것도 나쁘지 않을듯
public class _17143 { //낚시왕 문제

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(); //행
        int C = sc.nextInt(); //열
        int shark_num = sc.nextInt(); //상어 수
//        int[][][][][] s_info = new int[R+1][C+1][1000][5][10001]; //1부터 시작하는건 +1
//        ArrayList<Integer[]> s_info = new ArrayList<>();
        Shark[][] matrix = new Shark[R+2][C+2]; //0으로 벽세워줌 //수조 1~R+1, 1~C+1까지
        Shark[][] matrix2 = new Shark[R+2][C+2]; //0으로 벽세워줌 //수조 1~R+1, 1~C+1까지

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
        //사람이
        for(int i = 1; i <= R; i++){
            //R+1이거나 0일때는 벽
            //C+1이거나 0일때는 벽
            //i와 가까운 상어 포획
            for(int j = 1; j <= R; j++){ //땅과 가까운 상어 포획
                if(matrix[j][i].getRow() != 0){
                    cnt += matrix[j][i].getZ();
                    sharkList.remove(matrix[j][i]); //list에서 상어삭제
                    matrix[j][i].setShark(0, 0, 0,0,0); //삭제

                }
            }
            //상어 이동

            for(int j = 0; j < sharkList.size(); j++){
                Shark shark;
                shark = sharkList.get(0);
                //dir가 위, 아래 인지
                //좌우,  col -, +
                int r = shark.getRow();
                int c = shark.getCol();
                int s = shark.getSpeed();
                int d = shark.getDir();
                int z = shark.getZ();
                if(shark.getDir()==1){ //위 //1,2는 row만 변경

                }
                if(shark.getDir()==2){ //아래

                }
                if(shark.getDir() == 3){ //오른쪽 //3,4는 column만 변경
                    c = shark.getCol() + shark.getSpeed();
                    if(c > C){
                        if(shark.getSpeed()-(C-shark.getCol()) > C-1){

                                //짝수였을 때
                            if((shark.getSpeed()-(C-shark.getCol()))/(C-1)%2 == 0){//반대
                                c = 1+ ((shark.getSpeed()-(C-shark.getCol()))%(C-1));

                                shark.setDir(4);
                            }else{  //홀수였을 때
                                c = C - ((shark.getSpeed()-(C-shark.getCol()))%(C-1));

                                shark.setDir(3);
                            }

                        }else{
                            c = C -(shark.getSpeed()-(C-shark.getCol()));
                            shark.setDir(4);
                        }
                    }

                }
                if(shark.getDir() == 4) { //왼쪽
//                    r = shark.getSpeed() - shark.getRow();
                    c = shark.getCol() - shark.getSpeed();
                    if(c <= 0){
                        if(shark.getSpeed()-(shark.getCol()-1) > (C-1)){ //Speed-Row-1한 것이 column-1보다 클 때

                            if((((shark.getSpeed()-(shark.getCol()-1))/(C-1))%2) == 0){ //짝수면 반대 방향
                                c = 1 + ((shark.getSpeed() - (shark.getCol()-1))%(C-1));
                                shark.setDir(3);
                            }else{
                                c = C- ((shark.getSpeed() - (shark.getCol()-1))%(C-1));
                                shark.setDir(4);
                            }
//                            c = 1 + ((shark.getSpeed() - (shark.getCol()-1))%(C+1));
//
//                            if((((shark.getSpeed()-(shark.getCol()-1))/(C+1))%2) == 0){ //짝수면 반대 방향
//                                shark.setDir(3);
//                            }else{
//                                shark.setDir(4);
//                            }
                        }
                        else {
                            c = 1 + (shark.getSpeed() - (shark.getCol()-1));
                            shark.setDir(3); //한번만 방향전환 했기 때문에
                        }
                    }
                    shark.setCol(c); //column 바꾸기

                }
                //새로운 matrix에 상어 준비 tmp로 만들어야 하나 그것은 모르게따
                matrix2[shark.getRow()][shark.getCol()] = shark;

            }

            //움직였는데 이미 상어가 있다? Z비교 후 큰걸로 대체

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
