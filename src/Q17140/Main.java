package Q17140;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int[][] map = new int[101][101];
	static int[] countInfo = new int[101];
	
	static int time = 0;
	static int r,c,k;
	
	static int row=3,col=3;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//ù° �ٿ� r, c, k�� �־�����. (1 �� r, c, k �� 100)

		//��° �ٺ��� 3���� �ٿ� �迭 A�� ����ִ� ���� �־�����. �迭 A�� ����ִ� ���� 100���� �۰ų� ���� �ڿ����̴�.
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=3;j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if(map[r][c] == k) {
				System.out.println(time);
				break;
			}
			
			LinkedList<MyInfo> list = new LinkedList<>();
			
			
			if(col >= row) {
				int tmpRsize = 1;
				
				for(int i=1;i<=col;i++) {
					for(int j=1;j<=row;j++) {
	                        countInfo[map[i][j]]++;
	                        map[i][j] = 0;
	                    }
	                    for(int z=1; z<countInfo.length; z++){
	                        if(countInfo[z] != 0){
	                            list.add(new MyInfo(z, countInfo[z]));
	                        }
	                    }
						
						
						Collections.sort(list);
						
						int index = 1;  
						for(MyInfo m : list){
		                       map[i][index++] = m.number;
		                       map[i][index++] = m.count;
						}
						//��,�� ���� ���� (R������ ��� �����̸� ����)
	                    if(tmpRsize <= index){
	                        tmpRsize = index;
	                    }
						//�ʱ�ȭ
	                    list.clear();
	                    Arrays.fill(countInfo, 0);
				}
				row = tmpRsize;
			} else {
				//operate = "[C����]";
                //C����
                int tmpCsize = 1;
                
				for(int i=1;i<=row;i++) {
					for(int j=1;j<=col;j++) {
						countInfo[map[j][i]]++;
                        map[j][i] = 0;
					}
					
					for(int z=1; z<countInfo.length; z++){
                        if(countInfo[z] != 0){
                            list.add(new MyInfo(z, countInfo[z]));
                        }
                    }
                    Collections.sort(list);
                     
                    int index = 1;
                                 
                    for(MyInfo m : list){
                        map[index++][i] = m.number;
                        map[index++][i] = m.count;
                    }
                     
                    //��,�� ���� ���� (C������ ��� ����̸� ����)
                    if(tmpCsize <= index){
                        tmpCsize = index;
                    }
                     
                    //�ʱ�ȭ
                    list.clear();
                    Arrays.fill(countInfo, 0);
                }
                col = tmpCsize;
				
				
			}
			
			
			
			if(time == 100) {
				System.out.println(-1);
				break;
			}
			time++;
			/*
			System.out.println(time);
			for(int i=1;i<=6;i++) {
				for(int j=1;j<=6;j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			*/
			
		}
		
	}
	
	static class MyInfo implements Comparable<MyInfo>{
        int number;
        int count;
         
        MyInfo(int number, int count){
            this.number = number;
            this.count = count;
        }
         
        @Override
        public int compareTo(MyInfo o) {
            if(this.count < o.count){
                return -1;
            }else if(this.count > o.count){
                return 1;   
            }else{
                //count�� �����ΰ��
                if(this.number < o.number){
                    return -1;
                }else if(this.number > o.number){
                    return 1;
                }
            }
            return 0;
        }
         
    }

}
