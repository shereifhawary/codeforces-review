package Nada;

import java.util.Scanner;

/**
 * Created by Nada on 8/1/16.
 */
public class Chords {
    static String vec[]={"C","C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"};
    static String X, Y, Z;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        X = reader.next();
        Y = reader.next();
        Z = reader.next();
        boolean strange = false;
        for (int i = 0; i+7 < 24; i++)
        {
            if ((vec[i].equals(X) && vec[i + 3].equals(Y) && vec[i + 7].equals(Z)) || (vec[i].equals(Y) && vec[i + 3].equals(Z) && vec[i + 7].equals(X)) || (vec[i].equals(Z) && vec[i + 3].equals(X) && vec[i + 7].equals(Y)) || (vec[i].equals(X) && vec[i + 3].equals(Z) && vec[i + 7].equals(Y)) || (vec[i].equals(Y) && vec[i + 3].equals(X) && vec[i + 7].equals(Z)) || (vec[i].equals(Z) && vec[i + 3].equals(Y) && vec[i + 7].equals(X)))
            {
                System.out.println("minor");
                strange = false;
                break;
            }
            else if ((vec[i].equals(X) && vec[i + 4].equals(Y) && vec[i + 7].equals(Z)) || (vec[i].equals(Y) && vec[i + 4].equals(Z) && vec[i + 7].equals(X)) || (vec[i].equals(Z) && vec[i + 4].equals(X) && vec[i + 7].equals(Y)) || (vec[i].equals(X) && vec[i + 4].equals(Z) && vec[i + 7].equals(Y)) || (vec[i].equals(Y) && vec[i + 4].equals(X) && vec[i + 7].equals(Z)) || (vec[i].equals(Z) && vec[i + 4].equals(Y) && vec[i + 7].equals(X)))
            {
                System.out.println("major");
                strange = false;
                break;
            }
            else
                strange = true;
        }
        if (strange==true)
            System.out.println("strange");
    }
}
