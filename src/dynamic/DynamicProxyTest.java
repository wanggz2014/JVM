package dynamic;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

public class DynamicProxyTest {

	static interface IHello{
		
		void sayHello();
		
	}
	
	static class Hello implements IHello{
		
		public void sayHello(){
			System.out.println("hello world");
		}
	}
	
	static class DynamicProxy implements InvocationHandler{
		
		private Object orig;
		
		public DynamicProxy(Object orig){
			this.orig=orig;
			
		}

		//代理处理
		@Override
		public Object invoke(Object arg0, Method arg1, Object[] arg2)
				throws Throwable {
			System.out.println("hello proxy");
			return arg1.invoke(orig, arg2);
		}
		
	}
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//ystem.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		Class[] interfaces=new Class[]{
				IHello.class
		};
		
		Hello hello=new Hello();
		
		IHello proxy=(IHello)Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(),interfaces, new DynamicProxy(hello));
		
		FileOutputStream os=new FileOutputStream("d:/$Proxy12.class"); 
		byte[] file=ProxyGenerator.generateProxyClass("$Proxy12", new Class[]{IHello.class});
		os.write(file);
		os.flush();
		os.close();
		proxy.sayHello();
	}

}
