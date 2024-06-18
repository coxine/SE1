package com.njuse.seecjvm.instructions.control;

import com.njuse.seecjvm.instructions.base.BranchInstruction;
import com.njuse.seecjvm.runtime.StackFrame;

public class GOTO extends BranchInstruction {

    @Override
    public void execute(StackFrame frame) {
        jump(frame);
    }
}
