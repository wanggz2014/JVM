/**
 * *********************** 版权声明 ***********************************
 *
 * 版权所有：wgz
 * ©CopyRight wgz03310126 2014   
 *  
 * *******************************************************************
*/

package hotswap.bytechange;

/**
 * 类字节码修改类
 *
 * @author    wgz
 * @version   Ver 3.0
 * @since     Ver 3.0
 * @Date      2014-8-22
 *
 */
public class ClassModifier {

    /**Class文件 中常量池的起始偏移*/
    private  static final int CONSTANT_POOL_COUNT_INDEX=8;
    
    /**CONSTANT_UTF8_INFO 常量的tag标志*/
    private static final int CONSTANT_UTF8_INFO=1;
    
    /**常量池中11 种常量所占的长度，CONSTANTS_UTF8_INFO型常量除外，因为它不是定长的*/
    private static final int[] CONSTANT_ITEM_LENGTH={-1,-1,-1,5,5,9,9,3,3,5,5,5,5};
    
    private static final int u1=1;
    
    private static final int u2=2;
    
    private byte[] classByte;
    
    public ClassModifier(byte[] classByte){
        this.classByte=classByte;
    }
    
    /**
     * 
     * 将class 常量池中特定字面量进行替换
     *
     * @param oldStr
     * @param newStr
     * @return      
     * @since  Ver 3.0
     */
    public byte[] modifyUTF8Constant(String oldStr,String newStr){
        
        int constantsPoolSize=this.getConstantsPoolSize();
        
        int offset=CONSTANT_POOL_COUNT_INDEX+u2;
        
        for(int i=0;i<constantsPoolSize;i++){
            int tag=ByteUtils.bytes2Int(classByte, offset, u1);
            if(tag==CONSTANT_UTF8_INFO){
                
                int len=ByteUtils.bytes2Int(classByte, offset+u1, u2);
                offset+=u1+u2;
                String str=ByteUtils.bytes2String(classByte, offset, len);
                if(str.equals(oldStr)){
                    byte[] newStrBytes=ByteUtils.string2Bytes(newStr);
                    byte[] newStrLen=ByteUtils.int2Bytes(newStr.length(),u2);
                    classByte=ByteUtils.bytesReplace(classByte, offset-u2, u2, newStrLen);
                    classByte=ByteUtils.bytesReplace(classByte, offset, len, newStrBytes);
                    return classByte;
                }else{
                    offset+=len;
                }
                
            }else{
                offset+=CONSTANT_ITEM_LENGTH[tag];
            }
        }
        return classByte;
        
    }
    
    /**
     * 
     * 返回常量池个数
     *
     * @return      
     * @since  Ver 3.0
     */
    private int getConstantsPoolSize(){
        return ByteUtils.bytes2Int(this.classByte, CONSTANT_POOL_COUNT_INDEX, u2);
    }
    
}

