package com.njuse.seecjvm.instructions.conversion;

import com.njuse.seecjvm.instructions.base.NoOperandsInstruction;
import com.njuse.seecjvm.runtime.StackFrame;

public class I2F extends NoOperandsInstruction {

    @Override
    public void execute(StackFrame frame) {
        int val = frame.getOperandStack().popInt();
        float ret = val;
        frame.getOperandStack().pushFloat(ret);
    }
}
