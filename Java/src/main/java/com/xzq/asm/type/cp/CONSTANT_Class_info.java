package com.xzq.asm.type.cp;

import com.xzq.asm.type.U1;
import com.xzq.asm.type.U2;

import java.nio.ByteBuffer;

public class CONSTANT_Class_info extends CpInfo {

    private U2 name_index;

    protected CONSTANT_Class_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        this.name_index = new U2(codeBuf.get(), codeBuf.get());
    }
}
