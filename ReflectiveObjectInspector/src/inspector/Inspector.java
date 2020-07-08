package inspector;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Vector;

public class Inspector {
	private Class<?> superClass;
	private Class<?> objectClass;
	private Object object;
	private boolean recursive;
	private Vector<Class<?>> deepInspect = new Vector<Class<?>>(0,1);
	private Inspector inspector;
	
	
	/*
	 *  Primary method, initiates inspection of the passed object along with a
	 *  boolean value to indicate whether or not object fields should be inspected.
	 */
	public void inspect(Object obj, boolean rec){
		object = obj;
		recursive = rec;
		
		if(object.getClass().getName().equals("java.lang.Class"))
			objectClass = (Class<?>) object;
		else
			objectClass = obj.getClass();
		
		while(objectClass.isArray()){
			objectClass = objectClass.getComponentType();
		}
		
		while(true){
			System.out.print("Class Name:             ");
			print(getClassNameDeclared());
			System.out.print("Immediate super class:  ");
			print(getImmediateSuperClassName());
			System.out.print("Interface implementing: ");
			print(getInterfaceImplementing());
			System.out.println("	Methods Declared");
			getMethodsDeclared();
			System.out.println("	Class Constructors");
			getClassConstructors();
			System.out.println("	     Fields");
			border();
			getClassFields();

			if(recursive)
				for(Class<?> c : deepInspect)
						deepInspect = deepInspect(c);
				
			if(superClass == null)
				break;
			objectClass = superClass;
		}
	}
	
	public Vector<Class<?>> deepInspect(Object obj){
		inspector = new Inspector();
		inspector.inspect(obj, false);
		return inspector.getDeepInspect();
	}
	
	public Vector<Class<?>> getDeepInspect(){
		return deepInspect;
	}
	
	public Object getObject(){
		return object;
	}
	
	public boolean getRecursive(){
		return recursive;
	}
	
	public void setValues(Object o, boolean rec){
		object = o;
		objectClass = o.getClass();
		recursive = rec;
	}

	/*
	 * 			INSPECTOR CLASSES
	 */
	public String getClassNameDeclared(){
		return objectClass.getSimpleName();
	}
	
	public String getImmediateSuperClassName(){
		Class<?> objSuperClass = objectClass.getSuperclass();
		superClass = objSuperClass;
		if(superClass == null)
			return "";
		return objSuperClass.getName();
	}
	
	public String[] getInterfaceImplementing(){
		Class<?>[] interfaces = objectClass.getInterfaces();
		for(Class<?> c : interfaces){
			if(!deepInspect.contains(c))
				deepInspect.addElement(c);
		}
		return classToString(interfaces);
	}

	public void getMethodsDeclared(){
		Method[] m = objectClass.getDeclaredMethods();
		for(int i=0; i<m.length; i++){
			System.out.print("Method name:     ");
			print(m[i].getName());
			System.out.print("Modifiers:       ");
			print(getMethodDeclaredModifiers(m[i]));
			System.out.print("Exceptions:      ");
			print(getMethodDeclaredExceptionsThrown(m[i]));
			System.out.print("Parameter Types: ");
			print(getMethodDeclaredParameterTypes(m[i]));
			System.out.print("Return Types:    ");
			print(getMethodDeclaredReturnType(m[i]));
			print("");
		}
	}
	
	public String[] getMethodDeclaredExceptionsThrown(Method m){
		return classToString(m.getExceptionTypes());
	}

	public String[] getMethodDeclaredParameterTypes(Method m){
		return classToString(m.getParameterTypes());
	}

	public String getMethodDeclaredReturnType(Method m){
		return m.getReturnType().isArray() ? m.getReturnType().getComponentType().getName() + " (array)" : classToString(m.getReturnType());
	}
	
	public String getMethodDeclaredModifiers(Method m){
		return Modifier.toString(m.getModifiers());
	}
	
	public void getClassConstructors(){
		Constructor<?>[] constructors = objectClass.getDeclaredConstructors();
		for(Constructor<?> c : constructors){
			System.out.print("\nName:            ");
			print(c.getName());
			System.out.print("Parameter Types: ");
			print(getClassConstructorParameterTypes(c));
			System.out.print("Modifiers:       ");
			print(getClassConstructorModifiers(c));	
			print("");
		}
	}

	public String[] getClassConstructorParameterTypes(Constructor<?> c){
		return classToString(c.getParameterTypes());
	}
	
	public String getClassConstructorModifiers(Constructor<?> c){
		String ret = Modifier.toString(c.getModifiers());
		if(ret.equals(""))
			return "package";
		return ret;
	}


	public void getClassFields(){
		Field[] classObjFields = objectClass.getDeclaredFields();
		for(Field f: classObjFields){
			printClassField(f);
		}
	}

	public String getClassFieldType(Field f){
		return f.getType().getName();
	}
	
	public String getClassFieldModifiers(Field f){
		String ret = Modifier.toString(f.getModifiers());
		if(ret.equals(""))
			return "package";
		return ret;
	}
	
	public void printClassField(Field f){
		Class<?> fieldType = f.getType();
		if(Modifier.toString(f.getModifiers()).equals(""))
			System.out.print("package ");
		
		if(!fieldType.isPrimitive()){
			if(recursive){
				if(!deepInspect.contains(f.getType()))
					deepInspect.add(f.getType());
			}
					
			print(f);
			f.setAccessible(true);
			if(f.getType().equals(String.class)){
				try {
					print("Value: " + f.get(object));
				} 
				catch (IllegalArgumentException e) {}
				catch (IllegalAccessException e) {}
			}
			else if(f.getType().isArray()){
				if(f.getType().getComponentType().isPrimitive()){
					try {
						Object element;
						Object array = f.get(object);
						int length = Array.getLength(array);
						
						System.out.print("Value: ");
						for (int i = 0; i < length; i ++) {
							element = Array.get(array, i);
							System.out.print(element + " ");
						}
					} 
					catch (IllegalArgumentException e) {e.printStackTrace();} 
					catch (IllegalAccessException e) {e.printStackTrace();}
				}
				else{
					if(!deepInspect.contains(f.getType().getComponentType()))
						deepInspect.add(f.getType().getComponentType());
					print(f);
				}
			}
		}
		else{
			print(f);

			f.setAccessible(true);
			try {
				System.out.print("Value: " + f.get(object));
			} 
			catch (IllegalArgumentException e) {}
			catch (IllegalAccessException e) {}
		}

		System.out.println("\n");
	}
	
	/*
	 * 				UTILITY METHODS
	 */
	public void print(String str){
		System.out.println(str);
	}
	
	public void printArr(String[] str){
		for(String s : str)
			System.out.println(s);
	}
	
	public void print(Object obj){
		if(obj == null)
			System.out.println("<none>");
		else
			System.out.println(obj);
	}
	
	public void print(Object[] arr){
		if(arr.length == 0)
			System.out.println("<none>");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		if(arr.length > 0)
			System.out.println();
	}
	
	public void border(){
		for(int i=0; i<70; i++)
			System.out.print("=");
		System.out.println();
	}
	
	private String classToString(Class<?> className) {
		return className.getSimpleName();
	}

	private String[] classToString(Class<?>[] classArray) {
		String[] ret = new String[classArray.length];
		if(classArray.length == 0)
			ret = new String[]{"<none>"};
		for(int i=0; i<classArray.length; i++)
			ret[i] = classArray[i].isArray() ? classArray[i].getComponentType().getName() + " (array)": classArray[i].getName();
		return ret;
	}

}
