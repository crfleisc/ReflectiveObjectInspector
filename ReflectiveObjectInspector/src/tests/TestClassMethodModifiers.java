package tests;

public abstract class TestClassMethodModifiers{
// 		1 param
		void TestClassMethodModifiers(){}
		public void TestClassMethodModifiers_Public(){}
		protected void TestClassMethodModifiers_Protected(){}
		private void TestClassMethodModifiers_Private(){}
		
// 		2 params
		abstract void TestClassMethodModifiers_Abstract();
		static void TestClassMethodModifiers_Static(){}
		final void TestClassMethodModifiers_Final(){}
		synchronized void TestClassMethodModifiers_Synchronized(){}
		native void TestClassMethodModifiers_Native();
		strictfp void TestClassMethodModifiers_Strictfp(){}
		
		public abstract void TestClassMethodModifiers_Public_Abstract();
		protected abstract void TestClassMethodModifiers_Protected_Abstract();
//		private abstract void TestClassMethodModifiers_Private_Abstract();
		
		public static void TestClassMethodModifiers_Public_Static(){}
		protected static void TestClassMethodModifiers_Protected_Static(){}
		private static void TestClassMethodModifiers_Private_Static(){}
		
		public final void TestClassMethodModifiers_Public_Final(){}
		protected final void TestClassMethodModifiers_Protected_Final(){}
		private final void TestClassMethodModifiers_Private_Final(){}
		
		public synchronized void TestClassMethodModifiers_Public_Synchronized(){}
		protected synchronized void TestClassMethodModifiers_Protected_Synchronized(){}
		private synchronized void TestClassMethodModifiers_Private_Synchronized(){}
		
		public native void TestClassMethodModifiers_Public_Native();
		protected native void TestClassMethodModifiers_Protected_Native();
		private native void TestClassMethodModifiers_Private_Native();
		
		public strictfp void TestClassMethodModifiers_Public_Strictfp() {}
		protected strictfp void TestClassMethodModifiers_Protected_Strictfp() {}
		private strictfp void TestClassMethodModifiers_Private_Strictfp() {}
		
// 		Access-abstract-X
//		abstract static void TestClassMethodModifiers_Abstract_Static();
//		public abstract static void TestClassMethodModifiers_Public_Abstract_Static();
//		protected abstract static void TestClassMethodModifiers_Protected_Abstract_Static();
//		private abstract static void TestClassMethodModifiers_Private_Abstract_Static();
//		
//		abstract final void TestClassMethodModifiers_Abstract_Static();
//		public abstract final void TestClassMethodModifiers_Public_Abstract_Static();
//		protected abstract final void TestClassMethodModifiers_Protected_Abstract_Static();
//		private abstract final void TestClassMethodModifiers_Private_Abstract_Static();
//		
//		abstract synchronized void TestClassMethodModifiers_Abstract_Synchronized();
//		public abstract synchronized void TestClassMethodModifiers_Public_Abstract_Synchronized();
//		protected abstract synchronized void TestClassMethodModifiers_Protected_Abstract_Synchronized();
//		private abstract synchronized void TestClassMethodModifiers_Private_Abstract_Synchronized();
//		
//		abstract native void TestClassMethodModifiers_Abstract_Native();
//		public abstract native void TestClassMethodModifiers_Public_Abstract_Native();
//		protected abstract native void TestClassMethodModifiers_Protected_Abstract_Native();
//		private abstract native void TestClassMethodModifiers_Private_Abstract_Native();
//		
//		abstract strictfp void TestClassMethodModifiers_Abstract_Strictfp();
//		public abstract strictfp void TestClassMethodModifiers_Public_Abstract_Strictfp();
//		protected abstract strictfp void TestClassMethodModifiers_Protected_Abstract_Strictfp();
//		private abstract strictfp void TestClassMethodModifiers_Private_Abstract_Strictfp();

// Access-static-X
		static final void TestClassMethodModifiers_Static_Final(){}
		public static final void TestClassMethodModifiers_Public_Static_Final(){}
		protected static final void TestClassMethodModifiers_Protected_Static_Final(){}
		private static final void TestClassMethodModifiers_Private_Static_Final(){}
		
		static synchronized void TestClassMethodModifiers_Static_Synchronized(){}
		public static synchronized void TestClassMethodModifiers_Public_Static_Synchronized(){}
		protected static synchronized void TestClassMethodModifiers_Protected_Static_Synchronized(){}
		private static synchronized void TestClassMethodModifiers_Private_Static_Synchronized(){}
		
		static native void TestClassMethodModifiers_Static_Native();
		public static native void TestClassMethodModifiers_Public_Static_Native();
		protected static native void TestClassMethodModifiers_Protected_Static_Native();
		private static native void TestClassMethodModifiers_Private_Static_Native();
		
		static strictfp void TestClassMethodModifiers_Static_Strictfp(){}
		public static strictfp void TestClassMethodModifiers_Public_Static_Strictfp(){}
		protected static strictfp void TestClassMethodModifiers_Protected_Static_Strictfp(){}
		private static strictfp void TestClassMethodModifiers_Private_Static_Strictfp(){}
		
// Access-final-X
		final synchronized void TestClassMethodModifiers_Final_Synchronized(){}
		public final synchronized void TestClassMethodModifiers_Public_Final_Synchronized(){}
		protected final synchronized void TestClassMethodModifiers_Protected_Final_Synchronized(){}
		private final synchronized void TestClassMethodModifiers_Private_Final_Synchronized(){}
		
		final native void TestClassMethodModifiers_Final_Native();
		public final native void TestClassMethodModifiers_Public_Final_Native();
		protected final native void TestClassMethodModifiers_Protected_Final_Native();
		private final native void TestClassMethodModifiers_Private_Final_Native();
		
