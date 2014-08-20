/**
 * wgz
 * bytecode
 * DynamicExpressDemo.java
 * 
 * 2014-8-1-上午10:07:32
 *  2014wgz
 * 
 */
package bytecode;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

/**
 * 
 * DynamicExpressDemo  动态计算功能，将一串字符串正则表达式进行计算
 * 
 * wgz
 * wgz
 * 2014-8-1 上午10:07:32
 * 
 * @version 1.0.0
 * 
 */
public class DynamicExpressDemo {
	
	public static double calculate(String expr) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, Exception{
		String className="CalculateMain";
		String methodName="calculate";
		String source="public class "+ className+"{ public static double "+methodName+"(){return "+expr+";}}";
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager=compiler.getStandardFileManager(null, null, null);
		StringSourceJavaObject javaObj=new StringSourceJavaObject(className, source);
		CompilationTask task=compiler.getTask(null, fileManager, null, null, null, Arrays.asList(javaObj));
		//boolean result=ByteCodeComplier.compiler(source, className);
		boolean result=task.call();
		if(result){
			Class clazz=DynamicExpressDemo.class.getClassLoader().loadClass(className);
			Method method=clazz.getMethod(methodName);
			Object execResult=method.invoke(null, null);
			return (Double)execResult;
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(DynamicExpressDemo.calculate("2*3*50"));
	}
}
