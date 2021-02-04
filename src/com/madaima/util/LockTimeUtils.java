package com.madaima.util;

/**
 * @author JiaBin.Wang
 * @className LockTimeutils
 * @date 2020/12/14 11:48 上午
 * @deacription 锁的时间
 **/
public class LockTimeUtils {

    /**
     * 锁
     * @param start 时间戳
     * @return false
     */
    public static boolean lock(Long start) {
        try {
            Thread.sleep(100);
            long end = System.currentTimeMillis();
            long runTime = end - start;
            if (runTime > 4000) {
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
