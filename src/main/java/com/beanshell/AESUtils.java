package com.beanshell;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;


/**
 * 对称加密
 *
 * @author wangt
 * @date 2022/4/17 15:20
 */
public class AESUtils {
    private static final String CHARSET_NAME = "UTF-8";

    private static final String AES_NAME = "AES";
    /**
     * 加密模式
     */
    public static final String ALGORITHM = "AES/CBC/PKCS7Padding";

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static String encrypt(String content, String key) {
        byte[] result = null;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(CHARSET_NAME), AES_NAME);
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(key.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, paramSpec);
            result = cipher.doFinal(content.getBytes(CHARSET_NAME));
            return bytesToHexString(result).toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY;
    }

    public static String decrypt(String content, String key) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(CHARSET_NAME), AES_NAME);
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(key.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);
            return new String(cipher.doFinal(hexStringToByteArray(content.replace("\"", ""))), CHARSET_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY;
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    public static boolean validateString(String str) {
        // 使用正则表达式匹配只包含数字和字母的字符串
        String pattern = "^[a-zA-Z0-9\"]+$";
        return str.matches(pattern);
    }

    public static String encodeURI(String uri) {
        try {
            String encodedURI = URLEncoder.encode(uri, "UTF-8");
            return encodedURI;
        } catch (UnsupportedEncodingException e) {
            // 处理编码异常
            e.printStackTrace();
            return uri; // 返回原始 URI
        }
    }

    private static int extractNumber(String str) {
        StringBuilder numberBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                numberBuilder.append(c);
            }
        }
        return Integer.parseInt(numberBuilder.toString());
    }


    public static void main(String[] args) {

        System.out.println(AESUtils.encrypt("        \"{\\\"uid\\\":\\\"18c04301-d2d7-4cb3-b6c6-5cb37d5c2d5c\\\"}\"\n","xxxxxx"));
        System.out.println(AESUtils.decrypt("efcd797b56387c1f4a923794e264e4a2c1f9a390b48d75797b503a8640d5ac5aa805cb6cad9461273ac074fe01ae5be300daf53b68cd7ef7a484518600f5776c4ff2b8e9a23763488c54625a2acbb17ad70802954aa5bf59b4810fff80080cced08ada0af22e82d18a64ac6479a9de82a5ff87ae75c22073e8a7fd8ea7e0ca09be2019d233ce46b0f67024b9cfe9afae8d9e9143e08b8cd838476b7538bf0994","xxxxxx"));
    }


    /**
     * 预注册开户数据
     * @param args
     */
//    public static void main(String[] args) {
//        String csvFilePath = "output.csv";
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
//            for (int i = 0; i <= 100000; i++) {
//                //开户json
//                String originalJson = "{\"content\":\"{\\\"realName\\\":\\\"c0\\\",\\\"userType\\\":\\\"STUDENT_ID_USER\\\",\\\"studentId\\\":\\\"c0\\\",\\\"organization\\\":\\\"10000\\\",\\\"password\\\":\\\"ZTllM2U5NTc=\\\"}\",\"org\":\"10000\"}";
//                JSONObject outerJson = JSONObject.parseObject(originalJson);
//                String contentJsonStr = outerJson.getString("content");
//                JSONObject contentJson = JSONObject.parseObject(contentJsonStr);
//
//                // 获取当前的 realName 和 studentId 的值
//                String currentRealName = contentJson.getString("realName");
//                String currentStudentId = contentJson.getString("studentId");
//
//                // 提取数字部分并自增
//                int numberPart = extractNumber(currentRealName);
//                numberPart = i;
//                String newRealName = "c" + numberPart;
//
//                numberPart = i;
//                String newStudentId = "c" + numberPart;
//
//                // 更新 JSON 中的值
//                contentJson.put("realName", newRealName);
//                contentJson.put("studentId", newStudentId);
//
//                // 将更新后的内容 JSON 放回外层 JSON 的 content 字段
//                outerJson.put("content", contentJson.toJSONString());
//
//                // 进行加密
//                String encryptedJson = AESUtils.encrypt(outerJson.toJSONString(), "1234567890000000");
//
//                // 将加密后的结果写入文件
//                writer.write(encryptedJson);
//                writer.newLine();
//            }
//            System.out.println("数据已成功写入文件。");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}

