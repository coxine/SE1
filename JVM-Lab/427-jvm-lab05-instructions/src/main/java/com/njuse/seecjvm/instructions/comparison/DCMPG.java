package com.njuse.seecjvm.instructions.comparison;

import com.njuse.seecjvm.instructions.base.NoOperandsInstruction;
import com.njuse.seecjvm.runtime.StackFrame;

public class DCMPG extends NoOperandsInstruction {

    @Override
    public void execute(StackFrame frame) {
        double val2 = frame.getOperandStack().popDouble();
        double val1 = frame.getOperandStack().popDouble();
        if (Double.isNaN(val1) || Double.isNaN(val2)) {
            frame.getOperandStack().pushInt(1);
        } else if (val1 > val2) {
            frame.getOperandStack().pushInt(1);
        } else if (val1 == val2) {
            frame.getOperandStack().pushInt(0);
        } else {
            frame.getOperandStack().pushInt(-1);
        }
    }
}
