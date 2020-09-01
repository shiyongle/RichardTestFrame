package com.weiyi;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
/**
 * @Author: Richered
 * @Date: 2020/08/26 17:44
 * @Description:
 **/
public class Sha256Utils {
        /**
         * 利用java原生的类实现SHA256加密
         *
         * @param str 加密后的报文
         * @return
         */
        public static String getSHA256(String str) {
            MessageDigest messageDigest;
            String encodestr = "";
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
                encodestr = byte2Hex(messageDigest.digest());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return encodestr;
        }

        /**
         * 将byte转为16进制
         *
         * @param bytes
         * @return
         */
        private static String byte2Hex(byte[] bytes) {
            StringBuilder stringBuffer = new StringBuilder();
            String temp = null;
            for (byte aByte : bytes) {
                temp = Integer.toHexString(aByte & 0xFF);
                if (temp.length() == 1) {
                    // 1得到一位的进行补0操作
                    stringBuffer.append("0");
                }
                stringBuffer.append(temp);
            }
            return stringBuffer.toString();
        }

        public static void main(String[] args) {
            System.out.println("加密后：" + getSHA256("234234234324"));
        }


}
