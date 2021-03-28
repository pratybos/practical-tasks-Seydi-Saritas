package application;

import java.util.function.DoubleToIntFunction;
import java.util.function.LongToDoubleFunction;

public interface MyCustomInterface extends DoubleToIntFunction, LongToDoubleFunction {

	default String myDefaultMethod() {
		return "This is a default method from my custom interface";
	}

	static String myStaticMethod() {
		return "This is a static method from my custom interface";
	}

}
