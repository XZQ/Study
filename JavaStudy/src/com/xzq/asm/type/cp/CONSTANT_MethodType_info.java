package com.xzq.asm.type.cp;

import com.xzq.asm.type.U1;
import com.xzq.asm.type.U2;

import java.nio.ByteBuffer;

public class CONSTANT_MethodType_info extends CpInfo {

    private U2 descriptor_index;

    public CONSTANT_MethodType_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        descriptor_index = new U2(codeBuf.get(), codeBuf.get());
    }

    public U2 getDescriptor_index() {
        return descriptor_index;
    }

    @Override
    public String toString() {
        return "CONSTANT_MethodType_info";
    }
}
