/**
 * wgz
 * bytecode
 * DynaCompTest.java
 * 
 * 2014-8-1-下午12:57:25
 *  2014wgz
 * 
 */
package bytecode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.security.SecureClassLoader;
import java.util.ArrayList;
import java.util.List;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaFileObject.Kind;

/**
 * 
 * DynaCompTest
 * 
 * wgz
 * wgz
 * 2014-8-1 下午12:57:25
 * 
 * @version 1.0.0
 * 
 */
public class DynaCompTest {
	
	public static final String TEST_INFO="info";
	
    public static void main(String[] args) throws Exception {
        // Full name of the class that will be compiled.
        // If class should be in some package,
        // fullName should contain it too
        // (ex. "testpackage.DynaClass")
        String fullName = "DynaClass";

        // Here we specify the source code of the class to be compiled
        StringBuilder src = new StringBuilder();
        src.append("import bytecode.DynaCompTest; ");
        src.append("public class DynaClass {\n");
        src.append("    public String toString() {\n");
        src.append("        return \"Hello, I am \" + DynaCompTest.TEST_INFO +");
        src.append("this.getClass().getSimpleName();\n");
        src.append("    }\n");
        src.append("}\n");

        System.out.println(src);        

        // We get an instance of JavaCompiler. Then
        // we create a file manager
        // (our custom implementation of it)
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        JavaFileManager fileManager = new
            ClassFileManager(compiler
                .getStandardFileManager(null, null, null));

        // Dynamic compiling requires specifying
        // a list of "files" to compile. In our case
        // this is a list containing one "file" which is in our case
        // our own implementation (see details below)
        List<JavaFileObject> jfiles = new ArrayList<JavaFileObject>();
        jfiles.add(new CharSequenceJavaFileObject(fullName, src));

        // We specify a task to the compiler. Compiler should use our file
        // manager and our list of "files".
        // Then we run the compilation with call()
        compiler.getTask(null, fileManager, null, null,
            null, jfiles).call();

        // Creating an instance of our compiled class and
        // running its toString() method
        Object instance = fileManager.getClassLoader(null)
            .loadClass(fullName).newInstance();
        System.out.println(instance);
    }
}


class CharSequenceJavaFileObject extends SimpleJavaFileObject {

    /**
    * CharSequence representing the source code to be compiled
    */
    private CharSequence content;

    /**
    * This constructor will store the source code in the
    * internal "content" variable and register it as a
    * source code, using a URI containing the class full name
    *
    * @param className
    *            name of the public class in the source code
    * @param content
    *            source code to compile
    */
    public CharSequenceJavaFileObject(String className,
        CharSequence content) {
        super(URI.create("string:///" + className.replace('.', '/')
            + Kind.SOURCE.extension), Kind.SOURCE);
        this.content = content;
    }

    /**
    * Answers the CharSequence to be compiled. It will give
    * the source code stored in variable "content"
    */
    @Override
    public CharSequence getCharContent(
        boolean ignoreEncodingErrors) {
        return content;
    }
}


class ClassFileManager extends
	ForwardingJavaFileManager {
	/**
	* Instance of JavaClassObject that will store the
	* compiled bytecode of our class
	*/
	private JavaClassObject jclassObject;
	
	/**
	* Will initialize the manager with the specified
	* standard java file manager
	*
	* @param standardManger
	*/
	public ClassFileManager(StandardJavaFileManager
	standardManager) {
		super(standardManager);
	}
	
	/**
	* Will be used by us to get the class loader for our
	* compiled class. It creates an anonymous class
	* extending the SecureClassLoader which uses the
	* byte code created by the compiler and stored in
	* the JavaClassObject, and returns the Class for it
	*/
	@Override
	public ClassLoader getClassLoader(Location location) {
	return new SecureClassLoader() {
	    @Override
	    protected Class<?> findClass(String name)
	        throws ClassNotFoundException {
	        byte[] b = jclassObject.getBytes();
	        return super.defineClass(name, jclassObject
	            .getBytes(), 0, b.length);
	    }
	};
	}
	
	/**
	* Gives the compiler an instance of the JavaClassObject
	* so that the compiler can write the byte code into it.
	*/
	@Override
	public JavaFileObject getJavaFileForOutput(Location location,
	String className, Kind kind, FileObject sibling)
	    throws IOException {
	    jclassObject = new JavaClassObject(className, kind);
	    return jclassObject;
	}
}




class JavaClassObject extends SimpleJavaFileObject {

    /**
    * Byte code created by the compiler will be stored in this
    * ByteArrayOutputStream so that we can later get the
    * byte array out of it
    * and put it in the memory as an instance of our class.
    */
    protected final ByteArrayOutputStream bos =
        new ByteArrayOutputStream();

    /**
    * Registers the compiled class object under URI
    * containing the class full name
    *
    * @param name
    *            Full name of the compiled class
    * @param kind
    *            Kind of the data. It will be CLASS in our case
    */
    public JavaClassObject(String name, Kind kind) {
        super(URI.create("string:///" + name.replace('.', '/')
            + kind.extension), kind);
    }

    /**
    * Will be used by our file manager to get the byte code that
    * can be put into memory to instantiate our class
    *
    * @return compiled byte code
    */
    public byte[] getBytes() {
        return bos.toByteArray();
    }

    /**
    * Will provide the compiler with an output stream that leads
    * to our byte array. This way the compiler will write everything
    * into the byte array that we will instantiate later
    */
    @Override
    public OutputStream openOutputStream() throws IOException {
        return bos;
    }
}
