import java.util.*;

public class _2667 {
    static int[][] matrix;
    static int n;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 지도의 크기
        matrix = new int[n][n];


        for(int i = 0; i < n; i++){
            String k = sc.next();
            for(int j = 0; j < n; j++){
                matrix[i][j] = Integer.valueOf(k.substring(j, j+1));
            }
        }

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        _2667 func = new _2667();

        ArrayList<Integer> sort_number = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 1) {
                    qx.offer(i);
                    qy.offer(j);
//                    System.out.println("qx, qy offer : " + "{" + qx + "," + qy + "}");

                    int l = func.bfs(qx, qy);
                    if(l == 0){ //모서리쪽 x,y가 아니면 자기자신일 때 0이 될 수 있음
                        sort_number.add(l+1);
                    }else {
                        sort_number.add(l);
                    }

//                    }
                }
            }
        }

        Collections.sort(sort_number);
        System.out.println(sort_number.size());
        for(int i = 0; i < sort_number.size(); i++) {
            System.out.println(sort_number.get(i));
        }
    }

    public int bfs(Queue<Integer> qx, Queue<Integer> qy){
        int[] dx = {-1, 0, 1, 0}; //위 오른쪽 아래 왼쪽
        int[] dy = {0, 1, 0, -1};
        int x = 0;
        int y = 0;
        int times = 0;

        _2667 func = new _2667();
        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();

            for(int i = 0; i < dx.length; i++) {
                int x_ = x + dx[i];
                int y_ = y + dy[i];

                if(x_ == n){
                    x_ = n-1;
                }
                if(y_ == n){
                    y_ = n-1;
                }

                if(x_ < 0){
                    x_ = x;
                }
                if(y_ < 0 ){
                    y_ = y;
                }

                if (matrix[x_][y_] == 1) {
                    qx.offer(x_);
                    qy.offer(y_);

                    times++;

                    matrix[x_][y_] = 0;

                }

            }

        }


        return times;
    }
}
