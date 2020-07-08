package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import inspector.Inspector;
import testClasses.ClassA;
import testClasses.ClassB;
import testClasses.ClassD;

public class TestInspector {
	
	private interface TestInterface1 {}
	private interface TestInterface2{}
	
	private class TestClassA{ 
		public TestClassA(){}
		public void TestClassAMethod(){}
	}
	
	private class TestClassB extends TestClassA implements TestInterface1 {
		public TestClassB() throws Exception {}
		public void testClassBMethod(int param1) throws Exception{}
	}
	
	private class TestClassC extends TestClassB implements TestInterface1, TestInterface2{
		public TestClassC() throws Exception, Error {
			super();
		}
		public void testClassCMethod(int param1, Integer param2, String param3, String[] param4) throws Exception, Error{}
	}
	
	private class TestClassMethodReturn{
		public void TestClassMethodReturn_void(){}
		public int TestClassMethodReturn_int(){return 1;}
		public Integer TestClassMethodReturn_Integer(){return new Integer(1);}
		public String TestClassMethodReturn_String(){return "1";}
		public String[] TestClassMethodReturn_StringArray(){return new String[]{"1", "2", "3"};}
		public Object TestClassMethodReturn_Object(){return null;}
	}
	
	private final Class<?>[] constructorAParams = new Class<?>[]{};
	private final Class<?>[] constructorBParams = new Class<?>[]{int.class};
	private final Class<?>[] constructorCParams = new Class<?>[]{Object.class};
	private final Class<?>[] constructorDParams = new Class<?>[]{Object[].class};
	private final Class<?>[] constructorEParams = new Class<?>[]{int.class, Object.class, Object[].class};
	private final String[] constructorAParamsString = new String[]{"<none>"};
	private final String[] constructorBParamsString = new String[]{"int"};
	private final String[] constructorCParamsString = new String[]{"java.lang.Object"};
	private final String[] constructorDParamsString = new String[]{"java.lang.Object (array)"};
	private final String[] constructorEParamsString = new String[]{"int", "java.lang.Object", "java.lang.Object (array)"};
	
	private final Class<?>[] methodBParams = new Class<?>[]{int.class};
	private final String[] methodBParamsString = new String[]{"int"};
	private final Class<?>[] methodCParams = new Class<?>[]{int.class, Integer.class, String.class, String[].class};
	private final String[] methodCParamsString = new String[]{"int", "java.lang.Integer", "java.lang.String", "java.lang.String (array)"};
	
	public final int primitive = 1;
	public final int[] primitiveArray = new int[]{1, 2, 3};
	public final Object object = new Object();
	public final Object[] objectArray = new Object[]{new Object(), new Object(), new Object()};

	private Inspector inspector;
	private Method testMethodClass;
	private Field fieldPrimitive;
	private Field fieldPrimitiveArray;
	private Field fieldObject;
	private Field fieldObjectArray;
	private Constructor<?> testClassConstructorA;
	private Constructor<?> testClassConstructorB;
	private Constructor<?> testClassConstructorC;
	private Constructor<?> testClassConstructorD;
	private Constructor<?> testClassConstructorE;
	
	public void aMethod(){}
	
	@Before
	public void setup() throws NoSuchMethodException, SecurityException, NoSuchFieldException{
		inspector = new Inspector();
		testMethodClass = TestInspector.class.getMethod("aMethod", new Class<?>[]{});
		fieldPrimitive = TestInspector.class.getField("primitive");
		fieldPrimitiveArray = TestInspector.class.getField("primitiveArray");
		fieldObject = TestInspector.class.getField("object");
		fieldObjectArray = TestInspector.class.getField("objectArray");
		testClassConstructorA = TestClassConstructor_Fields.class.getConstructor(constructorAParams);
		testClassConstructorB = TestClassConstructor_Fields.class.getConstructor(int.class);
		testClassConstructorC = TestClassConstructor_Fields.class.getConstructor(constructorCParams);
		testClassConstructorD = TestClassConstructor_Fields.class.getConstructor(constructorDParams);
		testClassConstructorE = TestClassConstructor_Fields.class.getConstructor(constructorEParams);
	}
	
