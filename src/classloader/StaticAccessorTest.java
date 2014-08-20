/**
 * wgz
 * classloader
 * StaticAccessorTest.java
 * 
 * 2014-8-2-下午11:06:34
 *  2014wgz
 * 
 */
package classloader;

import java.lang.reflect.InvocationTargetException;

/**
 * 
 * StaticAccessorTest
 * 
 * wgz
 * wgz
 * 2014-8-2 下午11:06:34
 * 
 * @version 1.0.0
 * 
 */
public class StaticAccessorTest {

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws SecurityException 
	 * @throws IllegalArgumentException 
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException, InvocationTargetException, NoSuchMethodException {
		
		CustomerClassLoader customLoading1=new CustomerClassLoader(StaticAccessorTest.class.getClassLoader());
		Class<StaticAccessor> cls=(Class<StaticAccessor>) customLoading1.loadClass("classloader.StaticAccessor");
		Object obj=cls.newInstance();
		cls.getMethod("runMe").invoke(obj);
		
		CustomerClassLoader customLoading2=new CustomerClassLoader(StaticAccessorTest.class.getClassLoader());
		Class<StaticAccessor> cls1=(Class<StaticAccessor>) customLoading2.loadClass("classloader.StaticAccessor");
		Object obj1=cls1.newInstance();
		cls1.getMethod("runMe").invoke(obj1);
	}

}
