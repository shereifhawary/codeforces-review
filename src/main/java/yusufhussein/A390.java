package yusufhussein;

import java.util.*;

/**
 * Created by Yusuf on 7/26/2016.
 * A. Inna and Alarm Clock
 */
public class A390 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashSet<Integer> rows = new HashSet<Integer>();
        HashSet<Integer> columns = new HashSet<Integer>();
        for (int i = 0; i < n; ++i) {
            rows.add(input.nextInt());
            columns.add(input.nextInt());
        }
        System.out.println(Math.min(rows.size(), columns.size()));
    }
}