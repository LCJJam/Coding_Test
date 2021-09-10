package kakao;

public class bracket {
	public static boolean empty(String s){
        return s.equals("");
    }
    public static String reverseString(String s){
        return (new StringBuffer(s)).reverse().toString();
    }
    public static String Stage(String s){
        if(empty(s)) return s; //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        String w = s;
        String s1 = "";
        String u = "";
        String v = "";
        int cnt = 0;
        for(int i=0;i<w.length();i++){
                if(s.charAt(i)=='('){ 
                    ++cnt;
                } else {
                    --cnt;
                }
                if(cnt == 0){  
                    u = w.substring(0,i+1); //2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.  //단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.  
                    v = w.substring(i+1); 
                    System.out.println(i);
                    if(u.charAt(0) == '('){ //3.문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
                        s1+=u; 
                        s1+=Stage(v); //3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
                    } else { //4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
                        s1 += '('; //4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
                        s1 += Stage(v);//4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
                        s1 += ')';//4-3. ')'를 다시 붙입니다. 
                        if(u.length() == 1) {
                        	u = ""; 
                        } else {
                        	u = u.substring(1,u.length()-1);
                        }
                        for(int j=0;j<u.length();j++) {
                        	if(u.charAt(j) == '('){
                        		s1+= ')';
                        	} else {
                        		s1+= '(';
                        	}
                        
                        } 
                    }
                    break;
                }
        }
        
		return s1; //4-5. 생성된 문자열을 반환합니다.
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "(()())()";
		String k = "12345678";
		String answer = "";
        answer = Stage(p);
        System.out.println(k.substring(0,6));
        System.out.println(k.substring(8));
        
        
		System.out.println(answer);
	}

}
