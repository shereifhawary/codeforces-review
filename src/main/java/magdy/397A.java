import java.util.Scanner;


public class Main {
    public static void main(String... args) {
        int []arr = new int[101];
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), i, l = 0, r = 0;

        for (i = 0; i < n; ++i) {
            if (i == 0) {
                l = in.nextInt();
                r = in.nextInt();
            } else {
                int L, R;
                L = in.nextInt();
                R = in.nextInt();
                ++arr[L];
                --arr[R];
            }
        }

        int sum = 0;
        for (i = 0; i < 101; ++i) {
            sum += arr[i];
            arr[i] = sum;
        }

        int ans = 0;
        for (i = l; i < r; ++i) {
            if (arr[i] == 0) ++ans;
        }

        System.out.println(ans);
    }
}
