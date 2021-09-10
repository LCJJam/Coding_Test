package line_coding;

import java.util.*;

public class Boxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] boxes = {{1,2},{3,4},{5,6}};
		int answer = boxes.length;
		List<Integer> arr = new LinkedList<Integer>();
		for(int i= 0; i<boxes.length;i++){
            arr.add(boxes[i][0]);
            arr.add(boxes[i][1]);
        }
		Collections.sort(arr);
		for(int i=0;i<arr.size()-1;i++) {
			if(arr.get(i) == arr.get(i+1)) {
				answer -= 1;
				i++;
			}
		}
		System.out.println(answer);
	}

}
