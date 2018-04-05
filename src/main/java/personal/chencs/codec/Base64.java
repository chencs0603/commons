package personal.chencs.codec;

import javax.xml.bind.DatatypeConverter;

/**
 * Base64编解码
 * 利用jdk的工具类DatatypeConverter来实现
 * 64个字符：a-z、A-Z、+、/，26+26+1+1=64
 * 每三个byte数据为一组，转换成4个字符
 * 不足时补充一个或两个0x00，编码后字符串补充同样个数的=
 * 在URLBase64情况下，+、/分别有-、_替代，并把=去掉
 *
 * @author chencs603
 * @date: 2018/04/05
 */
public class Base64 {

    /**
     * Base64编码
     *
     * @param in byte数组
     * @return Base64字符串
     */
    public static String encode(byte[] in) {
        return DatatypeConverter.printBase64Binary(in);
    }

    /**
     * Base64解码
     *
     * @param base64 base64字符串
     * @return byte数组
     */
    public static byte[] decode(String base64) {
        // 防止补足字符=的个数多余2个时，因此需要整体去掉=，然后在加到4的倍数
        base64 = base64.replaceAll("=", "");
        // 标准的Base64字符串的长度是4的倍数，否则需要用‘=’补足
        while (base64.length()%4 != 0) {
            base64 = base64 + "=";
        }

        return DatatypeConverter.parseBase64Binary(base64);
    }

    /**
     * URLBase64编码
     *
     * @param in byte数组
     * @return URLBaes64字符串
     */
    public static String encodeURL(byte[] in) {
        String base64 = encode(in);

        return base64.replaceAll("\\+", "-").replaceAll("/", "_").replaceAll("=", "");
    }

    /**
     * URLBase64解码
     *
     * @param base64URL URLBaes64字符串
     * @return byte数组
     */
    public static byte[] decodeURL(String base64URL) {
        String base64 = base64URL.replaceAll("-", "+").replaceAll("_", "/");

        return decode(base64);
    }

}
