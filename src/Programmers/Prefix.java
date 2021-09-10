package Programmers;
import java.util.*;
public class Prefix {

	public static void main(String[] args) {
		int [] arr = { 1, 2, 4, 6, 7, 9, 10 , 12 , 14 , 15 , 17 ,18 , 20, 25 , 27 , 29 , 30};
		List<Integer> list = new LinkedList<Integer>();
		
		for(int i=0;i<arr.length;i++) {
			list.add(arr[i]);
		}
		list.add(231231541);
		int start = 0;
		int end = 0;
		int sum = 0;
		int answer = 0;
		int target = 27;
		while(start != arr.length ) {
			if(sum == target) {
				answer++;
				for(int i = start; i< end-1; i++) {
					System.out.print(list.get(i) + "+");
				}
				System.out.println(list.get(end-1) + " = " + sum);
				
				sum += list.get(end);				
				end +=1 ;
			} else if(sum < target) {
				sum += list.get(end);
				end += 1;
			} else {
				sum -= list.get(start);
				start += 1;
			}
			
		}
		System.out.println("answer: "+answer);
	}

}
