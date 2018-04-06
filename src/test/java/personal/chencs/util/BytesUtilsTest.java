package personal.chencs.util;

import org.junit.Assert;
import org.junit.Test;
import personal.chencs.codec.Hex;

import java.util.Arrays;
import java.util.Random;

public class BytesUtilsTest {

    @Test
    public void intToBytes() {
        int num = 0x11223344;

        byte[] expectResult = {(byte)0x11, (byte)0x22, (byte)0x33, (byte)0x44};
        Assert.assertTrue(Arrays.equals(BytesUtils.intToBytes(num, true), expectResult));

        expectResult = new byte[]{(byte)0x44, (byte)0x33, (byte)0x22, (byte)0x11};
        Assert.assertTrue(Arrays.equals(BytesUtils.intToBytes(num, false), expectResult));
    }

    @Test
    public void bytesToInt() {
        byte[] bytes = {(byte)0x11, (byte)0x22, (byte)0x33, (byte)0x44};

        int expectResult = 0x11223344;
        Assert.assertTrue(expectResult == BytesUtils.bytesToInt(bytes, true));

        expectResult = 0x44332211;
        Assert.assertTrue(expectResult == BytesUtils.bytesToInt(bytes, false));
    }

    @Test
    public void longToBytes() {
        long num = 0x1122334455667788L;

        byte[] expectResult = {(byte)0x11, (byte)0x22, (byte)0x33, (byte)0x44, (byte)0x55, (byte)0x66, (byte)0x77, (byte)0x88};
        Assert.assertTrue(Arrays.equals(BytesUtils.longToBytes(num, true), expectResult));

        expectResult = new byte[]{(byte)0x88, (byte)0x77, (byte)0x66, (byte)0x55, (byte)0x44, (byte)0x33, (byte)0x22, (byte)0x11};
        Assert.assertTrue(Arrays.equals(BytesUtils.longToBytes(num, false), expectResult));
    }

    @Test
    public void bytesToLong() {
        byte[] bytes = {(byte)0x11, (byte)0x22, (byte)0x33, (byte)0x44, (byte)0x55, (byte)0x66, (byte)0x77, (byte)0x88};

        long expectResult = 0x1122334455667788L;
        Assert.assertTrue(expectResult == BytesUtils.bytesToLong(bytes, true));

        expectResult = 0x8877665544332211L;
        Assert.assertTrue(expectResult == BytesUtils.bytesToLong(bytes, false));
    }

    @Test
    public void reverse() {
        byte[] bytes = {(byte)0x11, (byte)0x22, (byte)0x33, (byte)0x44, (byte)0x55, (byte)0x66, (byte)0x77, (byte)0x88};

        byte[] expectResult = new byte[]{(byte)0x88, (byte)0x77, (byte)0x66, (byte)0x55, (byte)0x44, (byte)0x33, (byte)0x22, (byte)0x11};
        Assert.assertTrue(Arrays.equals(BytesUtils.reverse(bytes), expectResult));
    }

    @Test
    public void concat() {
        byte[] bytes1 = {(byte)0x11, (byte)0x22, (byte)0x33, (byte)0x44};
        byte[] bytes2 = {(byte)0x55, (byte)0x66, (byte)0x77, (byte)0x88};

        byte[] expectResult = {(byte)0x11, (byte)0x22, (byte)0x33, (byte)0x44, (byte)0x55, (byte)0x66, (byte)0x77, (byte)0x88};
        Assert.assertTrue(Arrays.equals(BytesUtils.concat(bytes1, bytes2), expectResult));
    }

    @Test
    public void subBytes() {
        byte[] bytes = {(byte)0x11, (byte)0x22, (byte)0x33, (byte)0x44, (byte)0x55, (byte)0x66, (byte)0x77, (byte)0x88};

        byte[] expectResult = {(byte)0x55, (byte)0x66, (byte)0x77, (byte)0x88};
        Assert.assertTrue(Arrays.equals(BytesUtils.subBytes(bytes, 0x04, 0x08), expectResult));
    }

    @Test
    public void xor() {
        byte[] bytes1 = {(byte)0x11, (byte)0x22, (byte)0x33, (byte)0x44};
        byte[] bytes2 = {(byte)0x55, (byte)0x66, (byte)0x77, (byte)0x88};

        byte[] expectResult = {(byte)0x44, (byte)0x44, (byte)0x44, (byte)0xCC};
        Assert.assertTrue(Arrays.equals(BytesUtils.xor(bytes1, bytes2), expectResult));
    }

    @Test
    public void random() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Hex.encode(BytesUtils.random(4)));
        }

    }

}
