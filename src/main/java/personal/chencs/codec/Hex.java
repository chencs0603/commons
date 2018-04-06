package personal.chencs.codec;

/**
 * 16进制字符串编解码
 *
 * @author chencs603
 * @date: 2018/04/06
 */
public class Hex {

    /**
     * byte数组转16进制字符串(大写)
     *
     * @param in byte数组
     * @return 16进制字符串
     */
    public static String encode(byte[] in) {
        return encode(in, true);
    }

    /**
     * byte数组转16进制字符串
     *
     * @param in  byte数组
     * @param toUpperCase true表示大写字符串，false表示小写字符串
     * @return 16进制字符串
     */
    public static String encode(byte[] in, boolean toUpperCase) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < in.length; i++) {
            buffer = buffer.append(encode(in[i]));
        }
        String hex = buffer.toString();
        if (toUpperCase) {
            return hex.toUpperCase();
        }

        return hex;
    }

    /**
     * byte转16进制字符串
     *
     * @param in byte整数
     * @return 16进制字符串（长度为2）
     */
    private static String encode(byte in) {
        String hex = Integer.toHexString(in & 0xFF);
        if (1 == hex.length()) {
            hex = "0" + hex;
        }
        return hex;
    }

    /**
     * 16进制字符串解码
     *
     * @param hex 16进制字符串
     * @return byte数组
     */
    public static byte[] decode(String hex) {
        if ((hex.length() & 0x01) != 0) {
            throw new IllegalArgumentException("odd number of characters.");
        }

        hex = hex.toUpperCase();
        int length = hex.length() >>> 1;
        char[] hexChars = hex.toCharArray();
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++)
        {
            int pos = i * 2;
            bytes[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return bytes;
    }

    /**
     * char转byte
     * @param c
     * @return
     */
    private static byte charToByte(char c)
    {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

}
