/**
 * wgz
 * classloader
 * CustomerClassLoader.java
 * 
 * 2014-8-2-下午02:26:05
 *  2014wgz
 * 
 */
package classloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * CustomerClassLoader
 * 
 * wgz
 * wgz
 * 2014-8-2 下午02:26:05
 * 
 * @version 1.0.0
 * 
 */
public class CustomerClassLoader extends ClassLoader {

	public CustomerClassLoader(ClassLoader parentLoader){
		super(parentLoader);
	}
	
	public Class<?> loadClass(String name) throws ClassNotFoundException{
		System.out.println("loading class "+name);
		if(name.startsWith("classloader.")){
			return this.getClass(name);
		}
		
		return super.loadClass(name);		
	}
	
	private Class<?> getClass(String name){
		String file=name.replace('.', '/')+".class";
		byte[] b=null;
		try{
			b=getClassData(file);
			Class<?> c=defineClass(name, b, 0, b.length);
			resolveClass(c);
			return c;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private byte[] getClassData(String name) throws Exception{
		InputStream in=CustomerClassLoader.class.getResourceAsStream("/"+name);
		byte[] availBytes=null;
		try{
			int size=in.available();
			availBytes=new byte[size];
			in.read(availBytes, 0, size);
		}finally{
			in.close();
		}
		return availBytes;
	}
}
