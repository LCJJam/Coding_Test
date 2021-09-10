package Q14890;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int Available=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int[][] map2 = new int[N][N];
		//�� ����
		for(int i=0;i<N;i++) {
			StringTokenizer st1 =new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
				map2[j][i] = map[i][j];
			}
		}
		
		//
		for(int i=0;i<N;i++) {
			VerticalOk(i,N,map[i],L);
			HorizontalOk(i,N,map2[i],L);
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				//System.out.print(map[i][j] + " ");
			}
			//System.out.println();
		}
		System.out.println(Available);
	}
	// ���δ� L���� ����ĭ��.
	// ����ĭ�� ����ĭ�� ���̴� 1.
	// 
	
	public static void VerticalOk(int n,int Max,int[] i_th_map,int Len) {
		int Continue = 1;
		for(int i=0;i<Max-1;i++) {
			if(Math.abs(i_th_map[i] - i_th_map[i+1])>1) {
				return;
			}
			if(i_th_map[i]>i_th_map[i+1]) {
				if(Max-1 -i < Len) return;
				for(int j=0;j<Len;j++) {
					if(i_th_map[i+1]!=i_th_map[i+1+j]) {
						return;
					}
				}
				Continue = 1-Len;
			}
			if(i_th_map[i] < i_th_map[i+1]) {
				if(Continue < Len) {
					return;
				}
				Continue = 1;
			}
			if(i_th_map[i] == i_th_map[i+1]) {
				Continue++;
			}
		}
		Available++;
		//System.out.println(n+"����");
	}
	// ������ Ȯ��
	public static void HorizontalOk(int n,int Max,int[] i_th_map,int Len) {
		int Continue = 1;
		for(int i=0;i<Max-1;i++) {
			if(Math.abs(i_th_map[i] - i_th_map[i+1])>1) {
				return;
			}
			if(i_th_map[i]>i_th_map[i+1]) {
				if(Max-1 -i < Len) return;
				for(int j=0;j<Len;j++) {
					if(i_th_map[i+1]!=i_th_map[i+1+j]) {
						return;
					}
				}
				Continue = 1-Len;
			}
			if(i_th_map[i] < i_th_map[i+1]) {
				if(Continue < Len) {
					return;
				}
				Continue = 1;
			}
			if(i_th_map[i] == i_th_map[i+1]) {
				Continue++;
			}
		}
		Available++;
		//System.out.println(n+"���� :"+Continue);
	}
	
	// ������ Ȯ��
}
