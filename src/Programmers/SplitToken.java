package Programmers;

import java.util.Arrays;

public class SplitToken {

	public static void main(String[] args) {
		String str = "1 2 3 4";
		String []token = str.split(" ");
		int []Num = new int[token.length];
		for(int i=0 ; i < token.length ; i++) {
			Num[i] = Integer.parseInt(token[i]);
		}
		Arrays.sort(Num);
		
		System.out.println(Num[0]+" "+Num[Num.length-1]);
	}

}
