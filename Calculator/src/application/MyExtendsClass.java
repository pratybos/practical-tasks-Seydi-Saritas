package application;

public class MyExtendsClass {

	private double v;

	<T extends Number> MyExtendsClass(T t) {
		// Convert number type to double
		v = t.doubleValue();
	}

	public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}

}
