/**
 * wgz
 * monitor
 * MonitorTest.java
 * 
 * 2014-7-31-下午01:29:53
 *  2014wgz
 * 
 */
package monitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MonitorTest  监控示例代码
 * 
 * vm args: -Xms100m -Xmx100m -XX:+UseSerialGC
 * wgz
 * wgz
 * 2014-7-31 下午01:29:53
 * 
 * @version 1.0.0
 * 
 */
public class MonitorTest {
	

	public static void fillHeap(int num) throws InterruptedException{
		List<OOMObject> list=new ArrayList<OOMObject>();
		for(int i=0;i<num;i++){
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		list=null;
		System.gc();
	}
	
	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) throws IOException, InterruptedException {		
		fillHeap(1000);
		System.in.read();
	}

}

class OOMObject{
	public byte[] placeholder=new byte[64*1024];
}
