/**
 * wgz
 * classloader.reference
 * DynamicDispatch.java
 * 
 * 2014-8-18-下午04:03:30
 *  2014wgz
 * 
 */
package classloader.reference;

/**
 * 
 * DynamicDispatch
 * 
 * wgz
 * wgz
 * 2014-8-18 下午04:03:30
 * 
 * @version 1.0.0
 * 
 */
public class DynamicDispatch {
	
	static abstract class Human{
		public abstract void sayHello();
	}
	
	static class Man extends Human{
		
		public void sayHello(){
			System.out.println("man");
		}
	}
	
	static class Woman extends Human{
		
		public void sayHello(){
			System.out.println("woman");
		}
	}
	
	public static void main(String[] args){
		Human man=new Man();
		Human woman=new Woman();
		man.sayHello();
		woman.sayHello();
		man=new Woman();
		man.sayHello();
		
	}
}
