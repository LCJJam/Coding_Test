package Q16144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static public boolean A = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int[] data = new int[n];
	    st =new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++) {
	    	data[i] = Integer.parseInt(st.nextToken());
	    }
	    //Math.floor(num);
	    
	    //¿¹Á¦
	    //4
	    //1 2 3 5 PASS
	    //a+b = 1.xxx
	    //a+2b = 2.xxx
	    //a+3b = 3.xxx
	    //a+4b = 5.xxx
	    float Max=data[1]-(data[0]+1); // (Max > data[1]-data[0]-1) // 2
	    float Min=(data[1]+1)-data[0]; // (Min < data[1]-data[0]+1) // 0
	    for(int i=2;i<n+1;i++) {
	    	if((data[i]-data[0]-1)/i > Max) {A=false; break;}
	    	if((data[i]+1-data[0])/i < Min) {A=false; break;}
	    	
	    	Max = Math.min((data[i]-data[0]-1)/i , Max);
	    	Min = Math.max((data[i]+1-data[0])/i, Min);
	    	A=true;
	    }
	    
	    
	    if(A == true) {
	    	System.out.print("pass");
	    } else {
	    	System.out.print("fail");
	    }
	}
}