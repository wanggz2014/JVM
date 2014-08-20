/**
 * wgz
 * memoryerror
 * RuntimeConstantPoolOOM.java
 * 
 * 2014-7-24-下午02:33:29
 *  2014wgz
 * 
 */
package memoryerror;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * RuntimeConstantPoolOOM
 * 运行时常量池导致的内存溢出异常
 * VM args: -XX:PermSize=10m -XX:MaxPermSize=10m  设置方法区内存为固定10m
 * 
 * wgz
 * wgz
 * 2014-7-24 下午02:33:29
 * 
 * @version 1.0.0
 * 
 */
public class RuntimeConstantPoolOOM {

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * 
	 * @param args 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) {
		
		//使用list保持着常量池引用，避免FULL GC 回收常量池行为
		List<String> list=new ArrayList<String>();
		int i=0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	
	}

}
