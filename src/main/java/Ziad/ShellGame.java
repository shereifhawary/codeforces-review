package Ziad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class ShellGame {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("input.txt"));
			
			int pos=sc.nextInt(), x,y;
			boolean[] arr = new boolean[3];
			
			arr[pos-1]=true;
			for(int i=0;i<3;++i){
				x=sc.nextInt();y=sc.nextInt();
				boolean tmp=arr[x-1];
				arr[x-1]=arr[y-1];
				arr[y-1]=tmp;
			}
			
			try {
				PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
				
				for(int i=0;i<3;++i)
					if(arr[i])
						writer.println(i+1);
				
				writer.close();
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
			sc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
