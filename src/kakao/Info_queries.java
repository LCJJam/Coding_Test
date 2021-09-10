package kakao;
import java.util.*;
public class Info_queries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] info = { "java backend junior pizza 150","python frontend senior chicken 210",
				"python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = { "java and backend and junior and pizza 100","python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int[] result = new int[query.length]; 	
		Map<Integer,List<Integer>> person = new HashMap<Integer,List<Integer>>(); 
		int[][] map = new int[24][info.length];
		for(int i=0;i < info.length;i++) {
			String[] p = info[i].split(" ");
			int idx = 0;
			if(p[0].equals("java")) {
				idx += 1;
			} else if(p[0].equals("cpp")) {
				idx += 2;
			} else { 
				idx += 3;
			}
			if(p[1].equals("backend")) idx += 3;
			if(p[2].equals("senior")) idx += 6;
			if(p[3].equals("chicken")) idx += 12;
			
			List<Integer> k = new LinkedList<Integer>();
			if(person.get(idx) == null) {
				k.add(Integer.parseInt(p[4]));
				person.put(idx, k);
			} else {
				k = person.get(idx);
				k.add(Integer.parseInt(p[4]));
				person.put(idx, k);
			}
			//System.out.println(person.get(3));
		}
		
		for(int i =0; i<query.length;i++) {
			String[] q = query[i].split(" and ");
			int score = Integer.parseInt(q[3].split(" ")[1]);
			String q0 = q[0];
			String q1 = q[1];
			String q2 = q[2];
			q[3] = q[3].split(" ")[0];
			String q3 = q[3];
			
			ArrayList<Integer> idx = new ArrayList<Integer>();
			int len = idx.size();
			if(q0.equals("java")) {
				idx.add(1);
			} else if (q0.equals("cpp")) {
				idx.add(2);
			} else if (q0.equals("python")) {
				idx.add(3);
			} else {
				idx.add(1);
				idx.add(2);
				idx.add(3);
			}
			len = idx.size();
			if(q1.equals("backend")) {
				for(int x=0; x<len;x++) idx.set(x,idx.get(x)+3);
			} else if(q1.equals("-")) {
				for(int x=0;x<len;x++) {
					idx.add(idx.get(x)+3);
				}
			}
			
			len = idx.size();
			if(q2.equals("senior")) {
				for(int x=0; x<len;x++) idx.set(x,idx.get(x)+6);
			} else if(q2.equals("-")) {
				for(int x=0;x<len;x++) {
					idx.add(idx.get(x)+6);
				}
			}
			
			len = idx.size();
			if(q3.equals("chicken")) {
				for(int x=0; x<len;x++) idx.set(x,idx.get(x)+12);
			} else if(q3.equals("-")) {
				for(int x=0;x<len;x++) {
					idx.add(idx.get(x)+12);
				}
			}
			
			for(int y=0;y < idx.size();y++) {
				if(person.get(idx.get(y)) != null) {
					result[i] += comp(person,idx.get(y),score);
				}
			}
			
		}
		for(int i=0;i<query.length;i++) {
			System.out.println(result[i]);
		}
		
	}
	
	public static int comp (Map<Integer,List<Integer>> list,int idx,int score) {
		int result = 0;
		for(int j=0;j<list.get(idx).size();j++) {
			if(list.get(idx).get(j) >= score) {
				result += 1;
			}
		}
		return result;
	}

}