	@After
	public void tearDown() throws NoSuchMethodException, SecurityException{
		inspector = null;
		testMethodClass = null;
		fieldPrimitive = null;
		fieldPrimitiveArray = null;
		fieldObject = null;
		fieldObjectArray = null;
		testClassConstructorA = null;
		testClassConstructorB = null;
		testClassConstructorC = null;
		testClassConstructorD = null;
		testClassConstructorE = null;
	}
	
	@Test
	public void testNullFields() {
		assertNotNull(inspector);
		inspector.setValues(new ClassA(), true);
		assertNotNull(inspector.getObject());
		assertNotNull(inspector.getRecursive());
		
		inspector.setValues(new ClassA(), false);
		assertNotNull(inspector.getObject());
		assertNotNull(inspector.getRecursive());
	}
	
	@Test
	public void testNullFields2() {
		inspector.setValues(new ClassA(), false);
		assertNotNull(inspector.getObject());
		assertNotNull(inspector.getRecursive());
		
		inspector.setValues(new ClassA(), true);
		assertNotNull(inspector.getObject());
		assertNotNull(inspector.getRecursive());
	}
	
	@Test
	public void testNullFields3() throws Exception {
		inspector.setValues(new ClassB(), true);
		assertNotNull(inspector.getObject());
		assertNotNull(inspector.getRecursive());
		
		inspector.setValues(new ClassD(), false);
		assertNotNull(inspector.getObject());
		assertNotNull(inspector.getRecursive());
	}
	
	@Test
	public void testNullInspectMethodReturns(){
		inspector.setValues(new TestClassConstructor_Fields(), true);
		
		assertNotNull(inspector.getClassNameDeclared());
		assertNotNull(inspector.getImmediateSuperClassName());
		assertNotNull(inspector.getInterfaceImplementing());
		
//		assertNotNull(inspector.getClassConstructors());
		assertNotNull(inspector.getClassConstructorModifiers(testClassConstructorA));
		assertNotNull(inspector.getClassConstructorModifiers(testClassConstructorB));
		assertNotNull(inspector.getClassConstructorModifiers(testClassConstructorC));
		assertNotNull(inspector.getClassConstructorModifiers(testClassConstructorD));
		assertNotNull(inspector.getClassConstructorModifiers(testClassConstructorE));
		assertNotNull(inspector.getClassConstructorParameterTypes(testClassConstructorA));
		assertNotNull(inspector.getClassConstructorParameterTypes(testClassConstructorB));
		assertNotNull(inspector.getClassConstructorParameterTypes(testClassConstructorC));
		assertNotNull(inspector.getClassConstructorParameterTypes(testClassConstructorD));
		assertNotNull(inspector.getClassConstructorParameterTypes(testClassConstructorE));

//		assertNotNull(inspector.getClassFields());
		assertNotNull(inspector.getClassFieldModifiers(fieldPrimitive));
		assertNotNull(inspector.getClassFieldModifiers(fieldPrimitiveArray));
		assertNotNull(inspector.getClassFieldModifiers(fieldObject));
		assertNotNull(inspector.getClassFieldModifiers(fieldObjectArray));
		assertNotNull(inspector.getClassFieldType(fieldPrimitive));
		assertNotNull(inspector.getClassFieldType(fieldPrimitiveArray));
		assertNotNull(inspector.getClassFieldType(fieldObject));
		assertNotNull(inspector.getClassFieldType(fieldObjectArray));

		assertNotNull(inspector.getMethodDeclaredExceptionsThrown(testMethodClass));
		assertNotNull(inspector.getMethodDeclaredModifiers(testMethodClass));
		assertNotNull(inspector.getMethodDeclaredParameterTypes(testMethodClass));
		assertNotNull(inspector.getMethodDeclaredReturnType(testMethodClass));
//		assertNotNull(inspector.getMethodsDeclared());
	}
	
	@Test
	public void getClassNameDeclared(){
		inspector.setValues(new TestClassA(), false);
		assertArrayEquals(new String[]{"TestClassA"}, new String[]{inspector.getClassNameDeclared()});
	}
	
