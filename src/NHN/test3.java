package NHN;
import java.util.*;
public class test3 {
	  private static void solution(int numOfOrder, String[] orderArr) {
		    // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		  	
		  }

		  private static class InputData {
		    int numOfOrder;
		    String[] orderArr;
		  }

		  private static InputData processStdin() {
		    InputData inputData = new InputData();

		    try (Scanner scanner = new Scanner(System.in)) {
		      inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

		      inputData.orderArr = new String[inputData.numOfOrder];
		      for (int i = 0; i < inputData.numOfOrder; i++) {
		        inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
		      }
		    } catch (Exception e) {
		      throw e;
		    }

		    return inputData;
		  }

		  public static void main(String[] args) throws Exception {
		    InputData inputData = processStdin();

		    solution(inputData.numOfOrder, inputData.orderArr);
		  }
}
