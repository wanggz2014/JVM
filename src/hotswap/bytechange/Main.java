/**
 * *********************** 版权声明 ***********************************
 *
 * 版权所有：wgz
 * ©CopyRight wgz03310126 2014   
 *  
 * *******************************************************************
*/

package hotswap.bytechange;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * TODO
 *
 * @author    wgz
 * @version   Ver 3.0
 * @since     Ver 3.0
 * @Date      2014-8-22
 *
 */
public class Main {

    /**
     * TODO
     *
     * @param args      
     * @throws IOException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @since  Ver 3.0
     */

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {

         execute();
         System.gc();
    }
    
    private static void execute() throws IOException, InstantiationException, IllegalAccessException{
        DemoExec orgi=new DemoExec();
        
        HotSwapClassLoader loader=new HotSwapClassLoader();
        
        InputStream in=Main.class.getResourceAsStream("DemoExec.class");
        
        byte[] classByte=new byte[in.available()];
        in.read(classByte);
        ClassModifier modifier=new ClassModifier(classByte);
        classByte=modifier.modifyUTF8Constant("hotswap/bytechange/Demo1Test", "hotswap/bytechange/DemoTest");
        
        loader.loadClass(classByte).newInstance();
    }

}

