package com.njuse.seecjvm.memory.jclass;

import com.njuse.seecjvm.classloader.classfileparser.MethodInfo;
import com.njuse.seecjvm.classloader.classfileparser.attribute.CodeAttribute;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Method extends ClassMember {
    private int maxStack;
    private int maxLocal;
    private int argc;
    private byte[] code;

    public Method(MethodInfo info, JClass clazz) {
        this.clazz = clazz;
        accessFlags = info.getAccessFlags();
        name = info.getName();
        descriptor = info.getDescriptor();

        CodeAttribute codeAttribute = info.getCodeAttribute();
        if (codeAttribute != null) {
            maxLocal = codeAttribute.getMaxLocal();
            maxStack = codeAttribute.getMaxStack();
            code = codeAttribute.getCode();
        }
        argc = calculateArgcFromDescriptor(descriptor);
    }

    private int calculateArgcFromDescriptor(String descriptor) {
        int argLen = 0;
        for (int i = descriptor.indexOf('(') + 1; i < descriptor.indexOf(')'); i++) {
            char c = descriptor.charAt(i);
            switch (c) {
                case 'D':
                case 'J':
                    argLen += 2;
                    break;
                case 'B':
                case 'C':
                case 'F':
                case 'I':
                case 'S':
                case 'Z':
                    argLen++;
                    break;
                case 'L':
                    argLen++;
                    while (descriptor.charAt(i) != ';') {
                        i++;
                    }
                    break;
                case '[':
                    break;
                case 'V':
                    break;
                default:
                    throw new UnsupportedOperationException("Unknown descriptor type");
            }
        }
        return argLen;
    }
}
