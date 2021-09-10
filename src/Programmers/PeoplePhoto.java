package Programmers;
import java.util.*;
public class PeoplePhoto {
	static int num = 0;
	static String []strk = {"N~F=0", "R~T>2"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char []mem = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
		char []mem1 = {'A', 'C', 'F', 'J'};
		List<Character> memb = new LinkedList<Character>();
		for(int i=0;i<mem.length;i++) {
			memb.add(mem[i]);
		}
		req(memb,memb.size(),"");
		System.out.println(num);
	}
	
	public static void req(List<Character> memb,int idx,String str) {
		if(idx == 0) {
			//System.out.println(str);
			boolean flag = true;
			for(int i=0;i<strk.length;i++) {
				char pers1 = strk[i].charAt(0);
				char pers2 = strk[i].charAt(2);
				int len = Math.abs((str.indexOf(pers1) - str.indexOf(pers2))) - 1;
				int number = Integer.parseInt(String.valueOf(strk[i].charAt(4)));
				switch (strk[i].charAt(3)) {
					case '>' :  
						if(!(len > number)) flag = false;
						break;
					case '<' :
						if(!(len < number)) flag = false;
						break;
					case '=' :
						if(!(len == number)) flag = false;
						break;
				}
			}
			if(flag) num++;
			return;
		}
		for(int i=0;i<memb.size();i++) {
			
			char a = memb.get(i);
			memb.remove(i);
			req(memb,idx-1,str+a);
			memb.add(i, a);
		}
		return;
	}

}
