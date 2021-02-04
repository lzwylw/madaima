package com.madaima.util;

import java.util.Random;
import java.util.UUID;

/**
 *  @author: JiaBin.Wang
 *  @date: 2020/8/14 17:47
 *  @description: UUID
 */
public class UUIDUtil {
    /**
     * 获取UUID
     * @return UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 文件名
     * @return 文件名
     */
    public static String randomFileName() {
        Random random = new Random();
        int temp = random.nextInt(50000) + 10000;
        return System.currentTimeMillis() + "" + temp;
    }

    /**
     * 生成纯数字的唯一ID
     * @param userId 用户ID
     * @return id
     */
    public static String getId(String userId) {
        Random random = new Random();
        return userId + System.currentTimeMillis() + (random.nextInt(50000) + 10000) ;
    }

    public static void main(String[] args) {
        for (int i =1 ; i< 10000 ; i ++) {
            System.out.println(getId(i+""));
        }
    }
}
