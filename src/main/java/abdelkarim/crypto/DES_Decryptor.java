package crypto;

public class DES_Decryptor extends DES{
	DES_Key DES_key;
	StringBuilder left[] = new StringBuilder[17];
	StringBuilder right[]= new StringBuilder[17];

	public DES_Decryptor(String key) {
		DES_key = new DES_Key(key);
	}
	
	StringBuilder calculate_S(StringBuilder six_bits, int [] S){
		StringBuilder result = new StringBuilder();
		int r=0,c=0;
		r*=2;
		if(six_bits.charAt(0) == '1'){r+=1;}
		r*=2;
		if(six_bits.charAt(5) == '1'){r+=1;}
		for(int index=1;index<5;index++){
			c*=2;
			if(six_bits.charAt(index) == '1')c++;
		}
		
		int val = S[r * 16 + c];
		
		StringBuilder result_reversed = new StringBuilder();
		for(int it=0;it<4;it++){
			if(val%2 == 0) result_reversed.append('0');
			else result_reversed.append('1');
			val/=2;
		}
		
		for(int index=3;index>=0;index--)
			result.append(result_reversed.charAt(index));
		
		return result;
	}
	
	StringBuilder F(StringBuilder R, StringBuilder K){
		StringBuilder after_E = permute(R, E);
		StringBuilder after_xor = xor(after_E, K);
		StringBuilder after_S_boxes = new StringBuilder();
		int S_box_id = 1;
		for(int i=0;i<after_xor.length();i+=6){
			
			StringBuilder six_bits = new StringBuilder();
			
			for(int index=0;index<6;index++)
				six_bits.append(after_xor.charAt(i+index));
			
			if(S_box_id == 1)
				after_S_boxes.append(calculate_S(six_bits, S1));
			else if (S_box_id == 2)
				after_S_boxes.append(calculate_S(six_bits, S2));
			else if (S_box_id == 3)
				after_S_boxes.append(calculate_S(six_bits, S3));
			else if (S_box_id == 4)
				after_S_boxes.append(calculate_S(six_bits, S4));
			else if (S_box_id == 5)
				after_S_boxes.append(calculate_S(six_bits, S5));
			else if (S_box_id == 6)
				after_S_boxes.append(calculate_S(six_bits, S6));
			else if (S_box_id == 7)
				after_S_boxes.append(calculate_S(six_bits, S7));
			else if (S_box_id == 8)
				after_S_boxes.append(calculate_S(six_bits, S8));
			S_box_id++;
		}
		
		return permute(after_S_boxes, P);
	}
	
	StringBuilder xor (StringBuilder s1, StringBuilder s2){
		StringBuilder result =  new StringBuilder();
		for(int index=0;index<s1.length();index++){
			if(s1.charAt(index) == s2.charAt(index))
				result.append("0");
			else 
				result.append("1");
		}
		return result;
	}
	
	String decrypt_64(String cipher_text){
		StringBuilder plain_text = new StringBuilder();
		StringBuilder after_IP = permute(new StringBuilder(cipher_text), IP);
		left[0] = new StringBuilder();
		right[0] = new StringBuilder();
		split(after_IP, left[0], right[0]);
		for(int i=1;i<17;i++){
			left[i] = right[i-1];
			right[i] = xor(left[i-1],F(right[i-1],DES_key.keylist[17-i] )  );
		}
		StringBuilder before_IP1 = new StringBuilder(right[16].toString() + left[16].toString());
		plain_text = permute(before_IP1, IP1);
		return plain_text.toString();
	}
	
	String decryp(String cipher_text){
		StringBuilder plain_text = new StringBuilder();
		Converter conv = new Converter();
		for(int i=0;i<cipher_text.length();i+=16){
			StringBuilder text_64bits = new StringBuilder();
			for(int index=0;index<16;index++){
				text_64bits.append(conv.formHexadecimalDegitToBinary(cipher_text.charAt(index+i)));
			}
			plain_text.append(decrypt_64(text_64bits.toString()));
		}
		return conv.fromBinaryToString(plain_text);
	}
	
	void display(){
		for(int i=1;i<17;i++){
			System.out.printf("L%-2d: %s\n",i,left[i]);
			System.out.printf("R%-2d: %s\n",i,right[i]);
		}
	}
	
	public static void main(String [] args){
		DES_Encryptor enc = new DES_Encryptor("0001001100110100010101110111100110011011101111001101111111110001");
		String tmp = enc.encrypt_64("0000000100100011010001010110011110001001101010111100110111101111");
		System.out.println(tmp);
		DES_Decryptor dec = new DES_Decryptor("0001001100110100010101110111100110011011101111001101111111110001");
		System.out.println(dec.decrypt_64(tmp));
	}
	//0000000100100011010001010110011110001001101010111100110111101111
	//0000000100100011010001010110011110001001101010111100110111101111

}
