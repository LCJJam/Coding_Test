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
		// �ü� ��ġ
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
		// �� ����
		if(depth == N+1) {
			//System.out.println(count+" ");
			return;
		}
		// ���ʺ��� , ���� ���� ���� �ü����� ���ݴ��� �� �ִ�. ���ݹ��� ���� ���ӿ��� ���ܵȴ�.
		int[][] kill = new int[3][2];
		
		// 1�� ��ó
		loop:
		for(int x=1;x<=D;x++) { // ������ x �϶�
			for(int j=0;j<M;j++) { // ���� ������ ����
				for(int i=N-1;i>0;i--) { // ���� ���� ������ ã�ƺ�.
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
		// �ü��� ������ ������, ���� �̵��Ѵ�. ���� �Ʒ��� �� ĭ �̵��ϸ�
		for(int i=N-1;i>0;i--) {
			for(int j=0;j<M;j++) {
				Map[i][j] = Map[i-1][j];
				Map[i-1][j] = 0;
			}
		}
		// ���� �ִ� ĭ���� �̵��� ��쿡�� ���ӿ��� ���ܵȴ�. 		
				
		//�� ����
		Go(Map,Archer,D,N,M,depth+1);
	}
	
}