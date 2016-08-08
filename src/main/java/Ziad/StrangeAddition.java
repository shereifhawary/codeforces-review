package Ziad;

import java.util.Scanner;


public class StrangeAddition {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n=sc.nextInt(), sz=0, num = -1;
		
		int[] arr = new int[4];
		
		for(int i=0;i<4;++i)arr[i] = -1;
		
		for(int i=0;i<n;++i){
			int x=sc.nextInt();
			
			if(x==0){
				if(arr[0]==-1)arr[0]=1;
				else ++arr[0];
			}
			if(x>0 && x<10)arr[1] = x;
			if(x>=10 && x<100){
				if(x%10==0)
					arr[2] = x;
				
				else
					num = x;
			}
			if(x==100)arr[3] = x;
		}
		
		for(int i=1;i<4;++i)
			if(arr[i]!=-1)
				++sz;
		
		if(num!=-1 && (sz==0 || (sz==1 && arr[3]!=-1))){
			arr[2] = num;
			++sz;
		}
		
		if(arr[0]>0)sz+=arr[0];
		System.out.println(sz);
		
		while(arr[0]>0){
			--arr[0];
			System.out.print("0 ");
		}
		
		for(int i=1;i<4;++i){
			if(arr[i]!=-1)			
				System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		sc.close();
	}
	
	public static boolean check(int x){
		if(x==0)return true;
		
		while(x>0){
			if(x%10==0)
				return true;
			
			x/=10;
		}
		return false;
	}
}
