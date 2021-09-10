package NHN;

import java.util.*;

public class test1 {
	  private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
		    // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		  
		  
		  char[] Players = new char[numOfAllPlayers-1];
		  char target = 'A';
		  int[] score = new int[numOfAllPlayers];
		  score[target - 'A'] = 1;
		  char tmp;
		  for(int i = 0 ; i < numOfAllPlayers-1 ; i++) {
			  Players[i] = (char)('B'+i);
		  }
		  int idx = 0;
		  for(int i = 0 ; i < numOfGames ; i++) {
			  idx = (idx+numOfMovesPerGame[i]+(numOfAllPlayers-1)) % (numOfAllPlayers-1);
			  
			  if(Arrays.binarySearch(namesOfQuickPlayers, Players[idx]) < 0) { // 절대 술래가 아니라면
				  tmp = Players[idx];
				  Players[idx] = target;
				  target = tmp;
				  score[target - 'A']++;
			  } else { // 절대 술래이면 다시 제자리에서 시작.
				  score[target - 'A']++;
			  }
			  
		  }
		  
		  for(int i = 0 ; i < numOfAllPlayers-1 ; i++) {
			  System.out.print(Players[i]+" ");
			  System.out.println(score[Players[i]-'A']);
		  }
		  System.out.print(target+" ");
		  System.out.println(score[target-'A']);
		  
		  }

		  private static class InputData {
		    int numOfAllPlayers;
		    int numOfQuickPlayers;
		    char[] namesOfQuickPlayers;
		    int numOfGames;
		    int[] numOfMovesPerGame;
		  }

		  private static InputData processStdin() {
		    InputData inputData = new InputData();

		    try (Scanner scanner = new Scanner(System.in)) {
		      inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

		      inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
		      inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
		      System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

		      inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
		      inputData.numOfMovesPerGame = new int[inputData.numOfGames];
		      String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
		      for(int i = 0; i < inputData.numOfGames ; i++){
		        inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
		      }
		    } catch (Exception e) {
		      throw e;
		    }

		    return inputData;
		  }

		  public static void main(String[] args) throws Exception {
		    InputData inputData = processStdin();

		    solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
		  }
}
