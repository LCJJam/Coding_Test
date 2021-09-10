package NHN;
import java.util.*;
public class test2 {
	  private static void solution(int day, int width, int[][] blocks) {
		    // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		  int[] map = new int[width];
		  
		  int cement = 0;
		  for(int i = 0 ; i < day ; i++) {
			  for(int j = 0; j < width; j++) {
				  map[j] += blocks[i][j]; // 벽돌 쌓기
				  //System.out.println(map[j]);
			  }
			  
			  for(int k = 1; k < width-1; k++) {
				  int Lmax = 0;
				  int Rmax = 0;
				  for(int x = 0; x < k ; x++) {
					  Lmax = Math.max(map[x],Lmax);
				  }
				  for(int y = k+1; y < width; y++) {
					  Rmax = Math.max(map[y],Rmax);
				  }
				  if(Rmax > map[k] && Lmax > map[k]) {
					  int amount = Math.min(Rmax, Lmax) - map[k];
					  cement = cement + amount;
					  map[k] += amount;
				  }
				  
			  }
		  }
		  System.out.println(cement);
		  
		  }
		  
		  private static class InputData {
		    int day;
		    int width;
		    int[][] blocks;
		  }

		  private static InputData processStdin() {
		    InputData inputData = new InputData();

		    try (Scanner scanner = new Scanner(System.in)) {
		      inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
		      inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
		      
		      inputData.blocks = new int[inputData.day][inputData.width];
		      for (int i = 0; i < inputData.day; i++) {
		        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
		        for (int j = 0; j < inputData.width; j++) {
		          inputData.blocks[i][j] = Integer.parseInt(buf[j]);
		        }
		      }
		    } catch (Exception e) {
		      throw e;
		    }

		    return inputData;
		  }

		  public static void main(String[] args) throws Exception {
		    InputData inputData = processStdin();

		    solution(inputData.day, inputData.width, inputData.blocks);
		  }
}
