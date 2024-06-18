package com.njuse.seecjvm.memory.jclass;

import com.njuse.seecjvm.classloader.classfileparser.FieldInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Field extends ClassMember {
    public Field(FieldInfo info, JClass clazz) {
        this.clazz = clazz;
        this.accessFlags = info.getAccessFlags();
        this.name = info.getName();
        this.descriptor = info.getDescriptor();
    }
}
