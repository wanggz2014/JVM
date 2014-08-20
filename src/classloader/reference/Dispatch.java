/**
 * wgz
 * classloader.reference
 * Dispatch.java
 * 
 * 2014-8-18-下午05:37:35
 *  2014wgz
 * 
 */
package classloader.reference;

/**
 * 
 * Dispatch
 * 
 * wgz
 * wgz
 * 2014-8-18 下午05:37:35
 * 
 * @version 1.0.0
 * 
 */
public class Dispatch {

	static class QQ{}
	
	static class My360{}
	
	static class Father{
		public void hardChoice(QQ arg){
			System.out.println("father is qq");
		}
		
		public void hardChoice(My360 arg){
			System.out.println("father is 360");
		}
	}
	
	static class Son extends Father{
		
		public void hardChoice(QQ arg){
			System.out.println("son is qq");
		}
		
		public void hardChoice(My360 arg){
			System.out.println("son is 360");
		}
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
		Father father=new Father();
		
		Father son=new Son();
		
		father.hardChoice(new My360());
		
		son.hardChoice(new QQ());
		

	}

}
