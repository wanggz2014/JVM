/**
 * wgz
 * gc
 * ReferenceCountingGc.java
 * 
 * 2014-7-25-上午10:11:02
 *  2014wgz
 * 
 */
package gc;

/**
 * 
 * ReferenceCountingGc  引用计数算法的缺陷， 很难对循环引用问题进行解决
 * 
 * 此实例：最后结果为进行了内存回收，也就是说当前HOTSPAT虚拟机不是使用引用计数算法
 * 
 * vm args: -XX:+PrintGC  -XX:+PrintGCDetails
 * 
 * wgz
 * wgz
 * 2014-7-25 上午10:11:02
 * 
 * @version 1.0.0
 * 
 */
public class ReferenceCountingGc {

	public Object instance=null;
	
	private static final int _1MB=1024*1024;
	
	/**
	 * 这个变量存在的唯一目的是占用内存，以便看清楚GC中是否回收了内存
	 * 
	 */
	private byte[] bigSize=new byte[2*_1MB];
	
	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) {
		ReferenceCountingGc objA=new ReferenceCountingGc();
		
		ReferenceCountingGc objB=new ReferenceCountingGc();
		
		objA.instance=objB;
		
		objB.instance=objA;
		
		objA=null;
		objB=null;
		
		System.gc();

	}

}
