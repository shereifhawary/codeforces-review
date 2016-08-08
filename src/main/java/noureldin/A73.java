package noureldin;

/**
 * Created by noureldin on 7/27/16.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A73 {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static String getNext() throws Exception{
        if(br == null) br = new BufferedReader(new InputStreamReader(System.in));
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    private static String [] tunes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"};
    private static int dist(String a,String b){
        int i = 0,j = 0,ret = 0;
        while(!tunes[i].equals(a)) i++;
        for(j = i;!tunes[j].equals(b);ret++) j = (j + 1)%tunes.length;
        return ret;
    }

    public static boolean isMajor(String a,String b,String c){
        String [] list = {a,b,c};
        int [] [] pos = {
                {0, 1, 2},
                {0, 2, 1},
                {1, 0, 2},
                {1, 2, 0},
                {2, 0, 1},
                {2, 1, 0}
        };
        for (int order = 0;order < 6;order++){
            a = list[pos[order][0]];
            b = list[pos[order][1]];
            c = list[pos[order][2]];
            if(dist(a,b) == 4 && dist(b,c) == 3) return true;
        }
        return false;
    }
    public static boolean isMinor(String a,String b,String c){
        String [] list = {a,b,c};
        int [] [] pos = {
                {0, 1, 2},
                {0, 2, 1},
                {1, 0, 2},
                {1, 2, 0},
                {2, 0, 1},
                {2, 1, 0}
        };
        for (int order = 0;order < 6;order++){
            a = list[pos[order][0]];
            b = list[pos[order][1]];
            c = list[pos[order][2]];
           // System.out.println(a + " " + b + " " + c + " " + dist(a,b) + " " + dist(b,c));
            if(dist(a,b) == 3 && dist(b,c) == 4) return true;
        }
        return false;
    }
    public static void main(String[] args) throws Exception{
        String a = getNext(),b = getNext(),c = getNext();
        String out = "strange";
        if(isMajor(a,b,c)) out = "major";
        else if(isMinor(a,b,c)) out = "minor";
        System.out.println(out);
    }

}
