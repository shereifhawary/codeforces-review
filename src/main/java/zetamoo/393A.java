import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.StreamHandler;

/**
 * Created by tdph5945 on 2016-07-24.
 */
public class Main {
    public static void main(String... args) {
        String s=new String();
        Scanner scan = new Scanner(System.in);
        s=scan.next();
        Map<Character,Integer>m=new HashMap<Character, Integer>();
        for(int f=0;f<s.length();f++)
        {
            if(m.containsKey(s.charAt(f)))
                m.put(s.charAt(f),m.get(s.charAt(f))+1);
            else
                m.put(s.charAt(f),1);
        }
        if(!m.containsKey('n')) {
            System.out.println(0);
            return;
        }
        m.put('n',m.get('n')-1);
        String st="ineteen";
        int ans=0;
        while(true)
        {
            Boolean o=false;
            for(int f=0;f<st.length();f++)
            {
                if(!m.containsKey(st.charAt(f))||m.get(st.charAt(f))==0)
                {
                    o=true;
                    break;
                }
                m.put(st.charAt(f),m.get(st.charAt(f))-1);
            }
            if(o)
            {
                System.out.println(ans);
                break;
            }
            ans++;
        }
    }
}