package com.njuse.seecjvm.instructions.base;

import java.nio.ByteBuffer;

import com.njuse.seecjvm.runtime.StackFrame;

public abstract class BranchInstruction extends Instruction {
    protected int offset;// type of offset is signed short

    public void fetchOperands(ByteBuffer reader) {
        offset = reader.getShort();
    }

    public void jump(StackFrame frame) {
        int nextPC = frame.getNextPC();
        // the length of the branch instruction is 3
        // 1 for opcode, 2 for offset
        frame.setNextPC(nextPC - 3 + offset);
    }

    public String toString() {
        return this.getClass().getSimpleName() + " offset: " + offset;
    }
}
