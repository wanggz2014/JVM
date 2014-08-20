/**
 * wgz
 * monitor
 * MonitorWaitTest.java
 * 
 * 2014-7-31-下午02:01:14
 *  2014wgz
 * 
 */
package monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * MonitorWaitTest  线程等待演示代码
 * 
 * wgz
 * wgz
 * 2014-7-31 下午02:01:14
 * 
 * @version 1.0.0
 * 
 */
public class MonitorWaitTest {
	
	/**
	 * 
	 * createBusyThread(线程死循环演示)
	 *  
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public static Thread createBusyThread(){
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				//忙等线程
				while(keepRunning){
					
						;
					
				}
				
				System.out.println("busy end");
				
			}
		},"teatBusyThread");
		
		thread.start();
		return thread;
	}
	
	public static void createOtherBusyThread(){
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				//忙等线程
				while(true){
					
						;
					
				}
				
			}
		},"teatOtherBusyThread");
		
		thread.start();
	}
	
	/**
	 * 
	 * createLockThread(线程等待演示)
	 * 
	 * @param lock 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public static Thread createLockThread(final Object lock){
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				};
				
			}
		},"testLockThread");
		thread.start();
		return thread;
	}
	
	private static volatile boolean keepRunning=true; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		final Thread busy=createBusyThread();
		br.readLine();
		Object obj=new Object();
		final Thread lock=createLockThread(obj);
		/*Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				keepRunning=false;
				try {
					busy.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lock.interrupt();
				try {
					lock.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"shutdownhook"));*/
		
		//createOtherBusyThread();
		
		//System.exit(0);
		
	}
	
	
}
