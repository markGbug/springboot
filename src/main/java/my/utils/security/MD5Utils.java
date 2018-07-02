package my.utils.security;

import java.security.NoSuchAlgorithmException;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc MD5加密
 * @date 2018/1/19
 */
public class MD5Utils {

    /**
     * 编码格式
     */
    private static String encoding = "utf-8";

    /**
     * MD5加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String getMD5(String data) throws Exception {
        byte[] bytes = data.getBytes(encoding);
        return getMD5(bytes);
    }

    /**
     * MD5加密
     *
     * @param src
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getMD5(byte[] src) throws NoSuchAlgorithmException {
        StringBuffer sb = new StringBuffer();

        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        md.update(src);
        for (byte b : md.digest()) {
            sb.append(Integer.toString(b >>> 4 & 0xF, 16)).append(Integer.toString(b & 0xF, 16));
        }
        return sb.toString();
    }

    public static String encrypt(String data) {
        try {
            byte[] bytes = data.getBytes(encoding);
            return getMD5(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
