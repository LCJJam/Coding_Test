package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {
	static long Max = 0;
	public static void main(String[] args) {
		
		String answer = "123-456*579+651"; 
		char[][] calc = {{'+','-','*'},{'+','*','-'},{'-','+','*'},{'-','*','+'},{'*','+','-'},{'*','-','+'}};
		
		LinkedList<Long> numList = new LinkedList<Long>(); //���ڰ���
        LinkedList<Character> opList = new LinkedList<Character>(); //������ ����
        
        String num = ""; //������ �ܿ� ���ڵ��� �ӽ� ������ ��
        
		String s = answer;
        for(int x=0;x<6;x++) {
        	numList = new LinkedList<Long>();
        	opList = new LinkedList<Character>();
        	num = "";
        	for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i); //string�� char Ÿ�� ������ ����
                
                if(ch == '+' || ch =='-' || ch == '*') {
                    numList.add(Long.parseLong(num)); //���ڷ� �ٲ㼭 ���ڹ迭�� �߰�
                    opList.add(ch); //�����ڸ� �����ڹ迭�� �߰�
                    num = ""; //�ӽ÷� ����� ���ڸ� ����ش�                   
                    continue; //���� ����� ��ɹ����� �̵�
                }
                num += ch; //������ �ձ����� ���ڸ� �ӽ÷� �־� ����
            }
            numList.add(Long.parseLong(num)); //������ ����
        	Cal(calc[x],0,numList,opList);
        }
        System.out.println(Max);
        
	}
	private static void Cal(char[] calc,int depth,LinkedList<Long> numList, LinkedList<Character> opList ) {
		if(depth == 3) {
			Max = Math.max(Max,Math.abs(numList.poll()));
			return;
		}
		LinkedList<Long> numList2 = new LinkedList<Long>(); //���ڰ���
        LinkedList<Character> opList2 = new LinkedList<Character>(); //������ ����
		while(!opList.isEmpty()) { //�����ڹ迭�� �� ������
            Long prevNum = numList.poll(); //poll : �պ��� ������ ����
            char op = opList.poll();
            if(op == '+' && op == calc[depth]) {
            	Long nextNum = numList.poll();
                numList.addFirst(prevNum + nextNum); //addFirst �迭 ���� �տ� �ִ´�
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
