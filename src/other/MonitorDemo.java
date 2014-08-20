/**
 * wgz
 * other
 * MonitorDemo.java
 * 
 * 2014-8-12-下午02:07:26
 *  2014wgz
 * 
 */
package other;

/**
 * 
 * MonitorDemo
 * 
 * wgz
 * wgz
 * 2014-8-12 下午02:07:27
 * 
 * @version 1.0.0
 * 
 */
public class MonitorDemo {
	
	public static void main(String[] args){
		MonitorControl control=new MonitorControl(20);
		Produce pro=new Produce(control);
		Customer cus=new Customer(control);
		pro.start();
		cus.start();
	}
	
}

class Produce extends Thread{
	
	private MonitorControl control;
	
	public Produce(MonitorControl control){
		this.control=control;
	}
	
	private static int startInt=1;
	
	public void run(){
		while(true){
			int item=produceItem();
			control.insert(item);
		}
		
	}
	
	private int produceItem(){
		System.out.println("produce:"+(++startInt));
		return startInt;
	}
}

class Customer extends Thread{
	
	private MonitorControl control;
	
	public Customer(MonitorControl control){
		this.control=control;
	}
	
	public void run(){
		while(true){
			int item=this.control.remove();
			customerItem(item);
		}
	}
	
	private void customerItem(int item){
		System.out.println("customer:"+item);
	}
}

class MonitorControl{
	
	private int[] buff;
	private int count=0,lo=0,hi=0,buffSize=0;
	
	public MonitorControl(int buffSize){
		this.buffSize=buffSize;
		buff=new int[buffSize];
	}
	
	public synchronized void insert(int item){
		//如果缓存队列满了则等待
		if(count==buff.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buff[hi]=item;
		hi=(hi+1)%this.buffSize;
		count=count+1;
		if(count==1){ 
			this.notify();                   //如果消费者还在休眠，则叫醒
		}
	}
	
	public synchronized int remove(){
		//如果缓存队列为空则等待
		if(count==0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int item=buff[lo];
		lo=(lo+1)%this.buffSize;
		count=count-1;
		if(count==this.buffSize-1) {
			this.notify();   //如果生产者在休眠，则叫醒
		}
		return item;
	}
}

