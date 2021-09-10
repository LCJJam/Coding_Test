package QuizBase;

import java.util.Scanner;

public class ScNext {
	static int N,B,C;
	static int[] A = new int[1000000];
	public static void Main(String[] args) {
		Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0;i<N;i++) {
        	A[i] = sc.nextInt();
        }
	}
}
