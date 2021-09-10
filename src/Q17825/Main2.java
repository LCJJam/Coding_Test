package Q17825;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {
	
    //현재위치에서 주사위를 굴렸을때 이동할 위치 미리 정해둠
	static int[][] map = {{0,1,2,3,4,5},
			{1,2,3,4,5,6},
			{2,3,4,5,6,7},
			{3,4,5,6,7,8},
			{4,5,6,7,8,9},
			{5,21,22,23,29,30},
			{6,7,8,9,10,11},
			{7,8,9,10,11,12},
			{8,9,10,11,12,13},
			{9,10,11,12,13,14},
			{10,27,28,29,30,31},
			{11,12,13,14,15,16},
			{12,13,14,15,16,17},
			{13,14,15,16,17,18},
			{14,15,16,17,18,19},
			{15,24,25,26,29,30},
			{16,17,18,19,20,32},
			{17,18,19,20,32,32},
			{18,19,20,32,32,32},
			{19,20,32,32,32,32},
			{20,32,32,32,32,32},
			{21,22,23,29,30,31},
			{22,23,29,30,31,20},
			{23,29,30,31,20,32},
			{24,25,26,29,30,31},
			{25,26,29,30,31,20},
			{26,29,30,31,20,32},
			{27,28,29,30,31,20},
			{28,29,30,31,20,32},
			{29,30,31,20,32,32},
			{30,31,20,32,32,32},
			{31,20,32,32,32,32},
			{32,32,32,32,32,32}};
    //정해둔 위치에 도착했을 때 더할 점수
	static int[] score = {0,
			2,4,6,8,10,
			12,14,16,18,20,
			22,24,26,28,30,
			32,34,36,38,40,
			13,16,19,28,27,
			26,22,24,25,30,
			35,0};
	static int a=0;
	static int b=0;
	static int c=0;
	static int d=0;
	static int m=0;
	static int[] chk = new int[33];
	static int[] move = new int[10];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(i=0;i<10;i++) move[i]=Integer.parseInt(st.nextToken());
		chk[32]=-10;
		if(move[0]==move[1]) {
        //첫번째와 두번째 이동이 같다면 처음에 이동한말이 한번더 이동해야하는 사실은 자명하다.
			chk[map[move[0]][move[0]]]++;
			a=map[move[0]][move[0]];
			dfs(score[move[0]]+score[a],2);
		}else {
        //첫번째와 두번째 이동이 다르다면 처음이동한말이 이동하거나 새로운말이 이동하는 경우 2가지이다.
			chk[move[0]]++;
			chk[move[1]]++;
			a=move[0];
			b=move[1];
			dfs(score[a]+score[b],2);
			chk[move[0]]--;
			chk[move[1]]--;
			chk[map[move[0]][move[1]]]++;
			a=map[move[0]][move[1]];
			b=0;
			dfs(score[move[0]]+score[map[move[0]][move[1]]],2);
		}
		bw.write(m+"\n");
		br.close();
		bw.close();
	}
	
	static void dfs(int sum, int k) {
		
		if(k==10) {
        //10번 다 돌렸을 경우 최댓값 갱신 후 리턴
			m = Math.max(sum,m);
			return;
		}
		int tmp,tmp2;
		int[] str = {a,b,c,d};
		
		tmp = map[a][move[k]];
		if(chk[tmp]!=1) { // 이동가능 여부 파악
			chk[tmp]++; // 이동한 위치 말 추가
			chk[a]--; // 현재 위치 말 제거
			tmp2=a;
			a=tmp;
			dfs(sum+score[tmp],k+1); // 점수를 더하고 재귀
			a=tmp2;
			chk[a]++; // 현재 위치 말 추가
			chk[tmp]--; //이동한 위치 말 제거
		}
		tmp = map[b][move[k]];
		if(chk[tmp]!=1) {
			chk[tmp]++;
			chk[b]--;
			tmp2=b;
			b=tmp;
			dfs(sum+score[tmp],k+1);
			b=tmp2;
			chk[b]++;
			chk[tmp]--;
		}
		tmp = map[c][move[k]];
		if(chk[tmp]!=1) {
			chk[tmp]++;
			chk[c]--;
			tmp2=c;
			c=tmp;
			dfs(sum+score[tmp],k+1);
			c=tmp2;
			chk[c]++;
			chk[tmp]--;
		}
		tmp = map[d][move[k]];
		if(chk[tmp]!=1) {
			chk[tmp]++;
			chk[d]--;
			tmp2=d;
			d=tmp;
			dfs(sum+score[tmp],k+1);
			d=tmp2;
			chk[d]++;
			chk[tmp]--;
		}
		/*
		for(int a : str) {
			tmp = map[a][move[k]];
		if(chk[tmp]!=1) { // 이동가능 여부 파악
			chk[tmp]++; // 이동한 위치 말 추가
			chk[a]--; // 현재 위치 말 제거
			tmp2=a;
			a=tmp;
			dfs(sum+score[tmp],k+1); // 점수를 더하고 재귀
			a=tmp2;
			chk[a]++; // 현재 위치 말 추가
			chk[tmp]--; //이동한 위치 말 제거
			}
		}
		*/
		
	}
}
