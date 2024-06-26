package com.njuse.seecjvm.instructions.comparison;

import com.njuse.seecjvm.instructions.base.BranchInstruction;
import com.njuse.seecjvm.runtime.StackFrame;

public abstract class IFCOND extends BranchInstruction {

    /**
     * 其中，condition 方法是对具体条件的计算，当条件满足时返回true，否则返回false
     */
    @Override
    public void execute(StackFrame frame) {
        if (condition(frame.getOperandStack().popInt())) {
            jump(frame);
        }
    }

    protected abstract boolean condition(int value);

}
