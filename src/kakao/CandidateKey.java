package kakao;

import java.util.*;

public class CandidateKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0 ; i < 1 << 5; i++) {
			System.out.println(i);
		}
		List<Integer> candidates = new LinkedList<Integer>();
		candidates.add(3);
		
		Iterator<Integer> it = candidates.iterator();
		System.out.println(it.hasNext());
		System.out.println(it.next());
		
		for(int i=1 ; i <= 1 << 5; i++) {
			if((i & (7)) == i) {
				System.out.println(i);
			}
		}
		System.out.println(8 == (1<<3));
	}

}
