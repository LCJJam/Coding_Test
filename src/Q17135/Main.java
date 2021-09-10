package Q17135;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[][] Map = new int[N][M];
		int[][] Map2 = new int[N][M];
		
		for(int i=0;i<N;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=0;j<M;j++) {
	    		Map[i][j] = Integer.parseInt(st.nextToken());
	    		Map2[i][j] = Map[i][j];
	    	}
	    }
		int max = 0;
		// 궁수 배치
		int[] Archer = new int[3];
		for(int i=0;i<M-2;i++) {
			for(int j=i+1;j<M-1;j++) {
				for(int k=j+1;k<M;k++) {
					count = 0;
					Archer[0] = i; Archer[1] =j; Archer[2] =k;
					//System.out.println(Archer[0]+" "+Archer[1]+" "+Archer[2]);
					Go(Map2,Archer,D,N,M,1);
					max = Math.max(max, count);
					for(int x=0;x<N;x++) {
				    	for(int y=0;y<M;y++) {
				    		Map2[x][y] = Map[x][y];
				    	}
				    }
					//System.out.println(count);
					//System.out.println();
					//System.out.println();
				}
			}
		}
		
		System.out.println(max);
		
	}
	public static void Go(int[][] Map,int[] Archer,int D,int N,int M,int depth) {
		// 턴 시작
		if(depth == N+1) {
			//System.out.println(count+" ");
			return;
		}
		// 왼쪽부터 , 같은 적이 여러 궁수에게 공격당할 수 있다. 공격받은 적은 게임에서 제외된다.
		int[][] kill = new int[3][2];
		
		// 1번 아처
		loop:
		for(int x=1;x<=D;x++) { // 범위가 x 일때
			for(int j=0;j<M;j++) { // 왼쪽 열부터 시작
				for(int i=N-1;i>0;i--) { // 행을 범위 안으로 찾아봄.
					if(  (N-i)+Math.abs(Archer[0]-j) <= x  ) {
						if(Map[i][j] == 1) {
							kill[0][0] = i;
							kill[0][1] = j;
							break loop;
						}
					}
				}
			}
		}
		
		loop:
		for(int x=1;x<=D;x++) {
			for(int j=0;j<M;j++) {
				for(int i=N-1;i>0;i--) {
					if(  (N-i)+Math.abs(Archer[1]-j) <= x  ) {
						if(Map[i][j] == 1) {
							kill[1][0] = i;
							kill[1][1] = j;
							//System.out.println("Kill 1");
							break loop;
						}
					}
				}
			}
		}
		
		loop:
		for(int x=1;x<=D;x++) {
			for(int j=0;j<M;j++) {
				for(int i=N-1;i>0;i--) {
					if(  (N-i)+Math.abs(Archer[2]-j) <= x  ) {
						if(Map[i][j] == 1) { 
							kill[2][0] = i;
							kill[2][1] = j;
							//System.out.println("Kill 2");
							break loop;
						}
					}
				}
			}
		}
		
		
		if(Map[kill[0][0]][kill[0][1]] == 1 && kill[0][0] != 0 ) {
			Map[kill[0][0]][kill[0][1]] = 0;
			count++;
		}if(Map[kill[1][0]][kill[1][1]] == 1 && kill[1][0] != 0 ) {
			Map[kill[1][0]][kill[1][1]] = 0;
			count++;
		}if(Map[kill[2][0]][kill[2][1]] == 1 && kill[2][0] != 0 ) {
			Map[kill[2][0]][kill[2][1]] = 0;
			count++;
		}
		// 궁수의 공격이 끝나면, 적이 이동한다. 적은 아래로 한 칸 이동하며
		for(int i=N-1;i>0;i--) {
			for(int j=0;j<M;j++) {
				Map[i][j] = Map[i-1][j];
				Map[i-1][j] = 0;
			}
		}
		// 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다. 		
				
		//턴 종료
		Go(Map,Archer,D,N,M,depth+1);
	}
	
}