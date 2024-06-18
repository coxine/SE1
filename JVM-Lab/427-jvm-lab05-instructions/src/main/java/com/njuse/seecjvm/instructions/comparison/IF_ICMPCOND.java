package com.njuse.seecjvm.instructions.comparison;

import com.njuse.seecjvm.instructions.base.BranchInstruction;
import com.njuse.seecjvm.runtime.StackFrame;

public abstract class IF_ICMPCOND extends BranchInstruction {
    /**
     * condition 方法是对具体条件的计算，当条件满足时返回true，否则返回false
     */
    @Override
    public void execute(StackFrame frame) {
        int val2 = frame.getOperandStack().popInt();
        int val1 = frame.getOperandStack().popInt();
        if (condition(val1, val2)) {
            jump(frame);
        }
    }

    protected abstract boolean condition(int v1, int v2);
}