		final strictfp void TestClassMethodModifiers_Final_Strictfp(){}
		public final strictfp void TestClassMethodModifiers_Public_Final_Strictfp(){}
		protected final strictfp void TestClassMethodModifiers_Protected_Final_Strictfp(){}
		private final strictfp void TestClassMethodModifiers_Private_Final_Strictfp(){}
		
// Access-Synchronized-X
		synchronized native void TestClassMethodModifiers_Synchronized_Native();
		public synchronized native void TestClassMethodModifiers_Public_Synchronized_Native();
		protected synchronized native void TestClassMethodModifiers_Protected_Synchronized_Native();
		private synchronized native void TestClassMethodModifiers_Private_Synchronized_Native();
		
		synchronized strictfp void TestClassMethodModifiers_Synchronized_Strictfp(){}
		public synchronized strictfp void TestClassMethodModifiers_Public_Synchronized_Strictfp(){}
		protected synchronized strictfp void TestClassMethodModifiers_Protected_Synchronized_Strictfp(){}
		private synchronized strictfp void TestClassMethodModifiers_Private_Synchronized_Strictfp(){}	
		
// Access-Native-X
//		native strictfp void TestClassMethodModifiers_Native_Strictfp();
//		public native strictfp void TestClassMethodModifiers_Public_Native_Strictfp();
//		protected native strictfp void TestClassMethodModifiers_Protected_Native_Strictfp();
//		private native strictfp void TestClassMethodModifiers_Private_Native_Strictfp();
		
// Access-Static-Final-X
		static final synchronized void TestClassMethodModifiers_Static_Final_Synchronized(){}
		public static final synchronized void TestClassMethodModifiers_Public_Static_Final_Synchronized(){}
		protected static final synchronized void TestClassMethodModifiers_Protected_Static_Final_Synchronized(){}
		private static final synchronized void TestClassMethodModifiers_Private_Static_Final_Synchronized(){}	
		
		static final native void TestClassMethodModifiers_Static_Final_Native();
		public static final native void TestClassMethodModifiers_Public_Static_Final_Native();
		protected static final native void TestClassMethodModifiers_Protected_Static_Final_Native();
		private static final native void TestClassMethodModifiers_Private_Static_Final_Native();
		
		static final strictfp void TestClassMethodModifiers_Static_Final_Strictfp(){}
		public static final strictfp void TestClassMethodModifiers_Public_Static_Final_Strictfp(){}
		protected static final strictfp void TestClassMethodModifiers_Protected_Static_Final_Strictfp(){}
		private static final strictfp void TestClassMethodModifiers_Private_Static_Final_Strictfp(){}	
		
// Access-Static-Synchronized-X
		static synchronized native void TestClassMethodModifiers_Static_Synchronized_Native();
		public static synchronized native void TestClassMethodModifiers_Public_Static_Synchronized_Native();
		protected static synchronized native void TestClassMethodModifiers_Protected_Static_Synchronized_Native();
		private static synchronized native void TestClassMethodModifiers_Private_Static_Synchronized_Native();
		
		static synchronized strictfp void TestClassMethodModifiers_Static_Synchronized_Strictfp(){}
		public static synchronized strictfp void TestClassMethodModifiers_Public_Static_Synchronized_Strictfp(){}
		protected static synchronized strictfp void TestClassMethodModifiers_Protected_Static_Synchronized_Strictfp(){}
		private static synchronized strictfp void TestClassMethodModifiers_Private_Static_Synchronized_Strictfp(){}
		
// Access-Static-Native-Strictfp
//		static native strictfp void TestClassMethodModifiers_Static_Native_Strictfp();
//		public static native strictfp void TestClassMethodModifiers_Public_Static_Native_Strictfp();
//		protected static native strictfp void TestClassMethodModifiers_Protected_Static_Native_Strictfp();
//		private static native strictfp void TestClassMethodModifiers_Private_Static_Native_Strictfp();
		
// Access-Static-Final-Synchronized-X
		static final synchronized native void TestClassMethodModifiers_Static_Final_Synchronized_Native();
		public static final synchronized native void TestClassMethodModifiers_Public_Static_Final_Synchronized_Native();
		protected static final synchronized native void TestClassMethodModifiers_Protected_Static_Final_Synchronized_Native();
		private static final synchronized native void TestClassMethodModifiers_Private_Static_Final_Synchronized_Native();
		
		static final synchronized strictfp void TestClassMethodModifiers_Static_Final_Synchronized_Strictfp(){}
		public static final synchronized strictfp void TestClassMethodModifiers_Public_Static_Final_Synchronized_Strictfp(){}
		protected static final synchronized strictfp void TestClassMethodModifiers_Protected_Static_Final_Synchronized_Strictfp(){}
		private static final synchronized strictfp void TestClassMethodModifiers_Private_Static_Final_Synchronized_Strictfp(){}
		
// Access-Static-Final-Synchronized-Native-Strictfp
//		static final synchronized native strictfp void TestClassMethodModifiers_Static_Final_Native_Strictfp();
//		public static final synchronized native strictfp void TestClassMethodModifiers_Public_Static_Final_Native_Strictfp();
//		protected static final synchronized native strictfp void TestClassMethodModifiers_Protected_Static_Final_Native_Strictfp();
//		private static final synchronized native strictfp void TestClassMethodModifiers_Private_Static_Final_Native_Strictfp();

//    <package visibility>
//    Modifier.PUBLIC         | Modifier.PROTECTED    | Modifier.PRIVATE |
//    Modifier.ABSTRACT       | Modifier.STATIC       | Modifier.FINAL   |
//    Modifier.SYNCHRONIZED   | Modifier.NATIVE       | Modifier.STRICT;
	}