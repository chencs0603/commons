package personal.chencs.util;

import java.security.SecureRandom;

/**
 * byte数组工具类
 *
 * @author chencs603
 * @date: 2018/04/06
 */
public class BytesUtils {

    /**
     * int整数转成4字节byte数组（支持大小端两种模式）
     *
     * @param num int型整数
     * @param bigEndian true：大端模式，false：小端模式
     * @return byte数组
     */
    public static byte[] intToBytes(int num, boolean bigEndian) {
        byte[] result = new byte[0x04];

        if (bigEndian) {
            for (int i = 3; i >= 0; i--)
            {
                result[i] = (byte) num;
                num >>>= 8;
            }
        } else {
            for (int i = 0; i <= 3; i++)
            {
                result[i] = (byte) num;
                num >>>= 8;
            }
        }

        return result;
    }

    /**
     * 4字节byte数组转成int整数（支持大小端两种模式）
     *
     * @param bytes byte数组
     * @param bigEndian true：大端模式，false：小端模式
     * @return int型整数
     */
    public static int bytesToInt(byte[] bytes, boolean bigEndian) {
        // 验证byte数组的长度
        if (bytes.length != 0x04)
        {
            throw new IllegalArgumentException("invalid input length");
        }

        int result = 0;
        if (bigEndian) {
            //大端模式
            for (int i = 0; i < 0x04; i++)
            {
                result |= (bytes[i] & 0xff) << (8 * (bytes.length - 1 - i));
            }

        }else{
            ////小端模式
            for (int i = 0; i < 0x04; i++)
            {
                result |= (bytes[i] & 0xff) << (8 * i);
            }
        }

        return result;
    }

    /**
     * long整数转成8字节byte数组（支持大小端两种模式）
     *
     * @param num int型整数
     * @param bigEndian true：大端模式，false：小端模式
     * @return byte数组
     */
    public static byte[] longToBytes(long num, boolean bigEndian) {
        byte[] result = new byte[0x08];

        if (bigEndian) {
            for (int i = 7; i >= 0; i--)
            {
                result[i] = (byte) num;
                num >>>= 8;
            }
        } else {
            for (int i = 0; i <= 7; i++)
            {
                result[i] = (byte) num;
                num >>>= 8;
            }
        }

        return result;
    }

    /**
     * 8字节byte数组转成long整数（支持大小端两种模式）
     *
     * @param bytes byte数组
     * @param bigEndian true：大端模式，false：小端模式
     * @return long型整数
     */
    public static long bytesToLong(byte[] bytes, boolean bigEndian) {
        // 验证byte数组的长度
        if (bytes.length != 0x08)
        {
            throw new IllegalArgumentException("invalid input length");
        }

        long result = 0L;
        if (bigEndian) {
            // 大端模式
            for (int i = 0; i < 0x08; i++)
            {
                result |= (long)(bytes[i] & 0xff) << (8 * (bytes.length - 1 - i));
            }

        }else{
            // 小端模式
            for (int i = 0; i < 0x08; i++)
            {
                result |= (long)(bytes[i] & 0xff) << (8 * i);
            }
        }

        return result;
    }

    /**
     * byte数组反转
     *
     * @param bytes byte数组
     * @return byte数组
     */
    public static byte[] reverse(byte[] bytes) {
        byte[] result = new byte[bytes.length];

        for (int i = 0; i < bytes.length; i++) {
            result[i] = bytes[bytes.length - 1 - i];
        }

        return result;
    }

    /**
     * 连接两个byte数组
     *
     * @param bytes1 byte数组
     * @param bytes2 byte数组
     * @return byte数组
     */
    public static byte[] concat(byte[] bytes1, byte[] bytes2) {
        byte[] result = new byte[bytes1.length + bytes2.length];

        System.arraycopy(bytes1, 0, result, 0, bytes1.length);
        System.arraycopy(bytes2, 0, result, bytes1.length, bytes2.length);

        return result;
    }

    /**
     * 获取byte数组的子数组
     *
     * @param bytes byte数组
     * @param start 起始索引
     * @param end 结束索引
     * @return byte数组
     */
    public static byte[] subBytes(byte[] bytes, int start, int end) {
        byte[] result = new byte[end - start];

        System.arraycopy(bytes, start, result, 0, end - start);

        return result;
    }

    /**
     * 两个byte数组异或
     *
     * @param bytes1
     * @param bytes2
     * @return
     */
    public static byte[] xor(byte[] bytes1, byte[] bytes2) {
        if (bytes1.length != bytes2.length) {
            throw new IllegalArgumentException("the length of bytes1 is not equal to the bytes2's");
        }

        int length = bytes1.length;
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            result[i] = (byte) (bytes1[i]^bytes2[i]);
        }

        return result;
    }

    /**
     * 产生随机byte数组
     *
     * @param length 长度
     * @return byte数组
     */
    public static byte[] random(int length) {
        SecureRandom random = new SecureRandom();

        byte[] result = new byte[length];
        random.nextBytes(result);

        return result;
    }

}
