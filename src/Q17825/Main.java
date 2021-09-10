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
		int[][] jump = { {0,1,2,3,4,5}, //0���ڸ� 
				{2,2,3,4,5,9}, //1���ڸ� 
				{4,3,4,5,9,10}, //2���ڸ� 
				{6,4,5,9,10,11}, //3���ڸ�
				{8,5,9,10,11,12},//4���ڸ�
				{10,6,7,8,20,29},//5���ڸ�
				{13,7,8,20,29,30}, //6���ڸ�
				{16,8,20,29,30,31}, //7���ڸ�
				{19,20,29,30,31,32}, //8���ڸ�
				{12,10,11,12,13,14}, //9���ڸ�
				{14,11,12,13,14,15}, //10���ڸ�
				{16,12,13,14,15,16}, //11���ڸ�
				{18,13,14,15,16,17}, //12���ڸ�
				{20,18,19,20,29,30}, //13���ڸ�
				{22,15,16,17,24,25}, //14���ڸ�
				{24,16,17,24,25,26}, //15���ڸ�
				{26,17,24,25,26,27}, //16���ڸ�
				{28,24,25,26,27,28}, //17���ڸ�
				{22,19,20,29,30,31}, //18���ڸ�
				{24,20,29,30,31,32}, //19���ڸ�
				{25,29,30,31,32,32}, //20���ڸ�
				{26,20,29,30,31,32}, //21���ڸ�
				{27,21,20,29,30,31}, //22���ڸ�
				{28,22,21,20,29,30}, //23���ڸ�
				{30,23,22,21,20,29}, //24���ڸ�
				{32,26,27,28,31,32}, //25���ڸ�
				{34,27,28,31,32,32}, //26���ڸ�
				{36,28,31,32,32,32}, //27���ڸ�
				{38,31,32,32,32,32}, //28���ڸ�
				{30,30,31,32,32,32}, //29���ڸ�
				{35,31,32,32,32,32}, //30���ڸ�
				{40,32,32,32,32,32}, //31���ڸ�
				{0,32,32,32,32,32} //32���ڸ� 
		};
		int dice = 1;
		
		//Jump
		//horses[0].pos = jump[horses[0].pos][dice];
		//horses[0].score += jump[horses[0].pos][0];
		int[] str = {3,4,5,6};
		for(int a : str) {
			System.out.println(a);
		}
		
		
		// 10���� 1�� ����.
		// ��4���� 1�� ����.
		
		//�����ǿ� ���� ȭ��ǥ�� �����θ� �̵� ����
		
		//�Ķ��ǿ��� ������ ��� �Ķ� ȭ��ǥ�� �̵��ؾ� �Ѵ�.
		
		//�Ķ����� ���������� ������ ȭ��ǥ �������� �̵�.
		
		//�̵��Ϸ��� ĭ�� �̹� ���� �ִ°�� �� ĭ���� �̵� �Ұ�.
		
		//���� /���� ĭ�� �̵� ����.
		
		//���� �̵��� ��ĥ�� �� ĭ���ִ� ���� �߰�.
		
		//���� �̵��Ϸ��� �ϴ� ĭ�� ������ �Ѿ�� ��� �������� �̵��� ��ħ.
		
		//�ֻ������� ���� �� 10���� �̸� �˰� ������, ���� �� �ִ� ������ �ִ��� ���غ���.
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
