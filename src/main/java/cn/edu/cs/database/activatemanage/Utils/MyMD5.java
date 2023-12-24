package cn.edu.cs.database.activatemanage.Utils;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class MyMD5 {
    public String getMD5(String str) throws Exception {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] digest = md.digest();
            // 将字节数组转换为十六进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            String encryptedString = sb.toString();
            System.out.println("MD5 Encrypted String: " + encryptedString);
            return encryptedString;
        } catch (NoSuchAlgorithmException e) {
            System.err.println("MD5加密错误！");
            throw e;
        }

    }
}
