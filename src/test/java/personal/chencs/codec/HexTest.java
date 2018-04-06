package personal.chencs.codec;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HexTest {

    @Test
    public void encode() {
        byte[] in = {(byte)0x05, (byte)0x43, (byte)0x52, (byte)0x0F};
        Assert.assertTrue(Hex.encode(in).equals(org.apache.commons.codec.binary.Hex.encodeHexString(in).toUpperCase()));
    }

    @Test
    public void decode() throws Exception {
        String hex = "0543520f";
        Assert.assertTrue(Arrays.equals(Hex.decode(hex), org.apache.commons.codec.binary.Hex.decodeHex(hex.toCharArray())));
    }

}
