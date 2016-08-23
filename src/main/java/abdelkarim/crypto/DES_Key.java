package crypto;

public class DES_Key extends DES{
	StringBuilder keylist[] = new StringBuilder [17];
	StringBuilder left[]  = new StringBuilder [17];
	StringBuilder right[] = new StringBuilder [17];
	
	public DES_Key(String key0) {
		keylist[0] = new StringBuilder(key0);
		generate_the_key_list();
	}
	
	StringBuilder do_left_shift(StringBuilder str, int l){
		StringBuilder result = new StringBuilder();
		for(int i=l;i<str.length();i++)
			result.append(str.charAt(i));
		for(int i=0;i<l;i++)
			result.append(str.charAt(i));
		return result;
	}
	
	void generate_the_key_list(){
		StringBuilder tmp = permute(keylist[0], PC1);
		left[0] = new StringBuilder();
		right[0] = new StringBuilder();
		split(tmp, left[0], right[0]);
		for(int i=1;i<17;i++){
			left[i] = new StringBuilder();
			right[i] = new StringBuilder();
			left[i] = do_left_shift(left[i-1], left_shift[i-1]);
			right[i]= do_left_shift(right[i-1],left_shift[i-1]);
		}
		for(int i=1;i<17;i++){
			tmp = new StringBuilder(left[i].toString() + right[i].toString());
			keylist[i] = permute(tmp, PC2);
		}
	}
	
	
	void display(){
		for(int i=1;i<17;i++){
			System.out.printf("%2d %s\n", i, keylist[i]);
		}
	}
	
	public static void main(String [] args){
		
		String exampl_key = "0001001100110100010101110111100110011011101111001101111111110001";
		
		DES_Key DES_key = new DES_Key(exampl_key);
		DES_key.display();
	}
}

