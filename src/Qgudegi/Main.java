package Qgudegi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		//long st1 = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> p = new PriorityQueue<Integer>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int l = Integer.parseInt(st.nextToken());
			p.add(l);
			bf.write(l);
			
		}
		
		System.out.println(p.poll()+p.poll());
		
		
		
		bf.flush();
		
		//System.out.println("�ҿ�ð� "+(System.currentTimeMillis() - st1)+"ms");
	}
}
