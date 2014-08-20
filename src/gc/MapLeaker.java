/**
 * wgz
 * gc
 * MapLeaker.java
 * 
 * 2014-7-25-上午11:46:08
 *  2014wgz
 * 
 */
package gc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * MapLeaker    基于普通Map的内存泄露程序，在任务完成后，未在map中删除对应的KEY-VALUE  
 * 
 * vm args:  -XX:+HeapDumpOnCtrlBreak -XX:+HeapDumpOnOutOfMemoryError
 * 
 * wgz
 * wgz
 * 2014-7-25 上午11:46:08
 * 
 * @version 1.0.0
 * 
 */
public class MapLeaker {

	public ExecutorService exec=Executors.newFixedThreadPool(5);
	
	public Map<Task,TaskStatus> taskStatus=Collections.synchronizedMap(new WeakHashMap<Task, TaskStatus>());
	
	
	private enum TaskStatus {NOT_STARTED,STARTED,FINISHED};
	
	private class Task implements Runnable{

		
		@Override
		public void run() {
			
			taskStatus.put(this, TaskStatus.STARTED);
			try {
				Thread.sleep(1000*3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			taskStatus.put(this, TaskStatus.FINISHED);
			
		}
		
		
	}
	
	public Task newTask(){
		Task task=new Task();
		taskStatus.put(task, TaskStatus.NOT_STARTED);
		exec.execute(task);
		return task;
	}
	
	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void main(String[] args) {
		MapLeaker mapLeaker=new MapLeaker();
		int i=0;
		while(i<1000){
			mapLeaker.newTask();
			i++;
		}
	}
	
	public void finalizer(){
		
	}

}
