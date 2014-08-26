/**
 * *********************** 版权声明 ***********************************
 *
 * 版权所有：wgz
 * ©CopyRight wgz03310126 2014   
 *  
 * *******************************************************************
*/

package hotswap.bytechange;

import java.util.ArrayList;
import java.util.List;

/**
 * 热替换类加载器
 *
 * @author    wgz
 * @version   Ver 3.0
 * @since     Ver 3.0
 * @Date      2014-8-22
 *
 */
public class HotSwapClassLoader extends ClassLoader {

    public HotSwapClassLoader(){
        super(HotSwapClassLoader.class.getClassLoader());
    }
    
    public Class<?> loadClass(byte[] bytes){
        
        List<String> strList=new ArrayList<String>();
        
        List list=strList;
        
        list.add("ddff");
        
        
        return defineClass(null, bytes, 0, bytes.length);
        
        
        
    }
}

