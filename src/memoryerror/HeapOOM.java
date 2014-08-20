/**
 * wgz
 * memoryerror
 * HeapOOM.java
 * 
 * 2014-7-24-上午09:47:25
 *  2014wgz
 * 
 */
package memoryerror;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * HeapOOM
 * VM args : -Xmx20m -Xms20m -XX:HeapDumpOnOutOfMemoryError  设置JAVA 堆 为固定  20m， 堆内存溢出的时候保存JVM 内存映像
 * 
 * wgz
 * wgz
 * 2014-7-24 上午09:54:49
 * 
 * @version 1.0.0
 * 
 */
public class HeapOOM {
	
	static class OOMObject{
		
	}
	
	public static void main(String[] args){
		List<OOMObject> list=new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
