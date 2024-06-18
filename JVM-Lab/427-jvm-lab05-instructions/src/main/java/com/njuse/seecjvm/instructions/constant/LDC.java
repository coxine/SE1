package com.njuse.seecjvm.instructions.constant;

import com.njuse.seecjvm.instructions.base.Index8Instruction;
import com.njuse.seecjvm.memory.jclass.runtimeConstantPool.constant.Constant;
import com.njuse.seecjvm.memory.jclass.runtimeConstantPool.constant.wrapper.FloatWrapper;
import com.njuse.seecjvm.memory.jclass.runtimeConstantPool.constant.wrapper.IntWrapper;
import com.njuse.seecjvm.runtime.StackFrame;

public class LDC extends Index8Instruction {
    @Override
    public void execute(StackFrame frame) {
        loadConstant(frame, index);
    }

    public static void loadConstant(StackFrame frame, int index) {
        Constant constant = frame.getMethod().getClazz().getRuntimeConstantPool().getConstant(index);
        if (constant instanceof IntWrapper) {
            frame.getOperandStack().pushInt(((IntWrapper) constant).getValue());
        } else if (constant instanceof FloatWrapper) {
            frame.getOperandStack().pushFloat(((FloatWrapper) constant).getValue());
        } else
            throw new ClassFormatError();
    }
}
