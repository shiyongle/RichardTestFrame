package com.weiyi;
import com.alibaba.fastjson.JSONObject;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
/**
 * @Author: Richered
 * @Date: 2020/08/26 17:42
 * @Description:  友邦乳腺癌创建用户以及链接，注意下方唯一参数
 **/
public class CreateYouBangUser {
        /**
         * 加密
         *
         * @param content  需要加密的内容
         * @param password 加密密码
         * @return
         */
        public static byte[] encrypt(String content, String password) {
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
                secureRandom.setSeed(password.getBytes());
                kgen.init(128, secureRandom);
                SecretKey secretKey = kgen.generateKey();
                byte[] enCodeFormat = secretKey.getEncoded();
                SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
                Cipher cipher = Cipher.getInstance("AES");// 创建密码器
                byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
                cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
                return cipher.doFinal(byteContent); // 加密
            } catch (Exception e) {
                System.out.println("aes256 加密失败" + e);
            }
            return null;
        }


        /**
         * 解密
         *
         * @param content  待解密内容
         * @param password 解密密钥
         * @return
         */
        public static byte[] decrypt(byte[] content, String password) {
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                //防止linux下 随机生成key
                SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
                secureRandom.setSeed(password.getBytes());
                kgen.init(128, secureRandom);
                SecretKey secretKey = kgen.generateKey();
                byte[] enCodeFormat = secretKey.getEncoded();
                SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
                // 创建密码器
                Cipher cipher = Cipher.getInstance("AES");
                // 初始化
                cipher.init(Cipher.DECRYPT_MODE, key);
                return cipher.doFinal(content);
            } catch (Exception e) {
                System.out.println("aes256 解密失败," + e);
            }
            return null;
        }


        /**
         * 将二进制转换成16进制
         *
         * @param buf
         * @return
         */
        public static String parseByte2HexStr(byte buf[]) {
            StringBuilder sb = new StringBuilder();
            for (byte aBuf : buf) {
                String hex = Integer.toHexString(aBuf & 0xFF);
                if (hex.length() == 1) {
                    hex = '0' + hex;
                }
                sb.append(hex.toUpperCase());
            }
            return sb.toString();
        }

        /**
         * 将16进制转换为二进制
         *
         * @param hexStr
         * @return
         */
        public static byte[] parseHexStr2Byte(String hexStr) {
            if (hexStr.length() < 1)
                return null;
            byte[] result = new byte[hexStr.length() / 2];
            for (int i = 0; i < hexStr.length() / 2; i++) {
                int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
                int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
                result[i] = (byte) (high * 16 + low);
            }
            return result;
        }

        public static void main(String[] args) throws Exception {

            String password = "ZAinz^8SFb6FNj9bCQ7FxMnQc";
            //加密
            Map<String, String> map = new HashMap<>();
            map.put("ext_user_id", "youbang_test23345013"); //相当于user_id，不一定对应上，唯一
//        map.put("mobile", "18758896832");
            map.put("mobile", "13216101995");
//        map.put("target", "/eco/ym");
            map.put("idcard", "542522199008310032"); //身份证
            map.put("name", "石永乐微医测试");
            map.put("open_id", "110101199109077417");
            map.put("plan_code", "WBCN"); //根据plan_code跳转
            map.put("effective_date","2019-05-25");// 保单生效日期，往前推3个月
            map.put("policy_number","9814977TGF");// 保单号，唯一
            String ori = JSONObject.toJSONString(map);

            System.out.println("加密前：" + ori);
            byte[] encryptResult = encrypt(ori, password);
            String encryptResultStr = parseByte2HexStr(encryptResult);
            System.out.println("加密后：" + encryptResultStr);

            String once = "12345678";
            String clientKey = "cXbCY21v1rG0C60Fn4dsjmwuelwob3fl49JmtCE4t6hBlzA00A4UZzpMIcqGulh9";

            System.out.println(clientKey);
            long timestamp = System.currentTimeMillis();
            String data = encryptResultStr + timestamp + once + clientKey;
            String sign = Sha256Utils.getSHA256(data);
            //测试地址（预发记得改url）
            // String url = "https://youbanggx.wy.guahao-test.com/partners/entrance?token=" + URLEncoder.encode(encryptResultStr, "utf-8")
            String url = "https://youbanggx.wy.guahao.com/partners/entrance?token=" + URLEncoder.encode(encryptResultStr, "utf-8")
                    + "&timestamp=" + timestamp + "&nonce=12345678&signature=" + sign;
            System.out.println(url);
            //解密nonce=xxx&signature=XXX

            String token = "C19D07000DB4D0B80188D96C420D57359F88AF9065B941F60785B50981473511D3324E9E2705E24003B19490360CB078783DB398450D11BB71BE2CF93EFB48BECE7E37AFCA8C652379E3EBE16339AC8EF9E0BBA9E588A679293D9B18D9D7711CD090C5F735DFDCF20DD3DFD69DFBC9C8979F14041D640E62A9B50A04A22B6FBDCF78C534A6C307BB7A6DABE25677AEA7D54A32041B06275B8A84E0D74F7A964EC1033041BA147656E0FE919F52C64A6C4EF25830D3412C96233AD72B6E9B650F56A7B84BBCEDF0A638C85DE2EEAE58FC6F26BEF740F5029AD52CF129C671A7FACAB91F61331DCEC304E790F2FF29833C121B681D19BFEA2E6850CADC34A0B6612CBE9D49F18EB22DE4AADF10BC5DFAC42571B07767C9DC2D3199483000D2599B";
            byte[] decryptResult = decrypt(parseHexStr2Byte(token), "ZCinz^8SFb6ENj9bDN7BxMnQb");
            System.out.println("解密后：" + new String(decryptResult));

        }
        // 保单生效日期 effective_date
        // 保单号 policy_number

        //18258140861
