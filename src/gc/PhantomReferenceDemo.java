/**
 * wgz
 * gc
 * PhantomReferenceDeom.java
 * 
 * 2014-7-26-下午04:03:52
 *  2014wgz
 * 
 */
package gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

/**
 * 
 * PhantomReferenceDeom
 * 
 * wgz
 * wgz
 * 2014-7-26 下午04:03:52
 * 
 * @version 1.0.0
 * 
 */
public class PhantomReferenceDemo {
	
	ReferenceQueue<Foo> queue=new ReferenceQueue<Foo>();
	
	ArrayList<FooReference<Foo>> referArray=new ArrayList<FooReference<Foo>>();
	
	ArrayList<Foo> list=new ArrayList<Foo>();
	
	public void test() throws InterruptedException{
		Foo foo;
		for(int i=0;i<10;i++){
			foo=new Foo("TEST"+i);
			
			list.add(foo);
			
			referArray.add(new FooReference<Foo>(foo, queue));
			
		}
		
		list=null;
		
		System.gc();
		
		Thread.sleep(1000);
		
		FooReference<Foo> item;
		while((item=(FooReference<Foo>) queue.poll())!=null){
			System.out.println(item.get());
			item.print();
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		PhantomReferenceDemo demo=new PhantomReferenceDemo();
		demo.test();
	}
	
	
	
}


class Foo{
	
	private String name="";
	
	public Foo(String name){
		this.name=name;
	}
	
	public String toString(){
		return name;
	}
	
}

class FooReference<T> extends PhantomReference<T>{

	private String info;
	
	/**
	 * 创建一个新的实例 FooReference.
	 *
	 * @param referent
	 * @param q
	 */
	public FooReference(T referent, ReferenceQueue<? super T> q) {
		super(referent, q);
		info=referent.toString();
	}
	
	public void print(){
		System.out.println(info);
	}
	
}
