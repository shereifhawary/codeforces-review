package yusufhussein;

import java.util.Scanner;

/**
 * Created by Yusuf on 7/24/2016.
 */
public class A393 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String myWord = new String("nineteen");
        String inWord = input.next();
        int cnt[] = new int[26];
        for (int i = 0; i < inWord.length(); ++i) {
            ++cnt[inWord.charAt(i) - 'a'];
        }
        int out = (cnt['n' - 'a'] - 1) / 2;
        out = Math.min(cnt['e' - 'a'] / 3, out);
        out = Math.min(cnt['t' - 'a'], out);
        out = Math.min(cnt['i' - 'a'], out);
        System.out.println(out);
    }
}