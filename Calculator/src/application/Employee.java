package application;

public class Employee implements Comparable<Employee> {
	
	/*
	 * Comparable example class 2
	 */

	int empAge;

	public Employee(int age) {
		this.empAge = age;
	}

	@Override
	public int compareTo(Employee e) {
		if (this.empAge == e.empAge)
			return 0;
		else if (this.empAge > e.empAge)
			return 1;
		else
			return -1;
	}

}
