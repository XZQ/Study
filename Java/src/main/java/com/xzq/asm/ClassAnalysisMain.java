package com.xzq.asm;

import com.xzq.asm.type.ClassFile;
import com.xzq.asm.type.cp.CpInfo;

import java.nio.ByteBuffer;

public class ClassAnalysisMain {

    public static void main(String[] args) {
        try {
            testConstantPoolHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testConstantPoolHandler() throws Exception {
        ByteBuffer codeBuf = ClassFileAnalysisMain.readFile("/home/xzq/documents/IdeaProjects/Java/out/production/Java/com/xzq/asm/TestClass.class");
        ClassFile classFile = ClassFileAnalysiser.analysis(codeBuf);
        int cp_info_count = classFile.getConstant_pool_count().toInt();
        CpInfo[] cpInfo = classFile.getConstant_pool();
        System.out.println("常量池中常量项总数：" + cp_info_count + "  " + cpInfo.length);
        for (CpInfo cp : cpInfo) {
            if (cp != null) {
                System.out.println(cp);
            }
        }
    }
}
