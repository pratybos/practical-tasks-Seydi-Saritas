package application;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleToIntFunction;
import java.util.function.LongToDoubleFunction;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

	private Boolean isDark = false;

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/calculator.fxml"));
		Parent root = loader.load();

		Button foo = (Button) loader.getNamespace().get("changeTheme");

		foo.setOnAction(e -> {
			if (isDark) {
				setUserAgentStylesheet(STYLESHEET_MODENA);
				isDark = false;
			} else {
				setUserAgentStylesheet("DarkTheme.css");
				isDark = true;
			}
		});

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.centerOnScreen();
		stage.setTitle("Calculator");
		stage.show();
	}

	public static void main(String[] args) {

		// Two different functional interfaces from java.util.function

		System.out.println("Two different functional interfaces from java.util.function");
		DoubleToIntFunction truncate = a -> (int) a;
		System.out.println();
		System.out.println("DoubleToIntFunction: " + truncate.applyAsInt(10.6));

		LongToDoubleFunction ob = a -> (double) a;
		System.out.println("LongToDoubleFunction: " + ob.applyAsDouble(3));

		MyCustomInterface myCustomInterface = new MyCustomInterface() {

			@Override
			public double applyAsDouble(long value) {
				return (double) value;
			}

			@Override
			public int applyAsInt(double value) {
				// TODO Auto-generated method stub
				return (int) value;
			}
		};

		System.out.println();
		System.out.println("myCustomInterface applyAsInt: " + myCustomInterface.applyAsInt(10.6));
		System.out.println("myCustomInterface applyAsDouble: " + myCustomInterface.applyAsDouble(3));

		// Default and Static methods

		A a = new A();

		System.out.println();
		System.out.println("Default and Static methods\n");
		System.out.println(MyCustomInterface.myStaticMethod());
		System.out.println(a.myDefaultMethod());

		// Factory design pattern

		MyFactoryClass myFactoryClass = new MyFactoryClass();

		System.out.println();
		System.out.println("Factory Design Pattern");
		System.out.println();

		Print printB = myFactoryClass.getPrint("B");
		Print printC = myFactoryClass.getPrint("C");
		Print printD = myFactoryClass.getPrint("D");

		printB.print();
		printC.print();
		printD.print();

		// Generic and super extends types
		System.out.println();
		System.out.println("Generic class with 5 different functions\n");

		MyGenericClass<Integer> iObj = new MyGenericClass<Integer>();
		MyGenericClass<String> sObj = new MyGenericClass<String>();
		MyGenericClass<Boolean> bObj = new MyGenericClass<Boolean>();
		MyGenericClass<Double> dObj = new MyGenericClass<Double>();
		MyGenericClass<Long> lObj = new MyGenericClass<Long>();

		iObj.genericDisplay(15);
		sObj.genericDisplay("GeeksForGeeks");
		bObj.genericDisplay(true);
		dObj.genericDisplay(15.0D);
		lObj.genericDisplay(15L);

		System.out.println();

		System.out.println("Extends, super and ? types\n");

		MyExtendsClass myExtendsClass = new MyExtendsClass(10);
		MyExtendsClass myExtendsClass2 = new MyExtendsClass(10.5F);

		System.out.println("Extends -> Convert int to double: " + myExtendsClass.getV());
		System.out.println("Extends -> Convert float to double: " + myExtendsClass2.getV());

		System.out.println();

		// Sorting with comparable and comparator
		// Comparator
		// 1st example

		System.out.println("Sorting with comparable and comparator\n");
		System.out.println("Comparable first example\n");

		List<Simpson> simpsons = new ArrayList<>();
		simpsons.add(new Simpson("Homer "));
		simpsons.add(new Simpson("Marge "));
		simpsons.add(new Simpson("Bart "));
		simpsons.add(new Simpson("Lisa "));

		Collections.sort(simpsons);
		simpsons.stream().map(s -> s.name).forEach(System.out::print);

		// 2nd example
		System.out.println("\n\nComparable second example\n");

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(20));
		employees.add(new Employee(43));
		employees.add(new Employee(37));
		employees.add(new Employee(12));

		Collections.sort(employees);
		employees.stream().map(s -> s.empAge).forEach(System.out::println);

		System.out.println();

		// Comparison
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student("Ahmet", 23));
		al.add(new Student("Mehmet", 47));
		al.add(new Student("Fatma", 16));

		System.out.println("Sorting by Name\n");

		Collections.sort(al, new NameComparator());
		for (Student st : al) {
			System.out.println(st.name + " " + st.age);
		}

		System.out.println("\nSorting by age\n");

		Collections.sort(al, new AgeComparator());
		for (Student st : al) {
			System.out.println(st.name + " " + st.age);
		}

		System.out.println();

		// Annotations
		System.out.println("Annotations\n");

		Samsung samsung = new Samsung("Fire", 5);
		IPhone iphone = new IPhone("Water", 8);

		System.out.println("Phone name and size BEFORE using annotation\n");
		System.out.println(samsung.getOs() + " " + samsung.getVersion());
		System.out.println(iphone.getOs() + " " + iphone.getVersion());

		Class<? extends Samsung> classSamsung = samsung.getClass();
		Annotation annotationSamsung = classSamsung.getAnnotation(SmartPhone.class);
		SmartPhone smartphoneSamsung = (SmartPhone) annotationSamsung;

		Class<? extends IPhone> classIphone = iphone.getClass();
		Annotation annotationIphone = classIphone.getAnnotation(SmartPhone.class);
		SmartPhone smartphoneIphone = (SmartPhone) annotationIphone;

		System.out.println("\nPhone name and size AFTER using annotation\n");

		System.out.println(smartphoneSamsung.os() + " " + smartphoneSamsung.version());
		System.out.println(smartphoneIphone.os() + " " + smartphoneIphone.version());

		System.out.println("\nLombok\n");
		
		MyLombokClass myLombokClass = new MyLombokClass(34);
		
		System.out.println("Value of my lombok class without any getter: " + myLombokClass.getValue());
		myLombokClass.setValue(999);
		System.out.println("Value of my lombok class after setting it without any setter: " + myLombokClass.getValue());

		launch(args);

	}

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
	String os() default "Symbian";

	int version() default 1;
}