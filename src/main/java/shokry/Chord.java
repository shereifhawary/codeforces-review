package shokry;

import java.util.Arrays;
import java.util.Scanner;

public class Chord {
    private static final String chords[] = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] notes = new String[3];
        for (int i = 0; i < 3; ++i)
            notes[i] = in.next();
        int indexes[] = {findChord(notes[0]), findChord(notes[1]), findChord(notes[2])};
        Arrays.sort(indexes);
        String ans;
        if (indexes[1] - indexes[0] == 4 && indexes[2] - indexes[1] == 3) {
            ans = "major";
        } else if (indexes[1] - indexes[0] == 3 && indexes[2] - indexes[1] == 4) {
            ans = "minor";
        } else {
            int diff[] = {indexes[1] - indexes[0], indexes[2] - indexes[1], (12 - indexes[2]) + indexes[0]};
            if ((diff[0] == 4 && diff[1] == 3) || (diff[1] == 4 && diff[2] == 3) || (diff[2] == 4 && diff[0] == 3))
                ans = "major";
            else if ((diff[0] == 3 && diff[1] == 4) || (diff[1] == 3 && diff[2] == 4) || (diff[2] == 3 && diff[0] == 4))
                ans = "minor";
            else
                ans = "strange";
        }
        System.out.println(ans);
    }

    private static int findChord(String s) {
        for (int i = 0; i < 12; i++) {
            if (s.equals(chords[i]))
                return i;
        }
        return -1;
    }
}
