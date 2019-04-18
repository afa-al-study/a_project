import java.util.*;

public class _12100 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];
        int[] points = new int[12]; //0부터 2의 11승까지 12개

        for(int i = 0; i < points.length; i++){
            points[i] = i;
        }


//        ArrayList<Integer[]> max = new ArrayList<Integer[]>();
//        max.add(0, new Integer[]{0, 0, 0});

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int tmp = sc.nextInt();
                matrix[i][j] = tmp;
//                points[i] =
//                if(max.get(0)[0] <= tmp){
//                    max.add(0, new Integer[]{tmp, i, j});
//                }
//               max.add(0, new Integer[]{tmp, i, j});

            }
        }

//        Collections.sort(max, new Comparator<Integer[]>() {
//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
//                if(o1[0] > o2[0]){
//                    return -1;
//                }else if(o1[0] < o2[0]){
//                    return 1;
//                }else {
//                    return 0;
//                }
//            }
//        });



        //print
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N; j++){
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println("");
//        }
//
//        for(int i = 0; i < max.size(); i++){
//            System.out.print("{" +max.get(i)[0] + "," + max.get(i)[1] + "," + max.get(i)[2] + "},");
////            for(int j = 0; j < N; j++){
////                System.out.print(matrix[i][j] + " ");
////            }
//            System.out.println("");
//        }
//    }
//
//    public void dfs(int a){}
//
    }
}
