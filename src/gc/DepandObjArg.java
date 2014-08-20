/**
 * wgz
 * gc
 * DepandObjArg.java
 * 
 * 2014-7-30-上午10:06:16
 *  2014wgz
 * 
 */
package gc;

/**
 * 
 * DepandObjArg   对象年龄动态判断 
 * 
 * vm args: -Xmx20m -Xms20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintGCDetials -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
 * 
 * wgz
 * wgz
 * 2014-7-30 上午10:06:16
 * 
 * @version 1.0.0
 * 
 */
public class DepandObjArg {

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
		
		byte[] allocation1,allocation2,allocation3,allocation4;
		
		allocation1=new byte[_1MB/4];
		//当相同年龄的对象大小之和大于 survivor 也会放入老年代
		//allocation1+allocation2大于survivor空间的一半
		allocation2=new byte[_1MB/4];
		
		allocation3=new byte[_1MB*4];
		allocation4=new byte[_1MB*4];
		allocation4=null;
		allocation4=new byte[_1MB*4];

	}

}