//     public static void main(String[] args) throws Exception {
//
//         String password = "4f76a3d7551742d2864bd6ecfab80af4";
//         //加密
//         Map<String, String> map = new HashMap<>();
//         map.put("ext_user_id", "ymtest123123123");
//         map.put("mobile", "18258140861");
//         map.put("target", "/eco/ym");
//         map.put("idcard", "110101199009077417");
//         map.put("name", "河壮南省");
//         map.put("open_id", "110101199009077417");
//         map.put("plan_code", "WBCN");
//         String ori = JSONObject.toJSONString(map);
//
//         System.out.println("加密前：" + ori);
//         byte[] encryptResult = encrypt(ori, password);
//         String encryptResultStr = parseByte2HexStr(encryptResult);
//         System.out.println("加密后：" + encryptResultStr);
//
//         String once = "12345678";
//         String clientKey = "ddd7d8d4f2754a719d0303d3d12b526641e12204b26a4b90a1ee8bf275a95a78";
//
//         System.out.println(clientKey);
//         long timestamp = System.currentTimeMillis();
//         String data = encryptResultStr + timestamp + once + clientKey;
//         String sign = Sha256Utils.getSHA256(data);
//
//         String url = "https://ym.wy.guahao.com/partners/entrance?token=" + URLEncoder.encode(encryptResultStr, "utf-8")
//                 + "&timestamp=" + timestamp + "&nonce=12345678&signature=" + sign;
//         System.out.println(url);
//         //解密nonce=xxx&signature=XXX
//
//         String token = "499BDCA1A54D23C5A1B0C7EB7F0F722F462DDDD0E9CF662757C70AAEBADD828B50CF33188AE10C0E642E79EB26F78E831E470759497E750356194F8A74DE39E6526FFE8BFB23A781C23C8CDF3FE6921C4461D95ABFA5F3C1201B6D121DBD1B9D26BC57A38F0C6AAF1D1B065EB04DA70EEB379E682633D72AE126B296BFB649C7AD62B3C5EF7B3213B4891F84D8036FE3C67E8D8662DAA522C03D76A8A84D216E68DDEB217ABD77929C04B7E7BA9D0CFB63EA02BCF69B364BE9AE302537B1824A64F8198DCC1C1C95217A456BF2D1F20C2BBFCC9E45143F27D0BB5C3D5A03673C";
//         byte[] decryptResult = decrypt(parseHexStr2Byte(token), "ZAinz^8SFb6FNj9bCQ7FxMnQc");
//         System.out.println("解密后：" + new String(decryptResult));
//
//     }
     }

