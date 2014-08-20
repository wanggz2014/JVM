/**
 * wgz
 * other
 * running.java
 * 
 * 2014-7-30-下午11:16:41
 *  2014wgz
 * 
 */
package other;

/**
 * 
 * running
 * 
 * wgz
 * wgz
 * 2014-7-30 下午11:16:41
 * 
 * @version 1.0.0
 * 
 */
public class Running {
	
	public static volatile boolean keepRunning=true;

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) {
		
		final Thread thread=Thread.currentThread();
		
		PrintInfo info=new PrintInfo();
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			 public void run() {
			        keepRunning = false;
			        try {
						thread.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 }
		});
		info.run();
		
	}

}

class PrintInfo{
	private int i=0;
	
	public void run(){
		while(Running.keepRunning){
			System.out.println(++i);
		}
		System.out.println("false");
	}
}
