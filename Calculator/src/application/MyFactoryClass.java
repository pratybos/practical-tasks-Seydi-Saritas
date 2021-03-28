package application;

public class MyFactoryClass {
	
	public Print getPrint(String printType) {
		if (printType == null) {
			return null;
		}
		if (printType.equalsIgnoreCase("B")) {
			return new B();

		} else if (printType.equalsIgnoreCase("C")) {
			return new C();

		} else if (printType.equalsIgnoreCase("D")) {
			return new D();
		}

		return null;
	}

}
