/**
 * wgz
 * monitor
 * BTraceDemo.java
 * 
 * 2014-7-31-下午03:45:34
 *  2014wgz
 * 
 */
package monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * BTraceDemo BTrace跟踪演示
 * 
 * wgz
 * wgz
 * 2014-7-31 下午03:45:34
 * 
 * @version 1.0.0
 * 
 */
public class BTraceDemo {
	
	public int add(int a,int b){
		return a+b;
	}

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * 
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @throws IOException 
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) throws IOException {
		
		BTraceDemo demo=new BTraceDemo();
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<10;i++){
			reader.readLine();
			int a=(int)Math.round(Math.random()*1000);
			int b=(int)Math.round(Math.random()*1000);
			System.out.println(demo.add(a, b));
		}
	}

}
