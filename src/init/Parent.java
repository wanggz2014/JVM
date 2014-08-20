/**
 * wgz
 * init
 * Demo.java
 * 
 * 2014-8-13-下午01:48:54
 *  2014wgz
 * 
 */
package init;

/**
 * 
 * Demo
 * 
 * wgz
 * wgz
 * 2014-8-13 下午01:48:54
 * 
 * @version 1.0.0
 * 
 */
public class Parent {

	
	public static int a=1;
	static {
		a=2;
	}
	
	static class Sub extends Parent{
		public static int b=a;
	}
	
	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) {
		
		//此处输出的值为2，因为父类的<clinit>先于 子类
		System.out.println(Sub.b);
	}
	
	

}
