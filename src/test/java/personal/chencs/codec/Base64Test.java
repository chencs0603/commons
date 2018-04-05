package personal.chencs.codec;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Base64Test {

    @Test
    public void encode() {
        byte[] in = {(byte)0x20, (byte)0x34, (byte)0x53};
        Assert.assertTrue(Base64.encode(in).equals(org.apache.commons.codec.binary.Base64.encodeBase64String(in)));
    }

    @Test
    public void decode() {
        String base64 = "YWJjZA==";
        Assert.assertTrue(Arrays.equals(Base64.decode(base64), org.apache.commons.codec.binary.Base64.decodeBase64(base64)));
    }

    @Test
    public void encodeURL() {
        byte[] in = {(byte)0x77, (byte)0xe7, (byte)0xb8};
        Assert.assertTrue(Base64.encodeURL(in).equals(org.apache.commons.codec.binary.Base64.encodeBase64URLSafeString(in)));
    }

    @Test
    public void decodeURL() {
        String base64URL = "d-e4";
        Assert.assertTrue(Arrays.equals(Base64.decodeURL(base64URL), org.apache.commons.codec.binary.Base64.decodeBase64(base64URL)));
    }

}