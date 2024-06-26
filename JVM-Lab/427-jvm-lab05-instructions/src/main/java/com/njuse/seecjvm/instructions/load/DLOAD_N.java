package com.njuse.seecjvm.instructions.load;

import com.njuse.seecjvm.runtime.StackFrame;

public class DLOAD_N extends LOAD_N {
    public DLOAD_N(int index) {
        checkIndex(index);
        this.index = index;
    }

    /**
     * 成员index是这条指令的参数，已经读取好了
     */
    @Override
    public void execute(StackFrame frame) {
        double val = frame.getLocalVars().getDouble(index);
        frame.getOperandStack().pushDouble(val);
    }
}
