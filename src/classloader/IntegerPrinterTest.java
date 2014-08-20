/**
 * wgz
 * classloader
 * IntegerPrinterTest.java
 * 
 * 2014-8-2-下午02:58:29
 *  2014wgz
 * 
 */
package classloader;

import java.lang.reflect.InvocationTargetException;

/**
 * 
 * IntegerPrinterTest
 * 
 * wgz
 * wgz
 * 2014-8-2 下午02:58:29
 * 
 * @version 1.0.0
 * 
 */
public class IntegerPrinterTest {

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @throws Exception 
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) throws Exception {
		customerLoad();
		System.gc();
		System.in.read();
	}
	
	private static void customerLoad() throws Exception{
		CustomerClassLoader customerLoader=new CustomerClassLoader(IntegerPrinterTest.class.getClassLoader());
		Class<IntegerPrinter> clazz=(Class<IntegerPrinter>) customerLoader.loadClass("classloader.IntegerPrinter");
		Object instance=clazz.newInstance();
		clazz.getMethod("runMe").invoke(instance);
	}

}
