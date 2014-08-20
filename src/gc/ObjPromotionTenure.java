/**
 * wgz
 * gc
 * ObjPromotionTenure.java
 * 
 * 2014-7-29-下午04:37:12
 *  2014wgz
 * 
 */
package gc;

/**
 * 
 * ObjPromotionTenure 长期存活对象进入老年代，  可以 -XX:MaxTenuringThreshold设置年龄阀值
 * 
 * vm args: -Xmx20m -Xms20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * 
 * wgz
 * wgz
 * 2014-7-29 下午04:37:12
 * 
 * @version 1.0.0
 * 
 */
public class ObjPromotionTenure {
	
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
		byte[] allocation1,allocation2,allocation3;
		
		allocation1=new byte[_1MB/4];
		//什么时候进入老年代取决于-XX:MaxTenuringThreshold设置
		allocation2=new byte[4*_1MB];
		allocation3=new byte[4*_1MB];
		allocation3=null;
		allocation3=new byte[4*_1MB];
	}

}
