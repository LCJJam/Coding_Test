package QuizTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] ar) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] map = new int[N];
		st =new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			map[i] = Integer.parseInt(st.nextToken()); 
		}
		int Min = 40000;
		
        Main3 ex = new Main3();
        
        int n = map.length;
        int r = K;
        int[] combArr = new int[r];
        ex.doCombination(combArr, map, n, r, 0, 0);
    }

    public void doCombination(int[] combArr, int[] arr, int n, int r, int index, int target){
        if(r == 0){
            //to-do: combArr permutation
            doPermutation(combArr, 0);
            System.out.println("------------------");
        }else if(target == n) return;
        else{
            combArr[index] = arr[target];
            doCombination(combArr, arr, n, r-1, index+1, target+1);
            doCombination(combArr, arr, n, r, index, target+1);
        }
    }

    public void doPermutation(int[] arr, int startIdx){
        int length = arr.length;
        if(startIdx == length-1){
            for(int item: arr) System.out.print(item + " ");
            System.out.println();
            return;
        }
        for(int i=startIdx; i<length-1; i++){
            swap(arr, startIdx, i);
            doPermutation(arr, startIdx+1);
            swap(arr, startIdx, i);
        }
    }

    public void swap(int[] arr, int n1, int n2){
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}