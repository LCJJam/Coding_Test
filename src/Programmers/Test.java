package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {
	static long Max = 0;
	public static void main(String[] args) {
		
		String answer = "123-456*579+651"; 
		char[][] calc = {{'+','-','*'},{'+','*','-'},{'-','+','*'},{'-','*','+'},{'*','+','-'},{'*','-','+'}};
		
		LinkedList<Long> numList = new LinkedList<Long>(); //숫자관련
        LinkedList<Character> opList = new LinkedList<Character>(); //연산자 관련
        
        String num = ""; //연사자 외에 숫자들을 임시 저장할 곳
        
		String s = answer;
        for(int x=0;x<6;x++) {
        	numList = new LinkedList<Long>();
        	opList = new LinkedList<Character>();
        	num = "";
        	for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i); //string을 char 타입 단위로 나눔
                
                if(ch == '+' || ch =='-' || ch == '*') {
                    numList.add(Long.parseLong(num)); //숫자로 바꿔서 숫자배열에 추가
                    opList.add(ch); //연산자를 연산자배열에 추가
                    num = ""; //임시로 저장된 숫자를 비워준다                   
                    continue; //제일 가까운 명령문으로 이동
                }
                num += ch; //연산자 앞까지의 숫자를 임시로 넣어 놓음
            }
            numList.add(Long.parseLong(num)); //마지막 숫자
        	Cal(calc[x],0,numList,opList);
        }
        System.out.println(Max);
        
	}
	private static void Cal(char[] calc,int depth,LinkedList<Long> numList, LinkedList<Character> opList ) {
		if(depth == 3) {
			Max = Math.max(Max,Math.abs(numList.poll()));
			return;
		}
		LinkedList<Long> numList2 = new LinkedList<Long>(); //숫자관련
        LinkedList<Character> opList2 = new LinkedList<Character>(); //연산자 관련
		while(!opList.isEmpty()) { //연산자배열이 빌 때까지
            Long prevNum = numList.poll(); //poll : 앞부터 완전히 뺀다
            char op = opList.poll();
            if(op == '+' && op == calc[depth]) {
            	Long nextNum = numList.poll();
                numList.addFirst(prevNum + nextNum); //addFirst 배열 제일 앞에 넣는다
            } else if (op == '-' && op == calc[depth]){
            	Long nextNum = numList.poll();
            	numList.addFirst(prevNum - nextNum);
            } else if (op == '*' && op == calc[depth]) {
            	Long nextNum = numList.poll();
            	numList.addFirst(prevNum * nextNum);
            } else {
            	numList2.add(prevNum);
            	opList2.add(op);
            }
        }
		numList2.add(numList.poll());
		Cal(calc,depth+1,numList2,opList2);
	}
}
