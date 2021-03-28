package application;

public class MyGenericClass<T> {

	public MyGenericClass() {
	}

	public <U> void genericDisplay(U element) {
		System.out.println(element.getClass().getName() + " = " + element);
	}

}