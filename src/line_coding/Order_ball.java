package line_coding;
import java.util.*;
public class Order_ball {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ball = { 1, 2, 3, 4, 5, 6 };
		int[] order = { 6, 2, 5, 1, 4, 3 };
		
		List<Integer> list_order = new LinkedList<Integer>();
		List<Integer> list_order2 = new LinkedList<Integer>();
		List<Integer> list_ball = new LinkedList<Integer>();
		List<Integer> list_answer = new LinkedList<Integer>();
		for(int i =0;i<order.length;i++) {
			list_order.add(order[i]);
			list_ball.add(ball[i]);
		}
		while(list_ball.size() != 0) {
			int len = list_order2.size();
			for(int i=0;i<len;i++) {
				int comp = list_order2.remove(0);
				if(list_ball.get(0) == comp) {
					list_answer.add(list_ball.remove(0));
				} else if(list_ball.get(list_ball.size()-1) == comp) {
					list_answer.add(list_ball.remove(list_ball.size()-1));
				} else {
					list_order2.add(comp);
				}
			}
			int comp = list_order.remove(0);
			if(list_ball.get(0) == comp) {
				list_answer.add(list_ball.remove(0));
			} else if(list_ball.get(list_ball.size()-1) == comp) {
				list_answer.add(list_ball.remove(list_ball.size()-1));
			} else {
				list_order2.add(comp);
			}
		}
		
		
		
		
		
		int[] answer = new int[ball.length];
		for(int i=0;i < list_answer.size();i++) {
			answer[i] = list_answer.get(i);
			System.out.println(answer[i]);
		}
		
	}

}
