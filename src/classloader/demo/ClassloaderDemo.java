/**
 * wgz
 * classloader.demo
 * ClassloaderDemo.java
 * 
 * 2014-8-13-下午02:07:21
 *  2014wgz
 * 
 */
package classloader.demo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * 
 * ClassloaderDemo
 * 
 * wgz
 * wgz
 * 2014-8-13 下午02:07:21
 * 
 * @version 1.0.0
 * 
 */
public class ClassloaderDemo {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		ClassLoader myclassloader=new ClassLoader() {
			
			public Class<?> loadClass(String name) throws ClassNotFoundException{
				String path=name.substring(name.lastIndexOf(".")+1).concat(".class");
				InputStream is=getClass().getResourceAsStream(path);
				try{
					if(is==null){
						return super.loadClass(name);
					}
					byte[] availBytes=new byte[is.available()];
					is.read(availBytes);
					return super.defineClass(name, availBytes, 0, availBytes.length);
				}catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						if(is!=null){
							is.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return null;
			}
		};
		
		Object obj=myclassloader.loadClass("classloader.demo.ClassloaderDemo").newInstance();
		System.out.println(obj.getClass());
		//显示false 因为此时obj的类加载器是 myclassloader, 而 ClassloaderDemo的类加载是系统类加载器，所以class对象不相同
		System.out.println(obj instanceof ClassloaderDemo);
		Double value=new Double(Double.MAX_VALUE);
		System.out.println(NumberUtils.isNumber(value.toString()));
		System.out.println(NumberUtils.toDouble(value.toString()));
	}
}
