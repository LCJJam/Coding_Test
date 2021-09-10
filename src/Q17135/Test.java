package Q17135;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Test {
	static int odd = 0;
	static int even = 0;
	static int all =0;
	public static void main(String[] args) throws IOException {
		//long st1 = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char[] arr = new char[(int) Math.sqrt(1E9+1)];
		even=0; odd=0;
		for(int x=1;x<(int)Math.sqrt(1E9+1);x++) {
			///System.out.println("k:"+k);
			int k = (int) Math.sqrt(1E9+1);
			all = 0;
			int p = x;
			while(p%2==0) {
				p = p/2;
				all++;
			}
			for(int j=3;j<=k;j=j+2) {
				while(p%j == 0) {
					p=p/j;
					all++;
				}
				if(p==1) break;
			}
			if (all%2 == 0){
				odd++;
	        } else {
	        	even++;
	        }
			if(odd > even) {
				arr[x] = 'E';
			} else {
				arr[x] = 'O';
			}
		}
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			bf.append(arr[l]+"\n");
		}
		//System.out.println("odd:"+odd +" : "+"even:"+even);
		
		bf.flush();
		
		//System.out.println("소요시간 "+(System.currentTimeMillis() - st1)+"ms");
    }
}