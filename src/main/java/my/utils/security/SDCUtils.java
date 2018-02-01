package my.utils.security;

/**
 * @author zhangbj
 * @version 1.0
 * @Type Self Define Crypt Utils
 * @Desc 自定义加密算法(目前仅限于CookieName加密)
 * @date 2018/1/26
 */
public class SDCUtils {

    public static String encrypt(String data){
        byte[] bytes = data.getBytes();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i<bytes.length;i++){
            if (i%2==1){
                bytes[i] += 32;
            }
            buffer.append(bytes[i] >> 4 );
        }
        return buffer.toString().replaceAll("-","");
    }
}
