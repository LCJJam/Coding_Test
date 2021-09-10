package Q17825;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] move = new int[10];
		for(i=0;i<10;i++) move[i]=Integer.parseInt(st.nextToken());
		//jump[ScorePosition][dice]
		int[][] jump = { {0,1,2,3,4,5}, //0번자리 
				{2,2,3,4,5,9}, //1번자리 
				{4,3,4,5,9,10}, //2번자리 
				{6,4,5,9,10,11}, //3번자리
				{8,5,9,10,11,12},//4번자리
				{10,6,7,8,20,29},//5번자리
				{13,7,8,20,29,30}, //6번자리
				{16,8,20,29,30,31}, //7번자리
				{19,20,29,30,31,32}, //8번자리
				{12,10,11,12,13,14}, //9번자리
				{14,11,12,13,14,15}, //10번자리
				{16,12,13,14,15,16}, //11번자리
				{18,13,14,15,16,17}, //12번자리
				{20,18,19,20,29,30}, //13번자리
				{22,15,16,17,24,25}, //14번자리
				{24,16,17,24,25,26}, //15번자리
				{26,17,24,25,26,27}, //16번자리
				{28,24,25,26,27,28}, //17번자리
				{22,19,20,29,30,31}, //18번자리
				{24,20,29,30,31,32}, //19번자리
				{25,29,30,31,32,32}, //20번자리
				{26,20,29,30,31,32}, //21번자리
				{27,21,20,29,30,31}, //22번자리
				{28,22,21,20,29,30}, //23번자리
				{30,23,22,21,20,29}, //24번자리
				{32,26,27,28,31,32}, //25번자리
				{34,27,28,31,32,32}, //26번자리
				{36,28,31,32,32,32}, //27번자리
				{38,31,32,32,32,32}, //28번자리
				{30,30,31,32,32,32}, //29번자리
				{35,31,32,32,32,32}, //30번자리
				{40,32,32,32,32,32}, //31번자리
				{0,32,32,32,32,32} //32번자리 
		};
		int dice = 1;
		
		//Jump
		//horses[0].pos = jump[horses[0].pos][dice];
		//horses[0].score += jump[horses[0].pos][0];
		int[] str = {3,4,5,6};
		for(int a : str) {
			System.out.println(a);
		}
		
		
		// 10개중 1개 선택.
		// 말4개중 1개 선택.
		
		//게임판에 적힌 화살표의 방향대로만 이동 가능
		
		//파란판에서 시작할 경우 파란 화살표로 이동해야 한다.
		
		//파란판을 지나갈때는 빨간색 화살표 방향으로 이동.
		
		//이동하려는 칸에 이미 말이 있는경우 그 칸으로 이동 불가.
		
		//시작 /도착 칸은 이동 가능.
		
		//말이 이동을 마칠때 그 칸에있는 점수 추가.
		
		//말이 이동하려고 하는 칸이 도착을 넘어가는 경우 도착에서 이동을 마침.
		
		//주사위에서 나올 수 10개를 미리 알고 있을때, 얻을 수 있는 점수의 최댓값을 구해보자.
	}
	static horse[] horses = new horse[4];
	static class horse {
        int score ;
        int pos ;
        int num;
        
        public horse(int num) {
            this.num = num;
            this.score = 0;
            this.pos = 0;
        }
	}
	
}
