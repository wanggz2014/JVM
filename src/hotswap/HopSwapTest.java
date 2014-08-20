/**
 * wgz
 * hotswap
 * HopSwapTest.java
 * 
 * 2014-8-4-上午10:13:42
 *  2014wgz
 * 
 */
package hotswap;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;


/**
 * 
 * HopSwapTest
 * 
 * wgz
 * wgz
 * 2014-8-4 上午10:13:42
 * 
 * @version 1.0.0
 * 
 */
public class HopSwapTest {
	
	private static ClassLoader loader1=null;
	
	private static ClassLoader loader2=null;
	
	static {
		URL url=HopSwapTest.class.getResource("/");
		ClassLoader loader=HopSwapTest.class.getClassLoader();
		try{
			//loader1=new CustomerClassLoader(url,loader);
			loader1=new URLClassLoader(new URL[]{url});
			//URL url2=HopSwapTest.class.getResource("/hotswap/v20");
			//loader2=new CustomerClassLoader(url,loader);
			loader2=new URLClassLoader(new URL[]{url});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		
		show();
		loader1=null;
		loader2=null;
		System.gc();
		System.out.println("test");
	}
	
	private static void show() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		IHotSwap hotSwap=getHotSwap("v1.0");
		hotSwap.helloWorld();
		hotSwap=getHotSwap("v2.0");
		hotSwap.helloWorld();
		hotSwap=null;
		System.gc();
	}
	
	private static IHotSwap getHotSwap(String version) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		if(version.equals("v1.0")){
			return (IHotSwap)loader1.loadClass("hotswap.v10.HotSwapDemo").newInstance();
		}
		return (IHotSwap)loader2.loadClass("hotswap.v20.HotSwapDemo").newInstance();
	}
}
