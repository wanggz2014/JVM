/**
 * wgz
 * memoryerror
 * JavaMethodAreaOOM.java
 * 
 * 2014-7-24-下午02:51:13
 *  2014wgz
 * 
 */
package memoryerror;

/**
 * 
 * JavaMethodAreaOOM  借助CGLIB 使方法区内存溢出
 * 
 * VM args: -XX:PermSize=10m -XX:MaxPermSize=10m
 * 
 * wgz
 * wgz
 * 2014-7-24 下午02:51:13
 * 
 * @version 1.0.0
 * 
 */
public class JavaMethodAreaOOM {

	public static void main(String[] args){
		
		while(true){
			//Enhan
		}
	}
	
    static class OOMObject{
		
	}
}
