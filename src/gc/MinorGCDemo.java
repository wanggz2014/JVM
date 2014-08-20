/**
 * wgz
 * gc
 * MinorGCDemo.java
 * 
 * 2014-7-29-下午03:41:02
 *  2014wgz
 * 
 */
package gc;

/**
 * 
 * MinorGCDemo  演示新生代GC minor  gc
 * 
 * vm args:  -Xmx20m -Xms20m -Xmn10m -XX:PrintGCDetails -XX:SurvivorRatio=8
 * 
 * wgz
 * wgz
 * 2014-7-29 下午03:41:02
 * 
 * @version 1.0.0
 * 
 */
public class MinorGCDemo {
	
	private static final int _1MB=1024*1024;
	
	public static void main(String[] args){
		testAllocation();
	}
	
	private static void testAllocation(){
		byte[] allocation1,allocation2,allocation3,allocation4;
		allocation1=new byte[2*_1MB];
		allocation2=new byte[2*_1MB];
		allocation3=new byte[2*_1MB];
		allocation4=new byte[4*_1MB]; //发送一次minor gc
		                     
	}
}