	@Test
	public void getImmediateSuperClassNameObject(){
		inspector.setValues(new TestClassA(), false);
		assertArrayEquals(new String[]{"java.lang.Object"}, new String[]{inspector.getImmediateSuperClassName()});
	}
	
	@Test
	public void getImmediateSuperClassNameCustom() throws Exception{
		inspector.setValues(new TestClassB(), false);
		assertArrayEquals(new String[]{"tests.TestInspector$TestClassA"}, new String[]{inspector.getImmediateSuperClassName()});
	}
	
	@Test
	public void getImmediateSuperClassNameMultipleCustom() throws Exception, Error{
		inspector.setValues(new TestClassC(), false);
		assertArrayEquals(new String[]{"tests.TestInspector$TestClassB"}, new String[]{inspector.getImmediateSuperClassName()});
		
		inspector.setValues(new TestClassB(), false);
		assertArrayEquals(new String[]{"tests.TestInspector$TestClassA"}, new String[]{inspector.getImmediateSuperClassName()});
		
		inspector.setValues(new TestClassA(), false);
		assertArrayEquals(new String[]{"java.lang.Object"}, new String[]{inspector.getImmediateSuperClassName()});
	}
	
	@Test
	public void getInterfaceImplementing() throws Exception{
		inspector.setValues(new TestClassA(), true);
		assertArrayEquals(new String[]{"<none>"}, inspector.getInterfaceImplementing());
		
		inspector.setValues(new TestClassB(), true);
		assertArrayEquals(new String[]{"tests.TestInspector$TestInterface1"}, inspector.getInterfaceImplementing());
		
		inspector.setValues(new TestClassC(), true);
		assertArrayEquals(new String[]{"tests.TestInspector$TestInterface1", "tests.TestInspector$TestInterface2"}, inspector.getInterfaceImplementing());
	}
	
	@Test
	public void getMethodDeclaredExceptionsThrown() throws Exception{
		inspector.setValues(new TestClassA(), true);
		testMethodClass = TestClassA.class.getDeclaredMethod("TestClassAMethod", new Class<?>[]{});
		assertArrayEquals(new String[]{"<none>"}, inspector.getMethodDeclaredExceptionsThrown(testMethodClass));
		
		inspector.setValues(new TestClassB(), true);
		testMethodClass = TestClassB.class.getDeclaredMethod("testClassBMethod", methodBParams);
		assertArrayEquals(new String[]{"java.lang.Exception"}, inspector.getMethodDeclaredExceptionsThrown(testMethodClass));
		
		inspector.setValues(new TestClassC(), true);
		testMethodClass = TestClassC.class.getDeclaredMethod("testClassCMethod", methodCParams);
		assertArrayEquals(new String[]{"java.lang.Exception", "java.lang.Error"}, inspector.getMethodDeclaredExceptionsThrown(testMethodClass));
	}
	
	@Test
	public void getMethodDeclaredParameterTypes() throws Exception{
		inspector.setValues(new TestClassA(), true);
		testMethodClass = TestClassA.class.getDeclaredMethod("TestClassAMethod", new Class<?>[]{});
		assertArrayEquals(new String[]{"<none>"}, inspector.getMethodDeclaredParameterTypes(testMethodClass));
		
		inspector.setValues(new TestClassB(), true);
		testMethodClass = TestClassB.class.getDeclaredMethod("testClassBMethod", methodBParams);
		assertArrayEquals(new String[]{"int"}, inspector.getMethodDeclaredParameterTypes(testMethodClass));
		assertArrayEquals(methodBParamsString, inspector.getMethodDeclaredParameterTypes(testMethodClass));
		
		inspector.setValues(new TestClassC(), true);
		testMethodClass = TestClassC.class.getDeclaredMethod("testClassCMethod", methodCParams);
		assertArrayEquals(new String[]{"int", "java.lang.Integer", "java.lang.String", "java.lang.String (array)"}, inspector.getMethodDeclaredParameterTypes(testMethodClass));
		assertArrayEquals(methodCParamsString, inspector.getMethodDeclaredParameterTypes(testMethodClass));
	}
	
