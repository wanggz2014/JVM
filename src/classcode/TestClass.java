/**
 * wgz
 * classcode
 * TestClass.java
 * 
 * 2014-8-6-上午09:47:14
 *  2014wgz
 * 
 */
package classcode;

import java.util.HashMap;

/**
 * 
 * TestClass
 * 
 * wgz
 * wgz
 * 2014-8-6 上午09:47:14
 * 
 * @version 1.0.0
 * 
 */
public class TestClass {
	
	private static final int m=3;
	
	private Integer n;
	
	
	
	public int inc(){
		HashMap<Integer, String> map=new HashMap<Integer, String>();
		int x;
		try{
			x=1;
			return x;
		}catch(Exception e){
			x=2;
			return x;
		}finally{
			x=3;
		}
	}
	
	public int myinc(){
		return m+4;
	}
}
