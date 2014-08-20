/**
 * wgz
 * classloader.reference
 * NotInitialization.java
 * 
 * 2014-8-12-下午04:17:03
 *  2014wgz
 * 
 */
package classloader.reference;

/**
 * 
 * NotInitialization
 * 
 * wgz
 * wgz
 * 2014-8-12 下午04:17:03
 * 
 * @version 1.0.0
 * 
 */
public class NotInitialization {

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) {
		//调用父类的静态变量，不会导致子类初始化
		//System.out.println(SubClass.superValue);
		
		//通过数值定义来引用类，不会触发类初始化
		//SuperClass[] sca=new SuperClass[10];
		
		//引用常量，因编译器优化从而不会触发常量所在类的初始化
		System.out.println(ConstClass.HELLOWORLD);
	}

}
