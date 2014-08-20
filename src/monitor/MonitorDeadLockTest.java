/**
 * wgz
 * monitor
 * MonitorDeadLockTest.java
 * 
 * 2014-7-31-下午02:38:07
 *  2014wgz
 * 
 */
package monitor;

/**
 * 
 * MonitorDeadLockTest 死锁代码样式
 * 
 * wgz
 * wgz
 * 2014-7-31 下午02:38:07
 * 
 * @version 1.0.0
 * 
 */
public class MonitorDeadLockTest {

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			new Thread(new SynAddRunable(1, 2)).start();
			new Thread(new SynAddRunable(2,1)).start();
		}

	}

}


class SynAddRunable implements Runnable{

	int a,b;
	
	public SynAddRunable(int a,int b){
		this.a=a;
		this.b=b;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		//死锁原因：Interger.valueOf() 方法基于减少对象创建，会将【-128，27】之间的数字对象缓存，valueOf()返回的就是缓存对象,所以此处锁的
		//其实就是两个对象
		synchronized (Integer.valueOf(a)) {
			synchronized (Integer.valueOf(b)) {
				System.out.println(a+b);
			}
		}
		
	}
	
}
