package Programmers;

import Programmers.Arithmetic_operation;

public class Main {

	public static void main(String[] args) {
		
		//사칙 연산
		//String[] arr = {"1", "-", "3", "+", "5", "-", "8"};
		String[] arr = {"5", "-", "3", "+", "1", "+", "2", "-", "4"};
		Arithmetic_operation Arithmetic_operation = new Arithmetic_operation();
		System.out.println(Arithmetic_operation.solution(arr)); // 3
	}

}
