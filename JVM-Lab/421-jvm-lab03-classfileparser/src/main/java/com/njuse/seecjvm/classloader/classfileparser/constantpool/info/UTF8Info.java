package com.njuse.seecjvm.classloader.classfileparser.constantpool.info;

import com.njuse.seecjvm.classloader.classfileparser.constantpool.ConstantPool;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.nio.ByteBuffer;

@Getter
public class UTF8Info extends ConstantPoolInfo {
    private int length;
    private byte[] bytes;
    private String myString;

    public UTF8Info(ConstantPool constantPool, int length, byte[] bytes) {
        super(constantPool);
        this.length = length;
        this.bytes = bytes;
        this.myString = new String(bytes);
        super.tag = ConstantPoolInfo.UTF8;
    }

    static Pair<UTF8Info, Integer> getInstance(ConstantPool constantPool, byte[] in, int offset) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(in, offset, 2);
        int length = byteBuffer.getInt();
        byte[] bytes = new byte[length];
        byteBuffer = ByteBuffer.wrap(in, offset + 2, length);
        byteBuffer.get(bytes);
        return Pair.of(new UTF8Info(constantPool, length, bytes), length + 2);
    }

    public String getString() {
        return myString;
    }
}
