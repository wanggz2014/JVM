/**
 * wgz
 * other
 * ShutdownHook.java
 * 
 * 2014-7-31-上午10:07:27
 *  2014wgz
 * 
 */
package other;

import java.util.Locale;

/**
 * 
 * ShutdownHook
 * 
 * wgz
 * wgz
 * 2014-7-31 上午10:07:27
 * 
 * @version 1.0.0
 * 
 */
public class ShutdownHook extends Thread {

	private Thread workThread;
	
	public ShutdownHook(Thread workThread){
		this.workThread=workThread;
		this.workThread.start();
	}
	
	@Override
	public void run(){
		System.out.println("shutdownhook start");
		workThread.interrupt();
		try {
			workThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("shutdownhook finish");		
		
	}
	
	public static void main(String[] args){
		
		Thread workThread=new Thread(){
			public void run(){
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("workThread interrupt");
						break;
					}
					
				}
			}
		};
		Runtime.getRuntime().addShutdownHook(new ShutdownHook(workThread));
		System.exit(0);
	}
}

