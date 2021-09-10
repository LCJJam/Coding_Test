package QuizTest;

import java.io.*;
import java.util.StringTokenizer;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] map = new int[N];
		st =new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			map[i] = Integer.parseInt(st.nextToken()); 
		}
		int Min = 40000;
		//MinSum(Start,End,Sum,K,map)
		
		for(int i=0;i<N-K+1;i++) {
			Min = Math.min(Min, MinSum(i+1,N-1,N,Panalty(0,i,map),K-1,map));
			System.out.println("Min:"+Min);
		}
		
		System.out.println(Min);
		
		//K 개의 부분배열
		//1 .. ? .. ? .. ?
		//부분 배열 당 패널티
		//모든 부분 패널티 합
		//
	}
	// 6 2
	// 1 7 9 13 22 35 
	//
	//Start / End / N / Sum / K / map
	// 1,5,6,0,1,map
	// 1 3 (2번)
	//
	// 2,3,4,0+0,1,map
	
	//6 3
	//1 3 7 8 13 22
	
	
	static int MinSum(int Start,int End,int N,int Sum, int K,int[] map) {
		
		if(K == 1) {
			Sum += Panalty(Start,N-1,map);
			System.out.println("last:" + Start + "~" + (N-1));
			System.out.println(K+"-th.. Sum:"+Sum);
			return Sum;
		}
		int Min = 40000;
		for(int i=Start;i<N-K+1;i++) {
			Min = Math.min(Min, MinSum(i+1,N-1,N,Sum+Panalty(Start,i,map),K-1,map));
		}
		//Sum += Min;
		
		return Min;
	}
	static int Panalty(int Start,int End,int[] map) {
		//System.out.println(map[End]-map[Start]);
		return map[End]-map[Start];
	}
}