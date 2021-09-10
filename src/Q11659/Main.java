package Q11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
        int[] Start = new int[M+1];
        int[] End = new int[M+1];
        int[] A= new int[N+1];
        StringTokenizer st1 =new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++) {
        	A[i] = A[i-1]+Integer.parseInt(st1.nextToken());
        }
        // 5 9 12 14 15
        for(int i=1;i<M+1;i++) {
        	StringTokenizer st2 =new StringTokenizer(br.readLine());
        	Start[i] = Integer.parseInt(st2.nextToken());
            End[i] = Integer.parseInt(st2.nextToken());
        }
        // 1 2 5
        // 3 4 5
        for(int i=1;i<M+1;i++) {
        	System.out.println(A[End[i]]-A[Start[i]-1]);
        }
	}
}