	@Test
	public void getMethodDeclaredReturnType() throws Exception{
		inspector.setValues(new TestClassMethodReturn(), true);
		
		testMethodClass = TestClassMethodReturn.class.getDeclaredMethod("TestClassMethodReturn_void", new Class<?>[]{});
		assertArrayEquals(new String[]{"void"}, new String[]{inspector.getMethodDeclaredReturnType(testMethodClass)});
		
		testMethodClass = TestClassMethodReturn.class.getDeclaredMethod("TestClassMethodReturn_int", new Class<?>[]{});
		assertArrayEquals(new String[]{"int"}, new String[]{inspector.getMethodDeclaredReturnType(testMethodClass)});
		
		testMethodClass = TestClassMethodReturn.class.getDeclaredMethod("TestClassMethodReturn_Integer", new Class<?>[]{});
		assertArrayEquals(new String[]{"Integer"}, new String[]{inspector.getMethodDeclaredReturnType(testMethodClass)});

		testMethodClass = TestClassMethodReturn.class.getDeclaredMethod("TestClassMethodReturn_String", new Class<?>[]{});
		assertArrayEquals(new String[]{"String"}, new String[]{inspector.getMethodDeclaredReturnType(testMethodClass)});

		testMethodClass = TestClassMethodReturn.class.getDeclaredMethod("TestClassMethodReturn_StringArray", new Class<?>[]{});
		assertArrayEquals(new String[]{"java.lang.String (array)"}, new String[]{inspector.getMethodDeclaredReturnType(testMethodClass)});

		testMethodClass = TestClassMethodReturn.class.getDeclaredMethod("TestClassMethodReturn_Object", new Class<?>[]{});
		assertArrayEquals(new String[]{"Object"}, new String[]{inspector.getMethodDeclaredReturnType(testMethodClass)});
	}
	
	@Test
	public void getMethodDeclaredModifiers(){
		inspector.setValues(new TestClassMethodModifiers(){
			public void TestClassMethodModifiers_Public_Abstract(){}
			protected void TestClassMethodModifiers_Protected_Abstract(){}
			void TestClassMethodModifiers_Abstract(){}
			}, true);
		
		Method[] testMethods = TestClassMethodModifiers.class.getMethods();
		for(Method m : testMethods){
			testMethodClass = m;
			if(testMethodClass.getName().startsWith("TestClassMethodModifiers_"))
				assertTrue(inspector.getMethodDeclaredModifiers(testMethodClass).equals(extractModifiersFromName(testMethodClass.getName())));
		}
	}
	/*
	 * Utility method that allows the method names to be used to generate the modifiers we are looking for.
	 */
	private String extractModifiersFromName(String name) {
		return name.substring(25, name.length()).replace('_', ' ').toLowerCase().trim();
	}
	
	@Test
	public void getClassConstructorParameterTypes(){
		assertArrayEquals(inspector.getClassConstructorParameterTypes(testClassConstructorA), constructorAParamsString);
		assertArrayEquals(inspector.getClassConstructorParameterTypes(testClassConstructorB), constructorBParamsString);
		assertArrayEquals(inspector.getClassConstructorParameterTypes(testClassConstructorC), constructorCParamsString);
		assertArrayEquals(inspector.getClassConstructorParameterTypes(testClassConstructorD), constructorDParamsString);
		assertArrayEquals(inspector.getClassConstructorParameterTypes(testClassConstructorE), constructorEParamsString);
	}
	
	@Test
	public void getClassConstructorModifiers(){
		Constructor<?>[] constructors = TestClassConstructor_Fields.class.getDeclaredConstructors();
		String[] modifiers = new String[]{"public", "public", "private", "package", "public", "public", "public"};
		String inspectorModifiers;
		for(int i=0; i<constructors.length; i++){
			inspectorModifiers = inspector.getClassConstructorModifiers(constructors[i]);
			assertTrue(inspectorModifiers.equals(modifiers[i]));
		}
	}
	
	@Test
	public void getClassConstructors() throws IllegalArgumentException, IllegalAccessException{
		inspector.inspect(new ClassB[12][12], true);
	}
	

}
