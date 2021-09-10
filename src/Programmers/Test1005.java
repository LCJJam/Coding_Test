package Programmers;

class Nesoy {
	int age;
	String name;

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {

	    if (obj == null) {
	        return false;
	    }

	    if (this.getClass() != obj.getClass()) {
	        return false;
	    }

	    if (this == obj) {
	        System.out.println("Object Same");
	        return true;
	    }

	    Nesoy that = (Nesoy) obj;

	    if (this.name == null && that.name != null) {
	        return false;
	    }

	    if (this.age == that.age && this.name.equals(that.name)) {
	        System.out.println("Object Value Same");
	        return true;
	    }

	    return false;
	}
}

public class Test1005 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Nesoy p1 = new Nesoy();
		p1.setAge(27);
		p1.setName("YoungJae");

		Nesoy p2 = new Nesoy();
		p2.setAge(27);
		p2.setName("YoungJae");
		System.out.println(p1.equals(p2)); // false
	}

	
	
	
}


