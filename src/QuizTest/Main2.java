package QuizTest;

import java.util.StringTokenizer;
import java.io.*;
public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<test;i++){
			st =new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int map[][][] = new int[i][M][N];
		}
	}

}
