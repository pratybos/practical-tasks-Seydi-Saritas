package application;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {

	/*
	 * Comparator class for String
	 */

	public int compare(Student s1, Student s2) {
		return s1.name.compareTo(s2.name);
	}
}