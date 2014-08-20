/**
 * wgz
 * classloader
 * ThreeDefaultClassloader.java
 * 
 * 2014-8-2-下午01:32:04
 *  2014wgz
 * 
 */
package classloader;



/**
 * 
 * ThreeDefaultClassloader  默认三种类加载器，启动类加载器（bootstrap class loader）\ 扩展类加载器（ext class loader）\ 应用程序类加载器（app class loader）
 * 
 * wgz
 * wgz
 * 2014-8-2 下午01:32:04
 * 
 * @version 1.0.0
 * 
 */
public class ThreeDefaultClassloader {

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) {
		
		//启动类加载器    返回null
		System.out.println(Integer.class.getClassLoader());
		
		//扩展类加载器
		System.out.println("");
		
		//应用程序类加载器
		System.out.println(ThreeDefaultClassloader.class.getClassLoader());

	}

}
