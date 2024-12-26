package com.xzq.asm.type.cp;


import com.xzq.asm.type.U1;
import com.xzq.asm.type.U4;

import java.nio.ByteBuffer;

public class CONSTANT_Integer_info extends CpInfo {

    private U4 bytes;

    public CONSTANT_Integer_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        bytes = new U4(codeBuf.get(),codeBuf.get(),codeBuf.get(),codeBuf.get());
    }

    public U4 getBytes() {
        return bytes;
    }

    @Override
    public String toString() {
        return "CONSTANT_Integer_info";
    }
}
