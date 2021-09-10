package kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareTo {

	public static void main(String[] args) {
		List<Stage> stages = new ArrayList<>();
		Stage s1 = new Stage(2, 3.3);
		Stage s2 = new Stage(3, 1.2242);
		Stage s3 = new Stage(9,2.66666);
		Stage s4 = new Stage(5,2.66666);
		stages.add(s1);
		stages.add(s2);
		stages.add(s3);
		stages.add(s4);
		Collections.sort(stages);
		System.out.println(stages.get(0).id +" " +  stages.get(0).failure);
		System.out.println(stages.get(1).id +" " +  stages.get(1).failure);
		System.out.println(stages.get(2).id +" " +  stages.get(2).failure);
		System.out.println(stages.get(3).id +" " +  stages.get(3).failure);
	}
}

class Stage implements Comparable<Stage> {
    public int id;
    public double failure;

    public Stage(int id_, double failure_) {
        id = id_;
        failure = failure_;
    }

    @Override
    public int compareTo(Stage o) {
        if (failure < o.failure ) {
            return 1;
        }
        if (failure > o.failure ) {
            return -1;
        }
        return 0;
    }
}
