package kakao;
import java.util.*;
public class Chat_Record {

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan" };
        int record_len = record.length;
        int len = record_len;
		List<String> rec = new ArrayList<String>();
		List<String> rec2 = new ArrayList<String>();
		HashMap<String,String> Id = new HashMap<String,String>();
        for(int i=0;i<record_len;i++) {
        	String[] sp = record[i].split(" ");
        	if(sp[0].equals("Leave")) {
        		rec2.add(sp[1]);
        		rec.add("님이 나갔습니다.");        		
        	} else if(sp[0].equals("Enter") && sp.length == 3) {
        		rec2.add(sp[1]);
        		rec.add("님이 들어왔습니다.");
        		Id.put(sp[1],sp[2]);
        	} else if(sp[0].equals("Change") && sp.length == 3 ){
        		Id.put(sp[1],sp[2]);
        		len--;
        	}
        }
        String[] answer = new String[len];
		for(int i=0; i<len;i++) {
			answer[i] = Id.get(rec2.get(i))+ rec.get(i);
		}
		
		
		for(int i=0;i<len;i++) {
			System.out.println(answer[i]);
		}
		
		
	}

}
