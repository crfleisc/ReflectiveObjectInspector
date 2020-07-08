package tests;

public class TestClassConstructor_Fields {
	public int f1;
	public int f2 = 1;
	public Object f3 = new Object();
	public Object f4;
	private int f5;
	private int f6 = 1;
	private Object f7 = new Object();
	private Object f8;
	int f9;
	int f10 = 1;
	Object f11 = new Object();
	Object f12;
	byte testByte = 1;
	double[] testArray = new double[]{1.1, 1.2};
	double[] testArray2 = new double[]{};
	String testString = "test";
	
	TestInspector recursiveTest = new TestInspector();
	
	public TestClassConstructor_Fields(){}
	public TestClassConstructor_Fields(int param){}
	public TestClassConstructor_Fields(Object param){}
	public TestClassConstructor_Fields(Object[] param){}
	public TestClassConstructor_Fields(int param1, Object param2, Object[] param3){}
	private TestClassConstructor_Fields(int param1, int param2){}
	TestClassConstructor_Fields(int param1, int param2, int param3){}

}
