package kakao;
import java.util.*;
public class SearchString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };
		int len = queries.length;
		int[] answer = new int[len];
		int idx = 0;
		for(String q : queries) {
			int num = 0;
			List<Integer> sorting = new LinkedList<Integer>();
			for(int i=0;i<q.length();i++) {
				if(q.charAt(i) == '?') {
					sorting.add(i);
				}
			}
			String comp = q.replace("?","");
			for(String w : words) {
				
				if(sorting.get(0) == 0 ) { // ??가 앞에
					if(w.length() == q.length() && comp.equals( w.substring( sorting.get(sorting.size()-1)+1))) {
						num++;
					}
				} else { // ??가 뒤에
					if(w.length() == q.length() && comp.equals(w.substring(0,sorting.get(0)))) {
						num++;
					}
				}
			}
			answer[idx] = num;
			idx++;
		}
		
		
		
		
		
		for(int i=0;i<len;i++) {
			System.out.println(answer[i]);
		}
	}

}
