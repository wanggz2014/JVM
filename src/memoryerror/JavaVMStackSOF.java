/**
 * wgz
 * memoryerror
 * JavaVMStackSOF.java
 * 
 * 2014-7-24-下午02:23:24
 *  2014wgz
 * 
 */
package memoryerror;

/**
 * 
 * JavaVMStackSOF 
 * 
 * VM args:  -Xss128k   将虚拟机栈的内存大小设置为128K
 * 
 * wgz
 * wgz
 * 2014-7-24 下午02:23:24
 * 
 * @version 1.0.0
 * 
 */
public class JavaVMStackSOF {

	private int stackLength=1;
	
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args){
		JavaVMStackSOF oom=new JavaVMStackSOF();
		try{
			oom.stackLeak();
		}catch(Throwable e){
			System.out.println(oom.stackLength);
			e.printStackTrace();
		}
	}
}
