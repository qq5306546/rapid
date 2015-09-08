package com.rapid.core.utils.encrypt;

import java.security.MessageDigest;

/**
 * SHA加密工具类
 * @author wubei
 *
 */
public class SHA1Util {
	
    /*** 
     * SHA加密 生成40位SHA码
     * @param 
     * 		待加密字符串
     * @return 
     * 		返回40位SHA码
     */
    public static String encode(String inStr) {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA-1");
            byte[] byteArray = inStr.getBytes("UTF-8");
            byte[] md5Bytes = sha.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) { 
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception e) {
        	e.printStackTrace();
            return "";
        }
    }

}