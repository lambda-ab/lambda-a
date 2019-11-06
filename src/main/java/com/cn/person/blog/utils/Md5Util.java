package com.cn.person.blog.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 触点管理平台http-header加密籿
 *
 * @date 2015-12-24
 */
public class Md5Util {


    /**
     * 根据编码进行md5加密
     *
     * @param s       需加密的字符串
     * @param charset 编码级
     * @return
     */
    public final static String MD5Encoder(String s, String charset) {
        try {
            byte[] btInput = s.getBytes(charset);
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return
                    sb.toString();
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * MD5 32为加寿 与CryptoJS.MD5(CryptoJS.enc.Hex)加密算法对应
     *
     * @param content
     * @return
     */
    public static String encode(String content) {
        return encode(content.getBytes());
    }

    /**
     * MD5 32为加寿 与CryptoJS.MD5(CryptoJS.enc.Hex)加密算法对应
     *
     * @param
     * @return
     */
    public static String encode(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(data);
            return getEncode32(digest);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * HmacMD5 加密与CryptoJS.HmacMD5(CryptoJS.enc.Hex)加密算法对应
     *
     * @param content 加密字符丿
     * @param salt    密盐
     * @return
     */
    public static String hmacEncode(String content, String salt) {
        return hmacDigest(content.getBytes(), salt.getBytes(), "HmacMD5");
    }

    /**
     * Hmac 加密
     *
     * @param content 加密字符丿
     * @param salt    密盐
     * @param algo    hmac类型 -默认HmacMD5
     * @return
     */
    public static String hmacEncode(String content, String salt, String algo) {
        return hmacDigest(content.getBytes(), salt.getBytes(), algo);
    }

    /**
     * 32位加寿
     *
     * @param digest
     * @return
     */
    private static String getEncode32(MessageDigest digest) {
        StringBuilder builder = new StringBuilder();
        for (byte b : digest.digest()) {
            builder.append(Integer.toHexString((b >> 4) & 0xf));
            builder.append(Integer.toHexString(b & 0xf));
        }
        return builder.toString();
    }

    /**
     * Hmac 加密
     *
     * @param data 加密字符丿
     * @param salt 密盐
     * @param algo hmac类型 -默认HmacMD5
     * @return
     */
    private static String hmacDigest(byte[] data, byte[] salt, String algo) {
        if (algo == null || "".equals(algo.trim())) {
            algo = "HmacMD5";
        }
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec(salt, algo);
            Mac mac = Mac.getInstance(algo);
            mac.init(key);

            byte[] bytes = mac.doFinal(data);

            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString();
        } catch (InvalidKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        }
        return digest;
    }

}
