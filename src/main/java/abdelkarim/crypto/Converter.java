package crypto;

public class Converter {
	
	char hexadecimal_digits[]= {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	
	int formHexadecimalDigitToInt(char c){
		if('0' <= c && c <= '9')
			return c-'0';
		else 
			return c-'a'+10;
	}
	
	StringBuilder formHexadecimalDegitToBinary(char c){
		int val = formHexadecimalDigitToInt(c);
		return fromIntToBinary(val);
	}
	
	StringBuilder fromHexadecimalToBinary(StringBuilder hexadecimal){
		StringBuilder binary = new StringBuilder();
		for(int index=0;index<hexadecimal.length();index++)
			binary.append(fromIntToBinary(formHexadecimalDigitToInt(hexadecimal.charAt(index)) ));
		return binary;
	}
	
	StringBuilder fromBinaryToHexadecimal(StringBuilder binary){
		StringBuilder hexadecimal = new StringBuilder();
		
		for(int i=0;i<binary.length();i+=4){
			StringBuilder fourBits = new StringBuilder();
			for(int index=0;index<4;index++){
				fourBits.append(binary.charAt(index+i) );
			}
			hexadecimal.append(hexadecimal_digits[ fromBinaryToInt(fourBits) ]);
		}
		return hexadecimal;
	}
	
	StringBuilder fromCharToBinary(char c){
		
		StringBuilder result = new StringBuilder();
		StringBuilder result_reversed = new StringBuilder();
		
		int tmp = c;
		for(int i=0;i<8;i++){
			if(tmp%2 == 0)
				result_reversed.append("0");
			else 
				result_reversed.append("1");
			tmp /= 2;
		}
		
		for(int index=7;index>=0;index--)
			result.append(result_reversed.charAt(index));
		
		return result;
	}
	
	
	StringBuilder fromIntToBinary(int x){
		
		StringBuilder result = new StringBuilder();
		StringBuilder result_reversed = new StringBuilder();
		for(int i=0;i<4;i++){
			if(x%2 == 0)
				result_reversed.append("0");
			else 
				result_reversed.append("1");
			x /= 2;
		}
		
		for(int index=3;index>=0;index--)
			result.append(result_reversed.charAt(index));
		return result;
	}
	
	
	char fromBinaryToChar(StringBuilder eight_bits){
		int result = 0;
		for(int i=0;i<eight_bits.length();i++){
			result *= 2;
			if(eight_bits.charAt(i)== '1')
				result++;
		}
		return (char)result;
	}
	
	String fromBinaryToString(StringBuilder binary){
		StringBuilder string = new StringBuilder();
		for(int i=0;i<binary.length();i+=8){
			StringBuilder eight_bits = new StringBuilder();
			for(int index=0;index<8;index++){
				eight_bits.append(binary.charAt(index+i));
			}
			string.append(fromBinaryToChar(eight_bits));
		}
		return string.toString();
	}
	
	int fromBinaryToInt(StringBuilder eight_bits){
		int result = 0;
		for(int i=0;i<eight_bits.length();i++){
			result *= 2;
			if(eight_bits.charAt(i)== '1')
				result++;
		}
		return result;
	}
	
	public static void main(String [] args){
		Converter conv = new Converter();
		StringBuilder tmp = conv.fromCharToBinary(':');
		System.out.println(tmp);
		System.out.println(conv.fromBinaryToChar(tmp));
		tmp = conv.fromIntToBinary(2);
		System.out.println(tmp);
		System.out.println(conv.fromBinaryToInt(tmp));
		tmp = conv.fromHexadecimalToBinary(new StringBuilder("abc02") );
		System.out.println(tmp);
		System.out.println(conv.fromBinaryToHexadecimal(tmp));
	}
}
