package abdou;

import java.util.Scanner;

/**
 * Created by fox on 24/07/2016.
 */
public class ANineteen {
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String word = "nineteen";
        char letter [] = new char[26];
        int ans = 0;

        for(int i = 0 ; i < s.length() ; i++){
            letter[s.charAt(i)-'a']++;
        }

        while(true){
            boolean found = true;
            for(int i = (ans != 0?1:0)  ; i < word.length() && found ; i++){
                if(letter[word.charAt(i)-'a'] == 0){
                    found = false;
                }
                letter[word.charAt(i)-'a']--;
            }
            if(found){
                ans++;
            }
            else{
                break;
            }
        }

        System.out.println(ans);
    }
}
