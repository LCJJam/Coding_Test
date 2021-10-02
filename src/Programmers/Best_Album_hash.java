package Programmers;

import java.util.*;

public class Best_Album_hash {

	public static void main(String[] args) {

		//String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		String[] genres = {"classic", "pop", "classic", "classic", "pop","sal"};
		//int[] plays = {500, 600, 150, 800, 2500};
		int[] plays = {500, 600, 150, 800, 2500,300};
		int len = genres.length;
		List<Genre> Album = new ArrayList<>();
		HashMap<String, Integer> genres_num = new HashMap<>();
		int tmp1,tmp2;
		for (int i=0;i<len;i++) {
			
			if(genres_num.containsKey(genres[i])) {
				Genre gen = Album.get(genres_num.get(genres[i]));

				gen.all_play += plays[i];
				if (gen.play2 < plays[i]) {
					gen.play2 = plays[i];
					gen.idx2 = i;
				}
				
				if (gen.play1 < gen.play2) {
					tmp1 = gen.play1;
					tmp2 = gen.idx1;
					gen.play1 = gen.play2;
					gen.idx1 = gen.idx2;
					gen.play2 = tmp1;
					gen.idx2 = tmp2;
				}
				
				Album.set(genres_num.get(genres[i]), gen);
				
			} else {
				genres_num.put(genres[i], genres_num.size());
				
				Album.add(new Genre(genres[i],plays[i],i));
			}
			
		}
		
		Collections.sort(Album);
		List<Integer> answer = new ArrayList<>();
		for(int i=0;i<Album.size();i++) {
			answer.add(Album.get(i).idx1);
			if(Album.get(i).play2 != 0) answer.add(Album.get(i).idx2);
		}
		
		System.out.println(answer);
	}
	
	static class Genre implements Comparable<Genre> {
		private String name;
	    private int all_play;
	    private int play1;
	    private int play2;
	    private int idx1;
	    private int idx2;

	    public Genre(String name, int play,int idx) {
	        this.name = name;
	        this.all_play = play;
	        this.play1 = play;
	        this.idx1 = idx;
	    }
	    // Getters, Setters 생략
	    
	    @Override
	    public int compareTo(Genre o) {
	        return o.all_play - all_play;
	    }
	}
}
