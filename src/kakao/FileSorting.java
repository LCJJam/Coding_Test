package kakao;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FileSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] files = {"img12.png","img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] answer = new String[files.length];
        int num = 0;
        List<FileName> FNList = new LinkedList<FileName>();
        for(String s : files){
            String HEAD = "";
            String NUMBER = "";
            String TAIL = "";
            boolean flag = true;
            for(int i=0 ; i < s.length();i++){
                char ch = s.charAt(i);
                if(flag && (48 > ch || ch > 57)) {
                    HEAD += Character.toString(ch);
                } else if (48 <= ch && ch <= 57 ) {
                    NUMBER += Character.toString(ch);
                    flag = false;
                } else if((48 > ch || ch > 57) && !flag){
                    TAIL = s.substring(i,s.length());
                    break;
                }
            }
            FileName k = new FileName(HEAD,NUMBER,TAIL);
            FNList.add(k);
            num++;
        }
        Collections.sort(FNList, Collections. reverseOrder());
        for(int i=0;i<files.length;i++) {
        	answer[i] = FNList.get(i).HEAD1+FNList.get(i).NUMBER2+FNList.get(i).TAIL3;
        }
        for(int i=0;i<files.length;i++) {
        	System.out.print(FNList.get(i).HEAD1 + " ");
        }
        System.out.println("");
        for(int i=0;i<files.length;i++) {
        	System.out.print(FNList.get(i).NUMBER2 + " ");
        }
        System.out.println("");
        
        
        System.out.println('3' > 51);
        System.out.println(Integer.parseInt("010") > Integer.parseInt("012"));
        System.out.println("igc".toUpperCase().compareTo("IMG"));
	}
	
}

class FileName implements Comparable<FileName>{
	public String HEAD1 = "";
	public String NUMBER2 = "";
	public String TAIL3 = "";
	
	public FileName(String HEAD1_, String NUMBER2_, String TAIL3_) {
        HEAD1 = HEAD1_;
        NUMBER2 = NUMBER2_;
        TAIL3 = TAIL3_;
    }
	@Override
	public int compareTo(FileName o) {
		if (HEAD1.toUpperCase().compareTo((o.HEAD1.toUpperCase()))>0 ) {
            return 1;
        } else if (HEAD1.toUpperCase().compareTo((o.HEAD1.toUpperCase()))<0 ) {
            return -1;
        } else {
        	if(Integer.parseInt(NUMBER2) < Integer.parseInt(o.NUMBER2)) {
        		return 1;
        	} else if(Integer.parseInt(NUMBER2) > Integer.parseInt(o.NUMBER2)) {
        		return -1;
        	}
        }
		
		return 0;
	}
	
}