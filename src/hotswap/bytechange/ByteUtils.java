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
 * 关于字节码操作工具类
 *
 * @author    wgz
 * @version   Ver 3.0
 * @since     Ver 3.0
 * @Date      2014-8-22
 *
 */
public class ByteUtils {

    public static int bytes2Int(byte[] bytes,int start,int len){
        int sum=0;
        int end=start+len;
        for(int i=start;i<end;i++){
            int n=((int)bytes[i])&0xff;
            n<<=(--len)*8;
            sum+=n;
        }
        return sum;
    }
    
    public static byte[] int2Bytes(int value,int len){
        byte[] b=new byte[len];
        for(int i=0; i< len ;i++){
            b[len-i-1]=(byte)((value>>8*i)&0xff);
            
        }
        return b;
    }
    
    public static String bytes2String(byte[] bytes,int start, int len){
        return new String(bytes,start,len);
    }
    
    public static byte[] string2Bytes(String str){
        
        return str.getBytes();
    }
    
    public static byte[] bytesReplace(byte[] originalBytes,int offset,int len,byte[] replaceBytes){
        byte[] newBytes=new byte[originalBytes.length+(replaceBytes.length-len)];
        System.arraycopy(originalBytes, 0, newBytes, 0, offset);
        System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
        System.arraycopy(originalBytes, offset+len, newBytes, offset+replaceBytes.length, originalBytes.length-offset-len);
        return newBytes;
    }
    
}

