package Omar;

import java.util.Scanner;

public class Chord {

    private static int XtoY(String x, String y) {
        String notes[] = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"};

        boolean count = false;
        int counter = 0;
        for (int i = 0; ; i++) {
            if (i == 12) i = 0;

            if (x.equals(notes[i])) {
                count = true;
            }
            if (y.equals(notes[i]) && count) return counter;
            if (count) counter++;

        }
    }

    public static void main(String... args) {
        Scanner input = new Scanner(System.in);
        String a = input.next(), b = input.next(), c = input.next();
        boolean major = false, minor = false;
        // a b c
        if (XtoY(a, b) == 4 && XtoY(b, c) == 3) major = true;
        if (XtoY(a, b) == 3 && XtoY(b, c) == 4) minor = true;
        // a c b
        if (XtoY(a, c) == 4 && XtoY(c, b) == 3) major = true;
        if (XtoY(a, c) == 3 && XtoY(c, b) == 4) minor = true;
        // b a c
        if (XtoY(b, a) == 4 && XtoY(a, c) == 3) major = true;
        if (XtoY(b, a) == 3 && XtoY(a, c) == 4) minor = true;
        // b c a
        if (XtoY(b, c) == 4 && XtoY(c, a) == 3) major = true;
        if (XtoY(b, c) == 3 && XtoY(c, a) == 4) minor = true;
        // c a b
        if (XtoY(c, a) == 4 && XtoY(a, b) == 3) major = true;
        if (XtoY(c, a) == 3 && XtoY(a, b) == 4) minor = true;
        // c b a
        if (XtoY(c, b) == 4 && XtoY(b, a) == 3) major = true;
        if (XtoY(c, b) == 3 && XtoY(b, a) == 4) minor = true;

        if (major) {
            System.out.println("major");
        } else if (minor) {
            System.out.println("minor");
        } else {
            System.out.println("strange");
        }
    }
}
