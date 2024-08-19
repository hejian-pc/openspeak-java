package com.hejmls.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

@Getter
public enum UserSex implements IEnum<Integer> {
    MALE(1,"男"),
    FEMALE(0,"女");

    @EnumValue //标记数据库字段
    private final int value;
    private final String desc;

    UserSex(int value,String desc){
        this.value = value;
        this.desc = desc;
    }
    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.desc;
    }

}
