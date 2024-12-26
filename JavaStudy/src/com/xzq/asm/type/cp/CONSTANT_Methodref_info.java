package com.xzq.asm.type.cp;

import com.xzq.asm.type.U1;

public class CONSTANT_Methodref_info extends CONSTANT_Fieldref_info {

    public CONSTANT_Methodref_info(U1 tag) {
        super(tag);
    }

    @Override
    public String toString() {
        return "CONSTANT_Methodref_info";
    }
}