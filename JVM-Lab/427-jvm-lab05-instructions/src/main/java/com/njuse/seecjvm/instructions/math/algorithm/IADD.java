package com.njuse.seecjvm.instructions.math.algorithm;

import com.njuse.seecjvm.instructions.base.NoOperandsInstruction;
import com.njuse.seecjvm.runtime.StackFrame;

public class IADD extends NoOperandsInstruction {

    @Override
    public void execute(StackFrame frame) {
        int val1 = frame.getOperandStack().popInt();
        int val2 = frame.getOperandStack().popInt();
        frame.getOperandStack().pushInt(val1 + val2);
    }
}
