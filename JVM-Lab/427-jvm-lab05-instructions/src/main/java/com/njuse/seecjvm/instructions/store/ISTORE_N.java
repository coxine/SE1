package com.njuse.seecjvm.instructions.store;

import com.njuse.seecjvm.runtime.StackFrame;

public class ISTORE_N extends STORE_N {
    public ISTORE_N(int index) {
        checkIndex(index);
        this.index = index;
    }

    @Override
    public void execute(StackFrame frame) {
        frame.getLocalVars().setInt(index, frame.getOperandStack().popInt());
    }
}
