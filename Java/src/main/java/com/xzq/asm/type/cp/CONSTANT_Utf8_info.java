package com.xzq.asm.type.cp;

import com.xzq.asm.type.U1;
import com.xzq.asm.type.U2;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class CONSTANT_Utf8_info extends CpInfo {

    private U2 length; // 长度
    private byte[] bytes;// 长度为UTF-8编码的字符串

    protected CONSTANT_Utf8_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        length = new U2(codeBuf.get(), codeBuf.get());
        bytes = new byte[length.toInt()];
        codeBuf.get(bytes, 0, length.toInt());
    }

    public U2 getLength() {
        return length;
    }

    public byte[] getBytes() {
        return bytes;
    }

    @Override
    public String toString() {
        return super.toString() + ",length=" + length.toInt() + ",str=" + new String(bytes, StandardCharsets.UTF_8);
    }

}
