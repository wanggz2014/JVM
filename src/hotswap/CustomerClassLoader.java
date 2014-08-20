/**
 * wgz
 * hotswap
 * CustomerClassLoader.java
 * 
 * 2014-8-4-上午10:16:48
 *  2014wgz
 * 
 */
package hotswap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 
 * CustomerClassLoader
 * 
 * wgz
 * wgz
 * 2014-8-4 上午10:16:48
 * 
 * @version 1.0.0
 * 
 */
public class CustomerClassLoader extends ClassLoader {	

	private URL url;
	
	public CustomerClassLoader(URL url,ClassLoader parentLoader){
		super(parentLoader);
		this.url=url;
		
	}
	
	protected synchronized Class<?> loadClass(String name, boolean resolve)
	throws ClassNotFoundException
    {
		if(name.indexOf("HotSwapDemo")>-1){
			return this.findClass(name);
		}
		return super.loadClass(name,resolve);
    }
	
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		String fullPath=name.replace(".", "/").concat(".class");
		InputStream in=null;
		try {
			in=new FileInputStream(url.getPath().replace("%20", " ").concat(fullPath));
			byte[] bufferByte=new byte[in.available()];
			in.read(bufferByte);
			return super.defineClass(name, bufferByte, 0, bufferByte.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
		
		
	}

}
