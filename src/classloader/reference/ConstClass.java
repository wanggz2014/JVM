/**
 * wgz
 * classloader.reference
 * ConstClass.java
 * 
 * 2014-8-12-下午04:33:20
 *  2014wgz
 * 
 */
package classloader.reference;

/**
 * 
 * ConstClass
 * 
 * wgz
 * wgz
 * 2014-8-12 下午04:33:20
 * 
 * @version 1.0.0
 * 
 */
public class ConstClass {

	static {
		System.out.println("ConstClass init!");
	}
	
	public static final String HELLOWORLD="hello  world!";
}
