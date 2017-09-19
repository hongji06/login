package junit.test;

public class IntegerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 120;
		Integer i2 = 120;
		Integer i3 = new Integer(120);
		Integer i4 = new Integer(120);
		// Integer会自动拆箱为int，所以为true
		System.out.println(i == i2);
		System.out.println(i == i3);
		System.out.println(i3 == i4);
		System.out.println("**************");
		Integer i5 = 127;// java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
		Integer i6 = 127;
		System.out.println(i5 == i6);
		// true
		/*
		 * Integer i5 = 128; Integer i6 = 128; System.out.println(i5 == i6);//false
		 */
		Integer ii5 = new Integer(127);
		System.out.println(i5 == ii5); // false
		Integer i7 = new Integer(128);
		Integer i8 = new Integer(128);
		System.out.println(i7 == i8); // false
	}

}
