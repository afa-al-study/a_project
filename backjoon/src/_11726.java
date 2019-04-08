import java.util.Scanner;

public class _11726 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrays = new int[1001];
        arrays[0] = 1;
        arrays[1] = 2;

        int num = sc.nextInt();

        for(int i = 2; i < num; i++){
            arrays[i] = (arrays[i-1] + arrays[i-2])%10007;
        }

        System.out.println(arrays[num-1] + "");

    }
}
