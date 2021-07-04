package com.weiyi.Utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author : xieyj
 * @date : 2020/6/9 16:21
 * @desc :
 * @since : V1.1
 */
public class AESUtils {
    public static final String CHARSET = "UTF-8";

    public AESUtils() {
    }

    public static String ecodes(String content, String key) {
        if (content != null && content.length() >= 1) {
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
                random.setSeed(key.getBytes());
                kgen.init(128, random);
                SecretKey secretKey = kgen.generateKey();
                byte[] enCodeFormat = secretKey.getEncoded();
                SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                byte[] byteContent = content.getBytes("UTF-8");
                cipher.init(1, secretKeySpec);
                byte[] byteRresult = cipher.doFinal(byteContent);
                StringBuffer sb = new StringBuffer();

                for(int i = 0; i < byteRresult.length; ++i) {
                    String hex = Integer.toHexString(byteRresult[i] & 255);
                    if (hex.length() == 1) {
                        hex = '0' + hex;
                    }

                    sb.append(hex.toUpperCase());
                }

                return sb.toString();
            } catch (NoSuchAlgorithmException var13) {
                var13.printStackTrace();
            } catch (NoSuchPaddingException var14) {
                var14.printStackTrace();
            } catch (InvalidKeyException var15) {
                var15.printStackTrace();
            } catch (UnsupportedEncodingException var16) {
                var16.printStackTrace();
            } catch (IllegalBlockSizeException var17) {
                var17.printStackTrace();
            } catch (BadPaddingException var18) {
                var18.printStackTrace();
            }

            return null;
        } else {
            return null;
        }
    }

    public static String dcodes(String content, String key) {
        if (content != null && content.length() >= 1) {
            if (content.trim().length() < 19) {
                return content;
            } else {
                byte[] byteRresult = new byte[content.length() / 2];

                for(int i = 0; i < content.length() / 2; ++i) {
                    int high = Integer.parseInt(content.substring(i * 2, i * 2 + 1), 16);
                    int low = Integer.parseInt(content.substring(i * 2 + 1, i * 2 + 2), 16);
                    byteRresult[i] = (byte)(high * 16 + low);
                }

                try {
                    KeyGenerator kgen = KeyGenerator.getInstance("AES");
                    SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
                    random.setSeed(key.getBytes());
                    kgen.init(128, random);
                    SecretKey secretKey = kgen.generateKey();
                    byte[] enCodeFormat = secretKey.getEncoded();
                    SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
                    Cipher cipher = Cipher.getInstance("AES");
                    cipher.init(2, secretKeySpec);
                    byte[] result = cipher.doFinal(byteRresult);
                    return new String(result);
                } catch (NoSuchAlgorithmException var10) {
                    var10.printStackTrace();
                } catch (NoSuchPaddingException var11) {
                    var11.printStackTrace();
                } catch (InvalidKeyException var12) {
                    var12.printStackTrace();
                } catch (IllegalBlockSizeException var13) {
                    var13.printStackTrace();
                } catch (BadPaddingException var14) {
                    var14.printStackTrace();
                }

                return null;
            }
        } else {
            return null;
        }
    }

    public static String createRandomKey() {
        return (int)(Math.random() * 9.0D + 100000.0D) + "";
    }

}
