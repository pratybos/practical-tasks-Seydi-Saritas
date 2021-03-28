package application;

public class Simpson implements Comparable<Simpson> {
	
	/*
	 * Comparable example class 1
	 */
	
	String name;

	Simpson(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Simpson simpson) {
		return this.name.compareTo(simpson.name);
	}

}
