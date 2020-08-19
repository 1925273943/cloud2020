package com.guigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    //泛型数据  传入的是什么类型的数据就返回什么类型的数据
    private T data;
    //定义一个没有传入类型的构造函数  因为有可能没有数据
    public CommonResult(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
