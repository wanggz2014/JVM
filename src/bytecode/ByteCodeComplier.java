/**
 * wgz
 * bytecode
 * ByteCodeComplier.java
 * 
 * 2014-8-1-上午08:45:44
 *  2014wgz
 * 
 */
package bytecode;

import java.io.IOException;
import java.net.URI;
import java.security.SecureClassLoader;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject.Kind;

/**
 * 
 * ByteCodeComplier  进行JAVA源码的动态编译
 * 
 * wgz
 * wgz
 * 2014-8-1 上午08:45:44
 * 
 * @version 1.0.0
 * 
 */
public class ByteCodeComplier {
	
	public static void main(String[] args){
		String source="public class Main { public static void main(String[] args) {System.out.println(\"hello world\");}}";
		/*JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager filemanager=compiler.getStandardFileManager(null, null, null);	
		StringSourceJavaObject sourceObject=new StringSourceJavaObject("Main", source);
		CompilationTask task=compiler.getTask(null, filemanager, null, null, null, Arrays.asList(sourceObject));
		boolean result=task.call();
		if(result){
			System.out.println("编译成功");
		}*/
		boolean result=compiler(source, "Main");
	}
	
	public static boolean compiler(String source,String name){
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager=compiler.getStandardFileManager(null, null, null);
		StringSourceJavaObject javaObj=new StringSourceJavaObject(name, source);
		CompilationTask task=compiler.getTask(null, fileManager, null, null, null, Arrays.asList(javaObj));
		return task.call();
	}
}

class StringSourceJavaObject extends SimpleJavaFileObject{

	private String content;
	
	public StringSourceJavaObject(String name ,String content){
		super(URI.create("string:///"+name.replace('.', '/')+Kind.SOURCE.extension), Kind.SOURCE);
		this.content=content;
	}
	
	public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException{
		return this.content;
	}
	
}

