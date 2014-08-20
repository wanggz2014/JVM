/**
 * wgz
 * gc
 * PromotionObjDemo.java
 * 
 * 2014-7-30-上午10:50:07
 *  2014wgz
 * 
 */
package gc;

import java.io.IOException;

/**
 * 
 * PromotionObjDemo   空间分配担保
 * 
 * vm args: -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:-HandlePromotionFailure -XX:SurvivorRatio=8
 * 
 * wgz
 * wgz
 * 2014-7-30 上午10:50:07
 * 
 * @version 1.0.0
 * 
 */
public class PromotionObjDemo {

	private static final int _1MB=1024*1024;
	
	private static byte[] staticAllocation=null;
	
	public static void main(String[] args) throws IOException{
		byte[] a1,a2,a3,a4,a5,a6,a7;
		
		a1=new byte[2*_1MB];
		
		a2=new byte[2*_1MB];
		
		a3=new byte[2*_1MB];
		a1=null;
		a4=new byte[2*_1MB];
		a5=new byte[2*_1MB];
		a6=new byte[2*_1MB];
		a4=null;
		a5=null;
		a6=null;
		a7=new byte[2*_1MB];
		
		staticAllocation=new byte[2*_1MB];
		
		System.in.read();
	}
}
