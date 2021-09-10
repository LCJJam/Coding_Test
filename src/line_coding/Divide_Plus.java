package line_coding;

public class Divide_Plus {
	static int min = Integer.MAX_VALUE;
	static int answer = 0;
	public static void main(String[] args) {
		int n = 73425;
		int idx = 0;
		idx = div_plus(idx,n);
		
		System.out.println(idx+" "+answer);

	}
	
	public static int div_plus(int idx,int n) {
		if(n / 10 == 0) { return idx; }
		idx += 1;
		int div = n;
		int k=0;
		while(div != 0) {
			div = div/10;
			k++;
		}
		
		for(int i=1;i<k;i++) {
			int p = n / (10*i) + n % (10*i);
			if(min > div_plus(idx,p)) {
				min = div_plus(idx,p);
				answer = p;
			}
		}
		idx = min;
		return idx;
	}
	
}
