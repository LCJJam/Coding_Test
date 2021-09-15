package Programmers;

public class All_digit_sum {

	public static void main(String[] args) {

		/*
			자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
			예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
		*/
		
		int N = 123;
		System.out.println(solution(N)); // 6
		
		N = 987;
		System.out.println(solution(N)); // 24
	}
	
	
	public static int solution(int n) {
        int answer = 0;
        while(n / 10 != 0 || n % 10 != 0){
            answer += n%10;
            n = n/10;
        }
        return answer;
    }
}

