package kakao;

public class CardGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 키 조작 횟수는 방향키와 [Enter] 키를 누르는 동작을 각각 조작 횟수 1로 계산하며, [Ctrl] 키와 방향키를 함께 누르는 동작 또한 조작 횟수 1로 계산합니다.
		// 현재 카드가 놓인 상태를 나타내는 2차원 배열 board와 커서의 처음 위치 r, c가 매개변수로 주어질 때
		// 카드를 제거하기 위한 키 조작 횟수의 최솟값을 return 하도록 solution 함수
		int[][] board = { {1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0} }; // board는 4 x 4 크기의 2차원 배열입니다. board 배열의 각 원소는 0 이상 6 이하인 자연수입니다.
		// 0은 카드가 제거된 빈 칸을 나타냅니다. 1 부터 6까지의 자연수는 2개씩 들어있으며 같은 숫자는 같은 그림의 카드를 의미합니다. 뒤집을 카드가 없는 경우(board의 모든 원소가 0인 경우)는 입력으로 주어지지 않습니다.
		int r = 1;
		int c = 0; // r과 c는 0 이상 3 이하인 정수입니다.
		int result = 0;
		
		
		
		System.out.println(result);
		
	}

}
