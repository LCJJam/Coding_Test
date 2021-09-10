package kakao;
import java.util.*;
 
public class ShortLoad {
 
    public static void main(String[] args) {
         System.out.println(3);
         HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3));
         System.out.println(Arrays.asList(1,2));
         ArrayList list = new ArrayList();
         Iterator it1 = list.iterator();
         
         list.add(2);
         list.add(4);
         
         while(it1.hasNext()) {
        	 System.out.println(list.remove(0));
         }
        	 
         
    }
     
    
}