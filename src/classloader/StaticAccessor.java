/**
 * wgz
 * classloader
 * StaticAccessor.java
 * 
 * 2014-8-2-下午11:03:07
 *  2014wgz
 * 
 */
package classloader;

/**
 * 
 * StaticAccessor
 * 
 * wgz
 * wgz
 * 2014-8-2 下午11:03:07
 * 
 * @version 1.0.0
 * 
 */
public class StaticAccessor {
	
	
	public void runMe(){
		
		System.out.println("-- Starting runMe. Static value: "+StaticHolder.value);
		StaticHolder.value=4;
		System.out.println("-- Finish runMe. Static value: "+StaticHolder.value);
	}
}
