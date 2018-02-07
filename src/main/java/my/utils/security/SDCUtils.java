package my.utils.security;

/**
 * @author zhangbj
 * @version 1.0
 * @Type Self Define Crypt Utils
 * @Desc 自定义加密算法(目前仅限于CookieName加密)
 * @date 2018/1/26
 */
public class SDCUtils {

    /**
     * 加密（不可解）
     * @param data
     * @return
     */
    public static String encrypt(String data) {
        byte[] bytes = data.getBytes();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            if (i % 2 == 1) {
                bytes[i] += 32;
            }
            buffer.append(bytes[i] >> 4);
        }
        return buffer.toString().replaceAll("-", "");
    }

    /**
     * 加密（可解）
     * @param data
     * @param clazz
     * @return
     */
    private static String crypt(String data, Class clazz,boolean type) {
        if (data == null || data.length() == 0 || clazz == null) {
            return null;
        }
        String clazzName = clazz.getName();
        String[] dataArray = stringToUnicode(data);
        StringBuffer buffer = new StringBuffer();
        if (data.length() > clazzName.length()) {
            StringBuffer clazzBuffer = new StringBuffer();
            for (int i = 0; i <= data.length() / clazzName.length(); i++) {
                clazzBuffer.append(clazzName).append(i);
            }
            clazzName = buffer.substring(0,dataArray.length);
        }
        String[] clazzArray = stringToUnicode(clazzName);
        return type?plus(dataArray,clazzArray):sub(dataArray,clazzArray);
    }

    /**
     * 加密
     * @param data
     * @param clazz
     * @return
     */
    public static String encrypt(String data, Class clazz){
        return crypt(data,clazz,true);
    }

    /**
     * 解密
     * @param data
     * @param clazz
     * @return
     */
    public static String decrypt(String data, Class clazz){
        return crypt(data,clazz,false);
    }

    /**
     * 字符串转换unicode
     *
     * @param string
     * @return
     */
    private static String[] stringToUnicode(String string) {
        String[] unicode = new String[string.length()];
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode[i] = Integer.toHexString(c);
        }
        return unicode;
    }

    /**
     * unicode 转字符串
     *
     * @param unicode
     * @return
     */
    private static String unicodeToString(String[] unicode) {
        StringBuffer string = new StringBuffer();
        for (int i = 0; i < unicode.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(unicode[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }

    /**
     * unicode相加
     * @param unicode
     * @param key
     * @return
     */
    private static String plus(String[] unicode,String[] key){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0 ;i<unicode.length;i++){
            int data = Integer.parseInt(unicode[i], 16)+Integer.parseInt(key[i], 16);
            buffer.append((char)data);
        }
        return buffer.toString();
    }

    /**
     * unicode相减
     * @param unicode
     * @param key
     * @return
     */
    private static String sub(String[] unicode,String[] key){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0 ;i<unicode.length;i++){
            int data = Integer.parseInt(unicode[i], 16)- Integer.parseInt(key[i], 16);
            buffer.append((char)data);
        }
        return buffer.toString();
    }
}
