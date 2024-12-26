package com.xzq.asm;


import com.xzq.asm.type.ClassFile;
import com.xzq.asm.type.cp.CpInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ClassFileAnalysisMain {

   private final static String TEXT_CLASS = "/home/xzq/documents/IdeaProjects/Java/out/production/Java/com/xzq/asm/TestClass.class";

    public static ByteBuffer readFile(String classFilePath) throws Exception {
        File file = new File(classFilePath);
        if (!file.exists()) {
            throw new Exception("file not exists!");
        }
        byte[] byteCodeBuf = new byte[4096];
        int lenght;
        try (InputStream in = new FileInputStream(file)) {
            lenght = in.read(byteCodeBuf);
        }
        if (lenght < 1) {
            throw new Exception("not read byte code.");
        }
        return ByteBuffer.wrap(byteCodeBuf, 0, lenght).asReadOnlyBuffer();
    }

    public static void main(String[] args) throws Exception {
        ByteBuffer codeBuf = readFile(TEXT_CLASS);
        ClassFile classFile = ClassFileAnalysiser.analysis(codeBuf);
        checkCp(classFile);
    }


    private static void checkCp(ClassFile classFile) {
        CpInfo[] cps = classFile.getConstant_pool();
        int index = 1;
        for (CpInfo cpInfo : cps) {
            if (cpInfo == null) {
                index++;
                continue;
            }
            System.out.println("#" + index + "==>" + cpInfo.getClass().getName());
            index++;
        }
    }

}
