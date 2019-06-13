package com.qianfeng.merchant.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AppTools {

    public static String formatMD5String(String param){
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            String md5String = formatMD5String(param.getBytes());
            return md5String;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return String.valueOf(param.hashCode());
    }


    public static String formatMD5String(byte[] param){
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //加密
            byte[] miwen = digest.digest(param);
            StringBuilder builder = new StringBuilder();
            for(byte b:miwen) {
                String hex = Integer.toHexString(b & 0xFF);

                if (hex.length()==1){
                    hex = 0+hex;
                }
                builder.append(hex);
                System.out.println(hex);
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return String.valueOf(param.hashCode());
    }
}
