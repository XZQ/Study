package com.xzq.asm.type.cp;

import java.nio.ByteBuffer;

public interface ConstantInfoHandler {
    void read(ByteBuffer codeBuf) throws Exception;
}
