package Programmers;

import java.util.ArrayList;
import java.util.HashSet;

public class Test3 {
	static int shortest = 100000;
	public static void main(String[] args) {
		//String[] gems = {"AA", "AB", "AC", "AA", "AC"};
		//String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		//String[] gems = {"XYZ", "XYZ", "XYZ"};
		String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		int[] answer = {};
		answer = new int[2];
		int len = gems.length;
		
		ArrayList<String> arr = new ArrayList<String>();

		for(int i=0;i<len;i++) {
			arr.add(gems[i]);
		}
		HashSet<String> arr2 =  new HashSet<String>(arr);
		// arr3 모든 종류
		ArrayList<String> arr3 = new ArrayList<String>(arr2);
		ArrayList<String> tmpArr = new ArrayList<String>();
		for(int j=0; j<len;j++) {
			tmpArr = new ArrayList<String>();
			for(int i=j;i<len;i++) {
				tmpArr.add(gems[i]);
				if(isTrue(tmpArr,arr3)) {
					int sub = i-j;
					if(sub < shortest) {
						shortest = sub;
						answer[0] = j;
						answer[1] = i;
					}
					break;
				} else {
					continue;
				}
			}
		}
		
		System.out.println(answer[0]+1 +" " + (answer[1]+1));
	}
	
	private static boolean isTrue(ArrayList<String> A,ArrayList<String> B){
        for(int j=0;j<B.size();j++){
            if(A.contains(B.get(j))){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
