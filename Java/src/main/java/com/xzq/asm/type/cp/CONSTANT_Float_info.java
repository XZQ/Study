package com.xzq.asm.type.cp;


import com.xzq.asm.type.U1;

public class CONSTANT_Float_info extends CONSTANT_Integer_info {

    public CONSTANT_Float_info(U1 tag) {
        super(tag);
    }

    @Override
    public String toString() {
        return "CONSTANT_Float_info";
    }

}
