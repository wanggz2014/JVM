/**
 * wgz
 * memoryerror
 * DirectMemoryOOM.java
 * 
 * 2014-7-24-下午03:00:39
 *  2014wgz
 * 
 */
package memoryerror;

import java.lang.reflect.Field;



/**
 * 
 * DirectMemoryOOM  使用unsafe分配本机内存
 * 
 * VM Args: -Xmx20m -XX:MaxDirectMemorySize=10m
 * 
 * wgz
 * wgz
 * 2014-7-24 下午03:00:39
 * 
 * @version 1.0.0
 * 
 */
public class DirectMemoryOOM {

	private static final int _1MB=1024*1024;
	
	public static void main(String[] args){
		//Field unsafeField=Unsafe.class.getDeclaredFields()[0];
	}
}
