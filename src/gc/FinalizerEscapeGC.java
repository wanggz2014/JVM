/**
 * wgz
 * gc
 * FinalizerEscapeGC.java
 * 
 * 2014-7-25-下午03:36:59
 *  2014wgz
 * 
 */
package gc;

/**
 * 
 * FinalizerEscapeGC  一次对象自我拯救的演示
 * 演示目的：
 * 1、对象可以在被GC时自我拯救
 * 2、这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 * 3、每次GC会进行两次标记，每次标记会进行一次可达性分析
 * 
 * vm args: -XX:+PrintGC -XX:+PrintGCDetails
 * 
 * wgz
 * wgz
 * 2014-7-25 下午03:36:59
 * 
 * @version 1.0.0
 * 
 */
public class FinalizerEscapeGC {
	
	public static FinalizerEscapeGC SAVE_HOOK=null;
	
	private byte[] bigbyte=new byte[1024*1024];
	
	public void isAlive(){
		System.out.println("yes,i am still alive");
	}
	
	@Override
	public void finalize() throws Throwable{
		super.finalize();
		System.out.println("finanize method executed");
		
		SAVE_HOOK=this;
	}
	
	public static void main(String[] args) throws Throwable{
		SAVE_HOOK=new FinalizerEscapeGC();
		
		//这个对象是用于证明每次GC进行两次标记,完成垃圾收集
		GCTime time=new GCTime();
		
		//第一次执行成功自救
		SAVE_HOOK=null;
		time=null;
		System.gc();
		
		//因为finalize方法优先级低，所以暂停0.5秒以等待它
		Thread.sleep(500);
		
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no, i am dead ");
		}
		
		//代码完全相同，但这次自救失败了
		SAVE_HOOK=null;
		System.gc();
		
		//因为finalize方法优先级低，所以暂停0.5秒以等待它
		Thread.sleep(500);
		
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no, i am dead ");
		}
		System.exit(0);
	}
	
	private static class GCTime{
		private byte[] bigbyte=new byte[1024*1024*2];
	}
	
	
}

