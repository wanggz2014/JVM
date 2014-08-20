/**
 * wgz
 * gc
 * BigObjPretenure.java
 * 
 * 2014-7-29-下午04:05:34
 *  2014wgz
 * 
 */
package gc;

/**
 * 
 * BigObjPretenure  大对象直接进入老年代 ， 直接晋入老年代对象大小阀值为  1024*1024*3=3145728=3M
 * 
 * VM args: -Xms20m -Xmx20m -Xmn10m -verbose:gc -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * 
 * wgz
 * wgz
 * 2014-7-29 下午04:05:34
 * 
 * @version 1.0.0
 * 
 */
public class BigObjPretenure {

	private static final int _1MB=1024*1024;
	
	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) {
		byte[] allocation=new byte[4*_1MB];   //直接在老年代中分配

	}

}
